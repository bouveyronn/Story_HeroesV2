package com.storyheroes.app.security;

//import com.storyheroes.app.exception.EntityConflictException;
//import com.storyheroes.app.exception.EntityConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalHandleException {
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleEntityNotFoundException(EntityNotFoundException entityNotFoundException){
        return entityNotFoundException.getMessage();
    }
}