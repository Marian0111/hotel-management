package com.example.hotellocator.repositories;

import com.example.hotellocator.models.HotelEntity;
import com.example.hotellocator.models.RoomAvailability;
import com.example.hotellocator.models.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {
    Optional<RoomEntity> findByRoomUUID(UUID roomUUID);

    List<RoomEntity> findByHotelAndAndRoomAvailability(HotelEntity hotel, RoomAvailability availability);
}
