package com.example.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(value = {APIRequestException.class})
    public ResponseEntity<Object> handleBlogAPIException(APIRequestException ex) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        APIException APIException = new APIException(badRequest, ex.getMessage(), ZonedDateTime.now());
        return new ResponseEntity<>(APIException , badRequest);
    }
}
