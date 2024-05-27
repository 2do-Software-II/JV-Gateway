package com.hotel.hotel.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomServiceEntity {

    @Id
    private String id;
    @DBRef
    private Room room;
    @DBRef
    private Service service;

    public RoomServiceEntity() {
    }

    public RoomServiceEntity(Room room, Service service) {
        this.room = room;
        this.service = service;
    }

}
