package com.hotel.hotel.Global;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.Dtos.CreateBookingDto;
import com.hotel.hotel.Entities.Booking;
import com.hotel.hotel.Entities.Room;
import com.hotel.hotel.Entities.Service;
import com.hotel.hotel.Services.BookingService;
import com.hotel.hotel.Services.RoomService;
import com.hotel.hotel.Services.ServiceService;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/booking/{roomId}/{customerId}")
    public ResponseEntity<Booking> addBooking(
            @PathVariable String roomId,
            @PathVariable String customerId,
            @RequestParam String startDate,
            @RequestParam String endDate,
            @RequestParam float fullPayment) {
        System.out.println(roomId);
        System.out.println(customerId);
        System.out.println(startDate);
        System.out.println(endDate);
        System.out.println(fullPayment);
        String date = getCurrentDate();
        String time = getCurrentTime();
        CreateBookingDto createBookingDto = new CreateBookingDto(
                date,
                time,
                "PENDING",
                "",
                "",
                0,
                fullPayment,
                "PAYPAL",
                startDate,
                endDate,
                roomId,
                customerId);
        return ResponseEntity.ok(bookingService.create(createBookingDto));
    }

    private static String getCurrentDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return today.format(formatter);
    }

    public static String getCurrentTime() {
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return now.format(formatter);
    }

}
