package com.example.hotellocator.controllers.exceptions;

public class InvalidDateIntervalException extends RuntimeException {
    public InvalidDateIntervalException(String message) {
        super(message);
    }
}
