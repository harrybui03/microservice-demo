package com.example.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ResourceNotFoundHandler {
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ResourceNotFoundRequestException resourceNotFoundRequestException = new ResourceNotFoundRequestException(ex.getMessage());
        return new ResponseEntity<>(resourceNotFoundRequestException, HttpStatus.NOT_FOUND);
    }
}
