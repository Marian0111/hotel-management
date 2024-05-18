package com.example.hotellocator.services;

import com.example.hotellocator.controllers.dtos.hotel.HotelDto;
import com.example.hotellocator.controllers.dtos.hotel.HotelRequestDto;
import com.example.hotellocator.controllers.dtos.hotel.NearHotelsRequestDto;
import com.example.hotellocator.controllers.dtos.room.RoomDto;
import com.example.hotellocator.controllers.exceptions.HotelNotFoundException;
import com.example.hotellocator.controllers.exceptions.UserNotFoundException;
import com.example.hotellocator.models.HotelEntity;
import com.example.hotellocator.models.RoomAvailability;
import com.example.hotellocator.models.UserEntity;
import com.example.hotellocator.repositories.HotelRepository;
import com.example.hotellocator.repositories.RoomRepository;
import com.example.hotellocator.repositories.UserRepository;
import com.example.hotellocator.services.mappers.HotelMapper;
import com.example.hotellocator.services.mappers.RoomMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {
    public static final String HOTEL_NOT_FOUND = "Hotel not found!";
    public static final String USER_NOT_FOUND = "User not found!";
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;
    private final HotelMapper hotelMapper;
    private final RoomMapper roomMapper;

    public List<HotelDto> showAllHotels() {
        return hotelRepository.findAll().stream().map(hotelMapper::toDto).toList();
    }

    @Transactional
    public List<RoomDto> showRoomsOfHotel(HotelRequestDto hotelRequestDto) {
        HotelEntity hotel = getHotel(hotelRequestDto);

        return roomRepository
                .findByHotelAndAndRoomAvailability(hotel, RoomAvailability.AVAILABLE)
                .stream()
                .map(roomMapper::toDto)
                .toList();
    }

    public List<HotelDto> showNearestHotels(NearHotelsRequestDto nearHotelsRequestDto) {
        UserEntity user = getUser(nearHotelsRequestDto);

        List<HotelEntity> hotels = hotelRepository.findAll();
        List<HotelDto> nearestHotels = new ArrayList<>();

        double userLat = user.getUserLatitude();
        double userLon = user.getUserLongitude();
        double maxDistance = nearHotelsRequestDto.getDistance();

        for (HotelEntity hotel : hotels) {
            double hotelLat = hotel.getHotelLatitude();
            double hotelLon = hotel.getHotelLongitude();
            double distance = calculateDistanceInKilometers(userLat, userLon, hotelLat, hotelLon);
            if (distance <= maxDistance) {
                nearestHotels.add(hotelMapper.toDto(hotel));
            }
        }
        return nearestHotels;
    }


    private double calculateDistanceInKilometers(double userLat, double userLon, double hotelLat, double hotelLon) {
        double latToMeters = 111320.0;
        double lonToMeters = 111320.0 * Math.cos(Math.toRadians(userLat));

        double userLatMeters = userLat * latToMeters;
        double userLonMeters = userLon * lonToMeters;

        double hotelLatMeters = hotelLat * latToMeters;
        double hotelLonMeters = hotelLon * lonToMeters;

        double distanceMeters = Math.sqrt(Math.pow(userLatMeters - hotelLatMeters, 2) + Math.pow(userLonMeters - hotelLonMeters, 2));

        return distanceMeters / 1000.0;
    }

    private HotelEntity getHotel(HotelRequestDto hotelRequestDto) {
        return hotelRepository.findByHotelUUID(hotelRequestDto.getHotelUUID())
                .orElseThrow(() -> new HotelNotFoundException(HOTEL_NOT_FOUND));
    }

    private UserEntity getUser(NearHotelsRequestDto nearHotelsRequestDto) {
        return userRepository.findByUserUUID(nearHotelsRequestDto.getUserUUID())
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
    }
}
