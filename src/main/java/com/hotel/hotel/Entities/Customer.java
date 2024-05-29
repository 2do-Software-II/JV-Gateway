package com.hotel.hotel.Entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private String id;
    private String name;
    private String lastName;
    private String phone;
    private String address;
    private String ci;
    private String expedition;
    private String birthDate;
    private String nationality;
    private String gender;
    private String preference;
    private User user;

}
