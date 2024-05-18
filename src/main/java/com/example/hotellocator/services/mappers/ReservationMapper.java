package com.example.hotellocator.services.mappers;

import com.example.hotellocator.controllers.dtos.reservation.ReservationDto;
import com.example.hotellocator.models.ReservationEntity;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {
    public ReservationDto toDto(ReservationEntity reservationEntity) {
        return ReservationDto.builder()
                .reservationStartDate(reservationEntity.getReservationStartDate())
                .reservationEndDate(reservationEntity.getReservationEndDate())
                .reservationUUID(reservationEntity.getReservationUUID())
                .userName(reservationEntity.getUser().getUserName())
                .roomNumber(reservationEntity.getRoom().getRoomNumber())
                .hotelName(reservationEntity.getRoom().getHotel().getHotelName())
                .reservationFeedback(reservationEntity.getReservationFeedback())
                .build();
    }
}
