package com.stoom.teste.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("No address registered!");
    }

    public NotFoundException(Long id) {
        super("Address with id " + id + " not found!");
    }
}
