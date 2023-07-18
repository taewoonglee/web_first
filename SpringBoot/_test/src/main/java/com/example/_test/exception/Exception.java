package com.example._test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Exception {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String exception400Handler(Exception400 e) {
        return e.getMessage();
    }
    @ExceptionHandler(Exception401.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String exception401Handler(Exception401 e)
    {
        return e.getMessage();
    }
    @ExceptionHandler(Exception404.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String exception404Handler(Exception404 e)
    {
        return e.getMessage();
    }

}