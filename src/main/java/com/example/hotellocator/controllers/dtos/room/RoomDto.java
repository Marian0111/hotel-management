package com.example.hotellocator.controllers.dtos.room;

import com.example.hotellocator.models.RoomAvailability;
import com.example.hotellocator.models.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {
    private Integer roomNumber;

    private RoomType roomType;

    private RoomAvailability roomAvailability;

    private Double roomPrice;

    private UUID roomUUID;
}
