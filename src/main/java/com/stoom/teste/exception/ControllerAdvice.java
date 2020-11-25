package com.stoom.teste.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Object> notFound(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomExceptionSchema(ex.getMessage()));
    }

    @ExceptionHandler(RequiredFieldException.class)
    public final ResponseEntity<Object> requiredField(RequiredFieldException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomExceptionSchema(ex.getMessage()));
    }

}
