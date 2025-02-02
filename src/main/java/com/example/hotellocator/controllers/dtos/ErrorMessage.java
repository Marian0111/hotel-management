package com.example.hotellocator.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorMessage {
    private LocalDateTime timestamp;

    private String message;

    private String description;
}
