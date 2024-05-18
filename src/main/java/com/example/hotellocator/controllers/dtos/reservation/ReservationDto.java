package com.example.hotellocator.controllers.dtos.reservation;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    @JsonFormat(pattern = "yyyy-MM-dd-HH-mm-ss")
    private LocalDateTime reservationStartDate;

    @JsonFormat(pattern = "yyyy-MM-dd-HH-mm-ss")
    private LocalDateTime reservationEndDate;

    private String userName;

    private Integer roomNumber;

    private String hotelName;

    private UUID reservationUUID;

    private String reservationFeedback;
}
