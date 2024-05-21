package com.hotel.hotel.Dtos;

import com.mongodb.lang.NonNull;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {
    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @NotBlank
    @Email
    private String email;

    @NonNull
    @Min(1)
    private int role;

    public CreateUserDto() {
    }

    public CreateUserDto(String name, String password, String email, int role) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.email = email;
    }
}
