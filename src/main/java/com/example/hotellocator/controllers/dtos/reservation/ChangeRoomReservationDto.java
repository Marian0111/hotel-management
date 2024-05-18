package com.example.hotellocator.controllers.dtos.reservation;

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
public class ChangeRoomReservationDto {
    @NotNull(message = "User can not be null!")
    private UUID userUUID;

    @NotNull(message = "Reservation can not be null!")
    private UUID reservationUUID;

    @NotNull(message = "Room can not be null!")
    private UUID roomUUID;
}
