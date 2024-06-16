package com.hotel.hotel.Global;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.Dtos.CreateBookingDto;
import com.hotel.hotel.Entities.Booking;
import com.hotel.hotel.Entities.Room;
import com.hotel.hotel.Entities.Service;
import com.hotel.hotel.Services.BookingService;
import com.hotel.hotel.Services.RoomService;
import com.hotel.hotel.Services.ServiceService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    @Autowired
    private RoomService roomService;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private BookingService bookingService;

    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> rooms() {
        return ResponseEntity.ok(roomService.getAll());
    }

    @GetMapping("/services")
    public ResponseEntity<List<Service>> services() {
        return ResponseEntity.ok(serviceService.getAll());
    }

    @PostMapping("/booking")
    public ResponseEntity<Booking> createBooking(@RequestBody CreateBookingDto createBookingDto) {
        return ResponseEntity.ok(bookingService.create(createBookingDto));
    }

}
