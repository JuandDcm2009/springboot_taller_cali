package com.ponscio.taller.infrastructure.adapter.in.controller;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException; 

import com.ponscio.taller.application.dto.ErrorCustom;
import com.ponscio.taller.application.exceptions.EntityNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorCustom> entityNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            new ErrorCustom(
                Date.valueOf(
                LocalDate.now()),
                "Entity Cant be found",
                ex.getMessage(), 
                HttpStatus.NOT_FOUND.value()
            )
        );
    }   

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorCustom> noResourceFoundException(NoResourceFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
            new ErrorCustom(
                Date.valueOf(
                LocalDate.now()),
                "Invalid path in the URL",
                ex.getMessage(), 
                HttpStatus.NOT_IMPLEMENTED.value()
            )
        );
    }   


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorCustom> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            new ErrorCustom(
                Date.valueOf(LocalDate.now()),
                "Invalid arguments from body",
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
            )
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorCustom> httpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            new ErrorCustom(
                Date.valueOf(LocalDate.now()),
                "Invalid JSON body",
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
            )
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorCustom> illegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(
            new ErrorCustom(
                Date.valueOf(LocalDate.now()),
                "Illegal Argument",
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
            )
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorCustom> exception(Exception ex) {
        return ResponseEntity.internalServerError().body(
            new ErrorCustom(
                Date.valueOf(LocalDate.now()),
                "Internal error",
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value()
            )
        );
    }


}
