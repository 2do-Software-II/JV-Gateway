package com.hotel.hotel.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.Dtos.CreateRoleDto;
import com.hotel.hotel.Entities.Role;
import com.hotel.hotel.Repositories.RoleRepository;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;

    public List<Role> getAll() {
        return repository.findAll();
    }

    public void getById() {
    }

    public Role findByName(String name) {
        Optional<Role> role = repository.findByName(name);
        if (role.isEmpty()) {
            throw new RuntimeException("Role not found");
        }
        return role.get();
    }

    public Role create(CreateRoleDto createRoleDto) {
        Role role = new Role(
                createRoleDto.getName(),
                createRoleDto.getDescription());
        return repository.save(role);
    }
}
