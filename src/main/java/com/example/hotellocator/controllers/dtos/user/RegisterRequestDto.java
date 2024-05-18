package com.example.hotellocator.controllers.dtos.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDto {
    @Pattern(regexp = "(^[A-Z][a-z]+)(([\\-\\s][A-Z][a-z]+)?)+$", message = "Invalid name!")
    @NotBlank(message = "User name can not be null!")
    private String userName;

    @Pattern(regexp = "(^[a-z0-9]+([\\.\\-\\_][a-z0-9]+)?@[a-z]+\\.[a-z]+$)", message = "Invalid email!")
    @NotBlank(message = "User email can not be null!")
    private String userEmail;

    @NotBlank(message = "User password can not be null!")
    private String userPassword;

    @NotNull(message = "User latitude position can not be null!")
    private Double userLatitude;

    @NotNull(message = "User longitude position can not be null!")
    private Double userLongitude;

}
