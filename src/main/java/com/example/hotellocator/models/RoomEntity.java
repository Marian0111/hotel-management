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
@Table(name = "room")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Integer roomId;

    @Column(name = "room_number", nullable = false)
    private Integer roomNumber;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "room_type", nullable = false)
    private RoomType roomType;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "room_availability", nullable = false)
    private RoomAvailability roomAvailability;

    @Column(name = "room_price", nullable = false)
    private Double roomPrice;

    @Column(name = "room_UUID")
    private UUID roomUUID;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;

    @PrePersist
    public void generateUUID() {
        if (this.roomUUID == null)
            this.roomUUID = java.util.UUID.randomUUID();
    }
}
