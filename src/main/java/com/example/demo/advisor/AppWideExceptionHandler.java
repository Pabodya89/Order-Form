package com.example.demo.advisor;

import com.example.demo.exception.NotFoundException;
import com.example.demo.util.mappers.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException e)
    {
        return new ResponseEntity(new StandardResponse(404,"Error",e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
