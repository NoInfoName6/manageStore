package org.example.controllers;

import com.mongodb.MongoWriteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
