package com.example.user.exception;

import org.springframework.http.HttpStatus;

public class APIRequestException extends RuntimeException {
    private HttpStatus httpStatus;

    public APIRequestException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
    }


