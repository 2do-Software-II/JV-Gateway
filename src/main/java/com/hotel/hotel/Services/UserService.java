package com.hotel.hotel.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.Dtos.CreateUserDto;
import com.hotel.hotel.Dtos.UpdateUserDto;
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

    public User getOne(String id) {
        Optional<User> user = repository.findById(id);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        return user.get();
    }

    public User update(String id, UpdateUserDto createUserDto) {
        User user = getOne(id);

        if (createUserDto.getRole() != null) {
            Optional<Role> role = roleRepository.findById(createUserDto.getRole());
            if (role.isEmpty()) {
                throw new RuntimeException("Role not found");
            }
            user.setRole(role.get());
        }

        if (createUserDto.getName() != null)
            user.setName(createUserDto.getName());
        if (createUserDto.getEmail() != null)
            user.setEmail(createUserDto.getEmail());
        if (createUserDto.getPassword() != null)
            user.setPassword(createUserDto.getPassword());
        return repository.save(user);
    }

}
