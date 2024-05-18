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
public class ReservationsOfUserRequestDto {
    @NotNull(message = "User UUID can not be null!")
    private UUID userUUID;
}
