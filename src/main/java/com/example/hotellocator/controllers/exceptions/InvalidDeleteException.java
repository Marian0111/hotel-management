package com.example.hotellocator.controllers.exceptions;

public class InvalidDeleteException extends RuntimeException {
    public InvalidDeleteException(String message) {
        super(message);
    }
}
