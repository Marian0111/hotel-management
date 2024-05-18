package com.example.hotellocator.controllers.dtos.user;

import com.example.hotellocator.models.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String userName;

    private String userEmail;

    private String userPassword;

    private Double userLatitude;

    private Double userLongitude;

    private UserRole userRole;

    private UUID userUUID;
}
