package com.hotel.hotel.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Resource {
    @Id
    private String id;
    private String url;

    @DBRef
    private Room room;

    public Resource() {
    }

    public Resource(String url, Room room) {
        this.url = url;
        this.room = room;
    }

}
