package com.hotel.hotel.Dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateRoleDto {
    @NotBlank
    private String name;

    @NotBlank
    private String description;
}
