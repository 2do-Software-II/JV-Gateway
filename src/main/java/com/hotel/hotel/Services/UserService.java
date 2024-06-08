package com.hotel.hotel.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

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
        user.setPassword(passwordEncoder.encode(createUserDto.getPassword()));
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

    public User update(String id, UpdateUserDto updateUserDto) {
        User user = getOne(id);

        if (updateUserDto.getRole() != null) {
            Optional<Role> role = roleRepository.findById(updateUserDto.getRole());
            if (role.isEmpty()) {
                throw new RuntimeException("Role not found");
            }
            user.setRole(role.get());
        }

        if (updateUserDto.getName() != null)
            user.setName(updateUserDto.getName());
        if (updateUserDto.getEmail() != null)
            user.setEmail(updateUserDto.getEmail());
        if (updateUserDto.getPassword() != null)
            user.setPassword(passwordEncoder.encode(updateUserDto.getPassword()));
        return repository.save(user);
    }

}
