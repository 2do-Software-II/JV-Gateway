package com.hotel.hotel.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserDto {

    private String name;

    private String password;

    private String email;

    private String role;

    public UpdateUserDto() {
    }

    public UpdateUserDto(String name, String password, String email, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.email = email;
    }

}
