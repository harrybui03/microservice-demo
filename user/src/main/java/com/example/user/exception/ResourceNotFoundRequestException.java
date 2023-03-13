package com.example.user.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@Setter
public class ResourceNotFoundRequestException {
    private HttpStatus httpStatus;

    private String message;

    private ZonedDateTime timestamp;

    public ResourceNotFoundRequestException(String message) {
        this.message = message;
        this.timestamp = ZonedDateTime.now();
        httpStatus = HttpStatus.NOT_FOUND;
    }
}
