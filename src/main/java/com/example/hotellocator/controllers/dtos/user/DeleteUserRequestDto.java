package com.example.hotellocator.controllers.dtos.user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteUserRequestDto {
    @NotNull(message = "Admin can not be null!")
    private UUID adminUUID;

    @NotNull(message = "User can not be null!")
    private UUID userUUID;
}
