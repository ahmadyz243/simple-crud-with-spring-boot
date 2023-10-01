package com.yazdi.practicetwo.controller.advice;

import com.yazdi.practicetwo.exceptions.AddressNotExistsException;
import com.yazdi.practicetwo.exceptions.AddressWithoutPersonIdException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class AddressExceptionHandler{

    private final Logger logger = LoggerFactory.getLogger(AddressExceptionHandler.class);


    @ExceptionHandler(AddressWithoutPersonIdException.class)
    public ResponseEntity<String> addressWithoutPersonIdException(){
        logger.error("address should belong to a person");
        return new ResponseEntity<>("address should belong to a person", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AddressNotExistsException.class)
    public ResponseEntity<String> addressNotFoundException(AddressNotExistsException e){
        logger.error(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}