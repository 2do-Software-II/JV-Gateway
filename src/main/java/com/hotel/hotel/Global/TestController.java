package com.hotel.hotel.Global;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.Entities.Room;
import com.hotel.hotel.Entities.Service;
import com.hotel.hotel.Services.RoomService;
import com.hotel.hotel.Services.ServiceService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    @Autowired
    private RoomService roomService;
    @Autowired
    private ServiceService serviceService;

    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> rooms() {
        return ResponseEntity.ok(roomService.getAll());
    }

    @GetMapping("/services")
    public ResponseEntity<List<Service>> services() {
        return ResponseEntity.ok(serviceService.getAll());
    }

}
