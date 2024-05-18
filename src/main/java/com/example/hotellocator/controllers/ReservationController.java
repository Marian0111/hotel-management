package com.example.hotellocator.controllers;

import com.example.hotellocator.controllers.dtos.ResponseMessage;
import com.example.hotellocator.controllers.dtos.reservation.*;
import com.example.hotellocator.services.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<List<ReservationDto>> reservationsOfUser(@Valid @RequestBody ReservationsOfUserRequestDto resRequestDto) {
        return ResponseEntity.ok(reservationService.reservationsOfUser(resRequestDto));
    }

    @PostMapping("/book-a-room")
    public ResponseEntity<ReservationDto> bookRoom(@Valid @RequestBody BookRoomRequestDto bookRoomRequestDto) {
        return ResponseEntity.ok(reservationService.bookRoom(bookRoomRequestDto));
    }

    @DeleteMapping("/delete-reservation")
    public ResponseEntity<ResponseMessage> deleteReservation(@Valid @RequestBody DeleteReservationDto deleteReservationDto) {
        return ResponseEntity.ok(reservationService.deleteReservation(deleteReservationDto));
    }

    @PutMapping("/change-room-of-reservation")
    public ResponseEntity<ReservationDto> changeReservation(@Valid @RequestBody ChangeRoomReservationDto changeRoomReservationDto) {
        return ResponseEntity.ok(reservationService.changeReservation(changeRoomReservationDto));
    }

    @PutMapping("/let-a-feedback")
    public ResponseEntity<ReservationDto> letAFeedback(@Valid @RequestBody ReservationFeedbackDto reservationFeedbackDto) {
        return ResponseEntity.ok(reservationService.letAFeedback(reservationFeedbackDto));
    }
}
