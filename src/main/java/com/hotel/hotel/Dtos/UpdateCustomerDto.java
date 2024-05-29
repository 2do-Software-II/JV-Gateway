package com.hotel.hotel.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateCustomerDto {

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

}
