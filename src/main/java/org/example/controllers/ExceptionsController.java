package org.example.controllers;

import com.mongodb.MongoWriteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionsController {
    @ExceptionHandler(MongoWriteException.class)
    public ResponseEntity<String> handleNoSuchElementException  (MongoWriteException exception){
        if (exception.getCode()==11000) {
            String[] arr = exception.getError().getMessage().split(": ");
            if (arr[0].equals("E11000 duplicate key error collection")) {
                return new ResponseEntity("{ \"type\": " + arr[4], HttpStatus.FORBIDDEN);
            }
            else {
                return  new ResponseEntity<>("E11000", HttpStatus.BAD_REQUEST);
            }
        }
        else {
            return  new ResponseEntity<>(exception.getError().getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
