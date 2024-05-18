package com.example.hotellocator.services.mappers;

import com.example.hotellocator.controllers.dtos.user.UserDto;
import com.example.hotellocator.models.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toDto(UserEntity user) {
        return UserDto.builder()
                .userName(user.getUserName())
                .userEmail(user.getUserEmail())
                .userPassword(user.getUserPassword())
                .userLatitude(user.getUserLatitude())
                .userLongitude(user.getUserLongitude())
                .userRole(user.getUserRole())
                .userUUID(user.getUserUUID())
                .build();
    }
}
