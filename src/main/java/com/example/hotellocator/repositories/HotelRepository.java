package com.example.hotellocator.repositories;

import com.example.hotellocator.models.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Integer> {
    Optional<HotelEntity> findByHotelUUID(UUID userUUID);
}
