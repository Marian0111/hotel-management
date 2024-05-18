package com.example.hotellocator;

import com.example.hotellocator.models.*;
import com.example.hotellocator.repositories.HotelRepository;
import com.example.hotellocator.repositories.ReservationRepository;
import com.example.hotellocator.repositories.RoomRepository;
import com.example.hotellocator.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
@RequiredArgsConstructor
public class HotelLocatorApplication {
    private final UserRepository userRepository;

    private final HotelRepository hotelRepository;

    private final RoomRepository roomRepository;

    private final ReservationRepository reservationRepository;

    public static void main(String[] args) {
        SpringApplication.run(HotelLocatorApplication.class, args);
    }

    @PostConstruct
    public void setUp() {

        userRepository.save(
                UserEntity.builder()
                        .userName("Sergiu Dobrescu")
                        .userEmail("sergiu-dbr@gmail.ro")
                        .userRole(UserRole.ADMINISTRATOR)
                        .userPassword("qhgshfgyrf")
                        .userUUID(UUID.fromString("c27399a2-3431-493b-a300-4c2fa7c43bc2"))
                        .userLatitude(46.927566)
                        .userLongitude(23.598674)
                        .build()
        );

        userRepository.save(
                UserEntity.builder()
                        .userName("Ana Muscel")
                        .userEmail("ana_05maria@gmail.ro")
                        .userRole(UserRole.GUEST)
                        .userPassword("uh3br76wer")
                        .userUUID(UUID.fromString("f7017b3d-ab3e-4e50-96b3-bd056214d317"))
                        .userLatitude(46.9457)
                        .userLongitude(24.0899)
                        .build()
        );

        userRepository.save(
                UserEntity.builder()
                        .userName("Duna Gheorghe")
                        .userEmail("duna_ghimnm@yahoo.com")
                        .userRole(UserRole.GUEST)
                        .userPassword("834brewjfhgvd")
                        .userUUID(UUID.fromString("9b6480dd-f8c9-4173-8c89-ddca77e941e3"))
                        .userLatitude(46.935799)
                        .userLongitude(21.4375639)
                        .build()
        );

        HotelEntity hotel1 = HotelEntity.builder()
                .hotelName("Hotel Ramada")
                .hotelLatitude(46.764654252624204)
                .hotelLongitude(23.598674125224626)
                .hotelUUID(UUID.fromString("5ffedc23-7641-4b87-8c09-183d19ee606c"))
                .build();
        hotelRepository.save(hotel1);

        HotelEntity hotel2 = HotelEntity.builder()
                .hotelName("Grand Hotel Italia")
                .hotelLatitude(46.7522792440665)
                .hotelLongitude(23.605990381045697)
                .hotelUUID(UUID.fromString("7fdc9fe9-3c0d-4871-9712-69b24ce04aad"))
                .build();
        hotelRepository.save(hotel2);

        HotelEntity hotel3 = HotelEntity.builder()
                .hotelName("Hampton by Hilton")
                .hotelLatitude(46.77539900854998)
                .hotelLongitude(23.60182699638966)
                .hotelUUID(UUID.fromString("926622ff-e547-4860-81ef-90e32a7505c1"))
                .build();
        hotelRepository.save(hotel3);

        RoomEntity room1 = RoomEntity.builder()
                .roomNumber(210)
                .roomType(RoomType.values()[1])
                .roomPrice(200.0)
                .roomAvailability(RoomAvailability.values()[1])
                .hotel(hotel1)
                .roomUUID(UUID.fromString("b9b0d7c3-ca49-4284-9e85-c497ba4309d7"))
                .build();
        roomRepository.save(room1);

        RoomEntity room2 = RoomEntity.builder()
                .roomNumber(125)
                .roomType(RoomType.values()[0])
                .roomPrice(350.0)
                .roomAvailability(RoomAvailability.values()[1])
                .hotel(hotel1)
                .roomUUID(UUID.fromString("51618e67-c604-4222-8596-0df5bf233043"))
                .build();
        roomRepository.save(room2);

        RoomEntity room3 = RoomEntity.builder()
                .roomNumber(87)
                .roomType(RoomType.values()[0])
                .roomPrice(300.0)
                .roomAvailability(RoomAvailability.values()[0])
                .hotel(hotel1)
                .roomUUID(UUID.fromString("76877535-8a58-47a9-bad5-9f3b85966a71"))
                .build();
        roomRepository.save(room3);

        RoomEntity room4 = RoomEntity.builder()
                .roomNumber(41)
                .roomType(RoomType.values()[2])
                .roomPrice(240.0)
                .roomAvailability(RoomAvailability.values()[1])
                .hotel(hotel2)
                .roomUUID(UUID.fromString("bcbdaba9-1ba9-4b2f-8709-2368906afefb"))
                .build();
        roomRepository.save(room4);

        RoomEntity room5 = RoomEntity.builder()
                .roomNumber(32)
                .roomType(RoomType.values()[1])
                .roomPrice(410.0)
                .roomAvailability(RoomAvailability.values()[0])
                .hotel(hotel3)
                .roomUUID(UUID.fromString("2c6d34ac-275c-498a-8804-89b8c081c31c"))
                .build();
        roomRepository.save(room5);

        RoomEntity room6 = RoomEntity.builder()
                .roomNumber(21)
                .roomType(RoomType.values()[1])
                .roomPrice(350.0)
                .roomAvailability(RoomAvailability.values()[1])
                .hotel(hotel3)
                .roomUUID(UUID.fromString("0fa36a5f-48d1-4ec7-b305-0206e4e1da0a"))
                .build();
        roomRepository.save(room6);

        RoomEntity room7 = RoomEntity.builder()
                .roomNumber(32)
                .roomType(RoomType.values()[2])
                .roomPrice(300.0)
                .roomAvailability(RoomAvailability.values()[1])
                .hotel(hotel3)
                .roomUUID(UUID.fromString("c0a2ad04-448d-4f0b-b443-e3a3c8a27c91"))
                .build();
        roomRepository.save(room7);

    }
}
