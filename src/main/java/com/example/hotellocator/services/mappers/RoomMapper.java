package com.example.hotellocator.services.mappers;

import com.example.hotellocator.controllers.dtos.room.RoomDto;
import com.example.hotellocator.models.RoomEntity;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {
    public RoomDto toDto(RoomEntity room) {
        return RoomDto.builder()
                .roomNumber(room.getRoomNumber())
                .roomPrice(room.getRoomPrice())
                .roomAvailability(room.getRoomAvailability())
                .roomType(room.getRoomType())
                .roomUUID(room.getRoomUUID())
                .build();
    }

}
