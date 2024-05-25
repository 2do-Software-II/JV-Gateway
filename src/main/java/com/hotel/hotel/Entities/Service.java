package com.hotel.hotel.Entities;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Service {
    @Id
    private String id;

    private String name;
    private String description;

    public Service() {
    }

    public Service(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
