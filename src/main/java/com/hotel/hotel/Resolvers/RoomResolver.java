package com.hotel.hotel.Resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.hotel.hotel.Dtos.CreateRoomDto;
import com.hotel.hotel.Dtos.UpdateRoomDto;
import com.hotel.hotel.Entities.Room;
import com.hotel.hotel.Services.RoomService;

import jakarta.validation.Valid;

@Controller
public class RoomResolver {

    @Autowired
    private RoomService roomService;

    @QueryMapping
    public List<Room> getAllServices() {
        return roomService.getAll();
    }

    @QueryMapping
    public Room getOneService(@Argument String id) {
        return roomService.getOne(id);
    }

    @QueryMapping
    public List<Room> getAllRoomsBy(@Argument String attr, @Argument String value) {
        return roomService.getAllRoomsBy(attr, value);
    }

    @MutationMapping
    public Room createService(@Valid @Argument CreateRoomDto createRoomDto) {
        return roomService.create(createRoomDto);
    }

    @MutationMapping
    public Room updateService(@Argument String id, @Argument UpdateRoomDto updateRoomDto) {
        return roomService.update(id, updateRoomDto);
    }

}
