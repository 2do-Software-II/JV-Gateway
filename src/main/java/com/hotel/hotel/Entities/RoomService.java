package com.hotel.hotel.Entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomService {

    private String id;
    private Room room;
    private Service service;

    public RoomService() {
    }

    public RoomService(Room room, Service service) {
        this.room = room;
        this.service = service;
    }

}
