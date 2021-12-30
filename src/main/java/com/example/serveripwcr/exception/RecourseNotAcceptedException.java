package com.example.serveripwcr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecourseNotAcceptedException extends Exception{
    private static final long serialVersionUID = 1L;

    public RecourseNotAcceptedException(String message){
        super(message);
    }
}
