package com.example.hotellocator.controllers;

import com.example.hotellocator.controllers.dtos.ResponseMessage;
import com.example.hotellocator.controllers.dtos.user.DeleteUserRequestDto;
import com.example.hotellocator.controllers.dtos.user.LoginRequestDto;
import com.example.hotellocator.controllers.dtos.user.RegisterRequestDto;
import com.example.hotellocator.controllers.dtos.user.UserDto;
import com.example.hotellocator.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> showAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/log-in")
    public ResponseEntity<UserDto> login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(userService.login(loginRequestDto));
    }

    @DeleteMapping("/delete-user")
    public ResponseEntity<ResponseMessage> deleteUser(@Valid @RequestBody DeleteUserRequestDto deleteUserRequestDto) {
        return ResponseEntity.ok(userService.deleteUser(deleteUserRequestDto));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@Valid @RequestBody RegisterRequestDto registerRequestDto) {
        return ResponseEntity.ok(userService.register(registerRequestDto));
    }

}
