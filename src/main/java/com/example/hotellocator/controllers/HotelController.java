package com.example.hotellocator.controllers;

import com.example.hotellocator.controllers.dtos.hotel.HotelDto;
import com.example.hotellocator.controllers.dtos.hotel.HotelRequestDto;
import com.example.hotellocator.controllers.dtos.hotel.NearHotelsRequestDto;
import com.example.hotellocator.controllers.dtos.room.RoomDto;
import com.example.hotellocator.services.HotelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;

    @GetMapping()
    public ResponseEntity<List<HotelDto>> showAllHotels() {
        return ResponseEntity.ok(hotelService.showAllHotels());
    }

    @PostMapping("/show-rooms-of-hotel")
    public ResponseEntity<List<RoomDto>> showRoomsOfHotel(@Valid @RequestBody HotelRequestDto hotelRequestDto) {
        return ResponseEntity.ok(hotelService.showRoomsOfHotel(hotelRequestDto));
    }

    @PostMapping("/show-nearest-hotels")
    public ResponseEntity<List<HotelDto>> showNearestHotels(@Valid @RequestBody NearHotelsRequestDto nearHotelsRequestDto) {
        return ResponseEntity.ok(hotelService.showNearestHotels(nearHotelsRequestDto));
    }


}
