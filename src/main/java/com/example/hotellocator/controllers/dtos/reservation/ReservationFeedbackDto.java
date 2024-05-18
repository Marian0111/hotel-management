package com.example.hotellocator.controllers.dtos.reservation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationFeedbackDto {
    @NotNull(message = "Reservation can not be null!")
    private UUID reservationUUID;

    @NotBlank(message = "Feedback can not be null!")
    private String feedbackMessage;

}
