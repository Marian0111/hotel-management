package com.example.hotellocator.controllers.dtos.hotel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelDto {
    private String hotelName;

    private Double hotelLatitude;

    private Double hotelLongitude;

    private UUID hotelUUID;
}
