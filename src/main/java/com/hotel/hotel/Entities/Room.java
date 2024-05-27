package com.hotel.hotel.Entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {

    private String id;
    private int nroRoom;
    private String status;
    private int nroBeds;
    private int nroPersons;
    private String size;
    private float price;
    private String description;
    private String type;
    private String view;

    public Room() {
    }

    public Room(int nroRoom, String status, int nroBeds, int nroPersons, String size, int price, String description,
            String type, String view) {
        this.nroRoom = nroRoom;
        this.status = status;
        this.nroBeds = nroBeds;
        this.nroPersons = nroPersons;
        this.size = size;
        this.price = price;
        this.description = description;
        this.type = type;
        this.view = view;
    }

}
