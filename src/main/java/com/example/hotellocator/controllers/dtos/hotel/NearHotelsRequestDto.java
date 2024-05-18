package com.example.hotellocator.controllers.dtos.hotel;

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
public class NearHotelsRequestDto {
    @NotNull(message = "User can not be null!")
    private UUID userUUID;

    @NotNull(message = "Distance can not be null!")
    private Double distance;
}
