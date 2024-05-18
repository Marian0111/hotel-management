package com.example.hotellocator.controllers.dtos.hotel;

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
public class HotelRequestDto {
    @NotBlank(message = "Hotel name can not be null!")
    private String hotelName;

    @NotNull(message = "Hotel UUID can not be null!")
    private UUID hotelUUID;
}
