package com.example.hotellocator.controllers.dtos.reservation;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
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
public class BookRoomRequestDto {
    @JsonFormat(pattern = "yyyy-MM-dd-HH-mm-ss")
    @NotNull(message = "Reservation start date can not be null")
    private LocalDateTime reservationStartDate;

    @JsonFormat(pattern = "yyyy-MM-dd-HH-mm-ss")
    @NotNull(message = "Reservation end date can not be null")
    private LocalDateTime reservationEndDate;

    @NotNull(message = "User can not be null")
    private UUID userUUID;

    @NotNull(message = "Room can not be null")
    private UUID roomUUID;
}
