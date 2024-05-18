package com.example.hotellocator.services;

import com.example.hotellocator.controllers.dtos.ResponseMessage;
import com.example.hotellocator.controllers.dtos.reservation.*;
import com.example.hotellocator.controllers.exceptions.*;
import com.example.hotellocator.models.ReservationEntity;
import com.example.hotellocator.models.RoomEntity;
import com.example.hotellocator.models.UserEntity;
import com.example.hotellocator.repositories.ReservationRepository;
import com.example.hotellocator.repositories.RoomRepository;
import com.example.hotellocator.repositories.UserRepository;
import com.example.hotellocator.services.mappers.ReservationMapper;
import com.example.hotellocator.services.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReservationService {
    public static final String USER_NOT_FOUND = "User not found!";
    public static final String ROOM_NOT_FOUND = "Room not found!";
    public static final String RESERVATION_NOT_FOUND = "Reservation not found!";
    public static final String DELETE_SUCCESSFULLY = "Reservation delete successfully!";
    public static final String INVALID_USER_RESERVATION = "The user didn't make this reservation!";
    public static final String DIDN_T_MAKE_THIS_RESERVATION = "The user didn't make this reservation!";
    public static final String TOO_LATE_TO_CHANGE_THE_ROOM_OF_RESERVATION = "It is too late to change the room of reservation";
    public static final String INTERSPERSED_DATE_INTERVALS = "The date interval is interspersed with another reservation interval date!";

    private final ReservationRepository reservationRepository;

    private final ReservationMapper reservationMapper;
    private final UserMapper userMapper;

    private final UserRepository userRepository;

    private final RoomRepository roomRepository;

    public List<ReservationDto> reservationsOfUser(ReservationsOfUserRequestDto resRequestDto) {
        UserEntity user = getUser(resRequestDto.getUserUUID());
        return reservationRepository
                .findByUser(user)
                .stream()
                .map(reservationMapper::toDto)
                .toList();
    }

    public ReservationDto bookRoom(BookRoomRequestDto bookRoomRequestDto) {
        UserEntity user = getUser(bookRoomRequestDto.getUserUUID());
        RoomEntity room = getRoom(bookRoomRequestDto.getRoomUUID());

        checkRoomAvailability(room, bookRoomRequestDto.getReservationStartDate(), bookRoomRequestDto.getReservationEndDate());

        ReservationEntity reservation = ReservationEntity.builder()
                .reservationStartDate(bookRoomRequestDto.getReservationStartDate())
                .reservationEndDate(bookRoomRequestDto.getReservationEndDate())
                .user(user)
                .room(room)
                .build();

        reservationRepository.save(reservation);

        return reservationMapper.toDto(reservation);
    }

    public ResponseMessage deleteReservation(DeleteReservationDto deleteReservation) {
        UserEntity user = getUser(deleteReservation.getUserUUID());
        ReservationEntity reservation = getReservation(deleteReservation.getReservationUUID());

        if (!reservation.getUser().getUserId().equals(user.getUserId()))
            throw new InvalidDeleteException(DIDN_T_MAKE_THIS_RESERVATION);

        reservationRepository.delete(reservation);
        return new ResponseMessage(DELETE_SUCCESSFULLY);
    }

    public ReservationDto changeReservation(ChangeRoomReservationDto changeRoomReservationDto) {
        UserEntity user = getUser(changeRoomReservationDto.getUserUUID());
        ReservationEntity reservation = getReservation(changeRoomReservationDto.getReservationUUID());
        RoomEntity room = getRoom(changeRoomReservationDto.getRoomUUID());

        if (!reservation.getUser().getUserId().equals(user.getUserId()))
            throw new InvalidDeleteException(INVALID_USER_RESERVATION);

        LocalDateTime newDate = LocalDateTime.now().plusHours(2);

        if (newDate.isAfter(reservation.getReservationStartDate()) || newDate.equals(reservation.getReservationStartDate())) {
            throw new InvalidDateIntervalException(TOO_LATE_TO_CHANGE_THE_ROOM_OF_RESERVATION);
        }

        checkRoomAvailability(room, reservation.getReservationStartDate(), reservation.getReservationEndDate());

        reservation.setRoom(room);
        reservationRepository.save(reservation);

        return reservationMapper.toDto(reservation);
    }

    public ReservationDto letAFeedback(ReservationFeedbackDto reservationFeedbackDto) {
        ReservationEntity reservation = getReservation(reservationFeedbackDto.getReservationUUID());
        reservation.setReservationFeedback(reservationFeedbackDto.getFeedbackMessage());
        reservationRepository.save(reservation);

        return reservationMapper.toDto(reservation);
    }

    private void checkRoomAvailability(RoomEntity room, LocalDateTime dateS1, LocalDateTime dateE1) {
        List<ReservationEntity> allReservations = reservationRepository.findByRoom(room);

        for (ReservationEntity res : allReservations) {
            LocalDateTime dateS2 = res.getReservationStartDate();
            LocalDateTime dateE2 = res.getReservationEndDate();
            if (!(dateE1.isBefore(dateS2) || dateE2.isBefore(dateS1) || dateE1.equals(dateS2) || dateE2.equals(dateS1))) {
                throw new InvalidDateIntervalException(INTERSPERSED_DATE_INTERVALS);
            }
        }
    }

    private UserEntity getUser(UUID userUUID) {
        return userRepository.findByUserUUID(userUUID)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
    }

    private RoomEntity getRoom(UUID roomUUID) {
        return roomRepository.findByRoomUUID(roomUUID)
                .orElseThrow(() -> new RoomNotFoundException(ROOM_NOT_FOUND));
    }

    private ReservationEntity getReservation(UUID reservationUUID) {
        return reservationRepository.findByReservationUUID(reservationUUID)
                .orElseThrow(() -> new ReservationNotFoundException(RESERVATION_NOT_FOUND));
    }
}
