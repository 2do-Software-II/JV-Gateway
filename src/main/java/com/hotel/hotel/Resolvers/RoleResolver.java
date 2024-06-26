package com.hotel.hotel.Resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import com.hotel.hotel.Dtos.CreateRoleDto;
import com.hotel.hotel.Dtos.UpdateRoleDto;
import com.hotel.hotel.Entities.Role;
import com.hotel.hotel.Services.RoleService;

import jakarta.validation.Valid;

@Controller
@Validated
public class RoleResolver {

    @Autowired
    private RoleService roleService;

    @QueryMapping
    public List<Role> getAllRoles() {
        return roleService.getAll();
    }

    // getone
    @QueryMapping
    public Role getOneRole(@Argument String id) {
        return roleService.getOne(id);
    }

    @MutationMapping
    public Role createRole(@Valid @Argument CreateRoleDto createRoleDto) {
        System.out.println(createRoleDto.getName());
        return roleService.create(createRoleDto);
    }

    @MutationMapping
    public Role updateRole(@Argument String id, @Argument UpdateRoleDto updateRoleDto) {
        return roleService.update(id, updateRoleDto);
    }
}
