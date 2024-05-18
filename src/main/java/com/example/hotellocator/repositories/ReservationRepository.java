package com.example.hotellocator.repositories;

import com.example.hotellocator.models.ReservationEntity;
import com.example.hotellocator.models.RoomEntity;
import com.example.hotellocator.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer> {
    List<ReservationEntity> findByRoom(RoomEntity room);

    Optional<ReservationEntity> findByReservationUUID(UUID reservationUUID);

    List<ReservationEntity> findByUser(UserEntity user);
}
