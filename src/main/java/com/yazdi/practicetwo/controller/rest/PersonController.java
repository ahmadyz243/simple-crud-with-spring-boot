package com.yazdi.practicetwo.controller.rest;

import com.yazdi.practicetwo.domain.Person;
import com.yazdi.practicetwo.dto.request.PersonDtoRequest;
import com.yazdi.practicetwo.dto.response.PersonDtoResponse;
import com.yazdi.practicetwo.exceptions.PersonNotExistsException;
import com.yazdi.practicetwo.mapper.PersonMapper;
import com.yazdi.practicetwo.service.PersonService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    private final Logger logger = LoggerFactory.getLogger(PersonController.class);
    private final PersonMapper mapper;
    private final PersonService service;


    @PostMapping("/save")
    public ResponseEntity<PersonDtoResponse> savePerson(@Valid @RequestBody PersonDtoRequest dtoRequest) throws ParseException {
        Person person = mapper.personDtoRequestToPerson(dtoRequest);
        person = service.savePerson(person);
        logger.info("person saved successfully");
        return new ResponseEntity<>(
                mapper.personToPersonDtoResponse(person)
                , HttpStatus.CREATED
        );

    }

    @PutMapping("/update")
    public ResponseEntity<String> updatePerson(@Valid @RequestBody PersonDtoRequest dtoRequest) throws ParseException, PersonNotExistsException {
        Person person = mapper.personDtoRequestToPerson(dtoRequest);
        service.updatePerson(person);
        logger.info("person updated successfully");
        return new ResponseEntity<>("person updated successfully", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-by-id")
    public ResponseEntity<String> deletePersonById(long personId){
        service.deletePersonById(personId);
        logger.info("person deleted successfully");
        return new ResponseEntity<>("person deleted successfully", HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<PersonDtoResponse>> getAll(){
        List<Person> people = service.getAll();
        List<PersonDtoResponse> dtoResponses = new ArrayList<>();
        people.forEach(person -> dtoResponses.add(mapper.personToPersonDtoResponse(person)));
        logger.info("getting people info");
        return new ResponseEntity<>(dtoResponses, HttpStatus.ACCEPTED);
    }

    @PostMapping("/search")
    public ResponseEntity<List<PersonDtoResponse>> search(@RequestBody PersonDtoRequest dtoRequest){
        List<Person> people = service.search(dtoRequest);
        List<PersonDtoResponse> dtoResponses = new ArrayList<>();
        people.forEach(person -> dtoResponses.add(mapper.personToPersonDtoResponse(person)));
        return new ResponseEntity<>(dtoResponses, HttpStatus.ACCEPTED);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file, HttpServletResponse response) {
        try {
            // Get the InputStream of the file
            InputStream inputStream = file.getInputStream();
            long fileSize = file.getSize();
            byte[] buffer = new byte[1024];
            int bytesRead;
            long totalBytesRead = 0;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                totalBytesRead += bytesRead;
                // Calculate progress percentage
                int progress = (int) ((totalBytesRead * 100) / fileSize);

                // Send progress back to the client
                response.getWriter().write("Upload progress: " + progress + "%");
                response.flushBuffer();
            }
            System.out.println("-------------------");
            return ResponseEntity.ok("File uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file");
        }
    }

}