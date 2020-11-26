package com.stoom.teste.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomExceptionSchema {

    private String message;

    public CustomExceptionSchema(String message) {
        this.message = message;
    }
}