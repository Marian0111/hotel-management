package com.example.hotellocator.services.mappers;

import com.example.hotellocator.controllers.dtos.hotel.HotelDto;
import com.example.hotellocator.models.HotelEntity;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {
    public HotelDto toDto(HotelEntity hotel) {
        return HotelDto.builder()
                .hotelName(hotel.getHotelName())
                .hotelLatitude(hotel.getHotelLatitude())
                .hotelLongitude(hotel.getHotelLongitude())
                .hotelUUID(hotel.getHotelUUID())
                .build();
    }
}
