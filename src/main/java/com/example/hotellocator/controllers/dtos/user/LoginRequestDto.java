package com.example.hotellocator.controllers.dtos.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {
    @Pattern(regexp = "(^[a-z0-9]+([\\.\\-\\_][a-z0-9]+)?@[a-z]+\\.[a-z]+$)", message = "Invalid email!")
    @NotBlank(message = "User email can not be null!")
    private String userEmail;

    @NotBlank(message = "User password can not be null!")
    private String userPassword;
}
