package com.hotel.hotel.Resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import com.hotel.hotel.Dtos.CreateUserDto;
import com.hotel.hotel.Dtos.UpdateUserDto;
import com.hotel.hotel.Entities.User;
import com.hotel.hotel.Services.UserService;

import jakarta.validation.Valid;

@Controller
@Validated
public class UserResolver {

    @Autowired
    private UserService userService;

    @QueryMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @QueryMapping
    public User getOneUser(@Argument String id) {
        return userService.getOne(id);
    }

    @MutationMapping
    public User createUser(@Valid @Argument CreateUserDto createUserDto) {
        return userService.create(createUserDto);
    }

    @MutationMapping
    public User updateUser(@Argument String id, @Argument UpdateUserDto updateUserDto) {
        return userService.update(id, updateUserDto);
    }

}
