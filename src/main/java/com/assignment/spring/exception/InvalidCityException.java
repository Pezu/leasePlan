package com.assignment.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidCityException extends RuntimeException{

    public InvalidCityException() {

        super("Invalid city!");
    }
}
