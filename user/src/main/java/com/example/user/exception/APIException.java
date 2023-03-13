package com.example.user.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class APIException {
    private HttpStatus httpStatus;
    private String message;

    private ZonedDateTime timestamp;

    public APIException(String message , HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

}

