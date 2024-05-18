package com.example.hotellocator.repositories;

import com.example.hotellocator.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUserEmailAndUserPassword(String userEmail, String UserPassword);

    @Query("SELECT u FROM UserEntity u where u.userUUID = ?1")
    Optional<UserEntity> findByUserUUID(UUID userUUID);
}
