package com.example.hotellocator.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "hotel")
public class HotelEntity {
    @Id
    @Column(name = "hotel_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotelId;

    @Column(name = "hotel_name", nullable = false)
    private String hotelName;

    @Column(name = "hotel_latitude", nullable = false)
    private Double hotelLatitude;

    @Column(name = "hotel_longitude", nullable = false)
    private Double hotelLongitude;

    @Column(name = "hotel_UUID")
    private UUID hotelUUID;

    @PrePersist
    public void generateUUID() {
        if (this.hotelUUID == null)
            this.hotelUUID = java.util.UUID.randomUUID();
    }
}
