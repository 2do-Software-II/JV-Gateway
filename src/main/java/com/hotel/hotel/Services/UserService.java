package com.hotel.hotel.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.Dtos.CreateUserDto;
import com.hotel.hotel.Entities.Role;
import com.hotel.hotel.Entities.User;
import com.hotel.hotel.Repositories.RoleRepository;
import com.hotel.hotel.Repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    public List<User> getAll() {
        return repository.findAll();
    }

    public void getById() {
    }

    public User create(CreateUserDto createUserDto) {
        Optional<Role> role = roleRepository.findById(createUserDto.getRole());
        if (role.isEmpty()) {
            throw new RuntimeException("Role not found");
        }
        User user = new User();
        user.setName(createUserDto.getName());
        user.setEmail(createUserDto.getEmail());
        user.setPassword(createUserDto.getPassword());
        user.setRole(role.get());
        return repository.save(user);
    }

}
