package com.hotel.hotel.Entities;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "User")
public class User {

    private String id;
    private String name;
    private String password;
    private String email;
    private int role;

    public User() {
    }

    public User(String name, String password, String email, int role) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.email = email;
    }
}
