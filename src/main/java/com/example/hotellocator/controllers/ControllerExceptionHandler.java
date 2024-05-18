package com.example.hotellocator.controllers;

import com.example.hotellocator.controllers.dtos.ErrorMessage;
import com.example.hotellocator.controllers.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage handleInvalidEmail(MethodArgumentNotValidException ex, WebRequest request) {
        return new ErrorMessage(
                LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage handleUserNotFound(UserNotFoundException ex, WebRequest request) {
        return new ErrorMessage(
                LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
    }

    @ExceptionHandler(HotelNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage handleHotelNotFound(HotelNotFoundException ex, WebRequest request) {
        return new ErrorMessage(
                LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
    }

    @ExceptionHandler(RoomNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage handleRoomNotFound(RoomNotFoundException ex, WebRequest request) {
        return new ErrorMessage(
                LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
    }

    @ExceptionHandler(InvalidDateIntervalException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorMessage handleInvalidDateInterval(InvalidDateIntervalException ex, WebRequest request) {
        return new ErrorMessage(
                LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
    }

    @ExceptionHandler(ReservationNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage handleReservationNotFound(ReservationNotFoundException ex, WebRequest request) {
        return new ErrorMessage(
                LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
    }

    @ExceptionHandler(InvalidDeleteException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorMessage handleInvalidDelete(InvalidDeleteException ex, WebRequest request) {
        return new ErrorMessage(
                LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
    }
}
