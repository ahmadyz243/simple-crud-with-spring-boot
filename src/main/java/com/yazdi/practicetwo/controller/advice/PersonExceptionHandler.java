package com.yazdi.practicetwo.controller.advice;

import com.yazdi.practicetwo.exceptions.PersonNotExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.ParseException;

@ControllerAdvice
public class PersonExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(PersonExceptionHandler.class);


    @ExceptionHandler(value = ParseException.class)
    public ResponseEntity<String> birthDateException(){
        logger.error("birthdate format should be like \"yyyy/MM/dd\" ");
        return new ResponseEntity<>("birthdate format should be like \"yyyy/MM/dd\" ", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = PersonNotExistsException.class)
    public ResponseEntity<String> updatePersonException(){
        logger.error("person id not exists");
        return new ResponseEntity<>("person id not exists", HttpStatus.BAD_REQUEST);
    }

}