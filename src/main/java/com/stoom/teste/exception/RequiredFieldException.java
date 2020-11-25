package com.stoom.teste.exception;

public class RequiredFieldException extends RuntimeException {
    public RequiredFieldException(String message) {
        super("Required field! " + message);
    }
}
