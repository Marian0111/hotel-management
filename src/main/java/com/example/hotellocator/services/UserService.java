package com.example.hotellocator.services;

import com.example.hotellocator.controllers.dtos.ResponseMessage;
import com.example.hotellocator.controllers.dtos.user.DeleteUserRequestDto;
import com.example.hotellocator.controllers.dtos.user.LoginRequestDto;
import com.example.hotellocator.controllers.dtos.user.RegisterRequestDto;
import com.example.hotellocator.controllers.dtos.user.UserDto;
import com.example.hotellocator.controllers.exceptions.UserNotFoundException;
import com.example.hotellocator.models.UserEntity;
import com.example.hotellocator.models.UserRole;
import com.example.hotellocator.repositories.UserRepository;
import com.example.hotellocator.services.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    public static final String USER_NOT_FOUND = "User not found!";
    public static final String ADMINISTRATOR_NOT_FOUND = "Administrator not found!";
    public static final String GUESTS_CAN_T_DELETE_OTHER_USERS = "Guests can't delete other users!";
    public static final String DELETED_SUCCESSFULLY = "User deleted successfully!";

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    public UserDto login(LoginRequestDto loginRequestDto) {
        UserEntity user = getUser(loginRequestDto);
        return userMapper.toDto(user);
    }

    public ResponseMessage deleteUser(DeleteUserRequestDto deleteUserRequestDto) {
        UserEntity admin = getAdmin(deleteUserRequestDto.getAdminUUID());
        UserEntity user = getUser(deleteUserRequestDto.getUserUUID());

        if (!admin.getUserRole().equals(UserRole.ADMINISTRATOR)) {
            throw new UserNotFoundException(GUESTS_CAN_T_DELETE_OTHER_USERS);
        }

        userRepository.delete(user);
        return new ResponseMessage(DELETED_SUCCESSFULLY);
    }

    public UserDto register(RegisterRequestDto registerRequestDto) {
        UserEntity newUser = UserEntity.builder()
                .userName(registerRequestDto.getUserName())
                .userEmail(registerRequestDto.getUserEmail())
                .userPassword(registerRequestDto.getUserPassword())
                .userLatitude(registerRequestDto.getUserLatitude())
                .userLongitude(registerRequestDto.getUserLongitude())
                .userRole(UserRole.GUEST)
                .build();

        userRepository.save(newUser);
        return userMapper.toDto(newUser);
    }

    private UserEntity getUser(UUID userUUID) {
        return userRepository.findByUserUUID(userUUID)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
    }

    private UserEntity getUser(LoginRequestDto loginRequestDto) {
        return userRepository.findByUserEmailAndUserPassword(loginRequestDto.getUserEmail(), Base64.getEncoder().encodeToString(loginRequestDto.getUserPassword().getBytes()))
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
    }

    private UserEntity getAdmin(UUID userUUID) {
        return userRepository.findByUserUUID(userUUID)
                .orElseThrow(() -> new UserNotFoundException(ADMINISTRATOR_NOT_FOUND));
    }

}
