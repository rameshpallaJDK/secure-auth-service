package com.miniProj.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) 
public class InvalidRequestException extends RuntimeException {

    // Constructor to accept a custom message (e.g., "New password and confirm password do not match")
    public InvalidRequestException(String message) {
        super(message);
    }
}
