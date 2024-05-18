package com.example.hotellocator.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservation")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Integer reservationId;

    @Column(name = "reservation_start_date", nullable = false)
    private LocalDateTime reservationStartDate;

    @Column(name = "reservation_end_date", nullable = false)
    private LocalDateTime reservationEndDate;

    @Column(name = "reservation_feedback")
    private String reservationFeedback;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity room;

    @Column(name = "reservation_UUID")
    private UUID reservationUUID;

    @PrePersist
    public void generateUUID() {
        if (this.reservationUUID == null)
            this.reservationUUID = java.util.UUID.randomUUID();
    }

}
