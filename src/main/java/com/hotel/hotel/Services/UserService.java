package com.hotel.hotel.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.Dtos.CreateUserDto;
import com.hotel.hotel.Entities.User;
import com.hotel.hotel.Repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAll() {
        return repository.findAll();
    }

    public void getById() {
        // TODO implement here
    }

    public User create(CreateUserDto createUserDto) {
        User user = new User(
                createUserDto.getName(),
                createUserDto.getPassword(),
                createUserDto.getEmail(),
                createUserDto.getRole());
        return repository.save(user);
    }

    // private int autoincrementId() {
    // List<User> users = repository.findAll();
    // if (users.isEmpty()) {
    // return 1;
    // }
    // return users.get(users.size() - 1).getId() + 1;
    // }
}
