package com.hotel.hotel.Resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.hotel.hotel.Dtos.CreateRoomDto;
import com.hotel.hotel.Dtos.CreateRoomServiceDto;
import com.hotel.hotel.Dtos.UpdateRoomDto;
import com.hotel.hotel.Entities.Room;
import com.hotel.hotel.Entities.RoomServiceEntity;
import com.hotel.hotel.Services.RoomService;

import jakarta.validation.Valid;

@Controller
public class RoomResolver {

    @Autowired
    private RoomService roomService;

    @QueryMapping
    public List<Room> getAllRooms() {
        return roomService.getAll();
    }

    @QueryMapping
    public List<Room> getAllRoomsBy(@Argument String attr, @Argument String value) {
        return roomService.getAllRoomsBy(attr, value);
    }

    @QueryMapping
    public List<RoomServiceEntity> getServicesByRoom(@Argument String id) {
        return roomService.getServicesByRoom(id);
    }

    @QueryMapping
    public Room getOneRoom(@Argument String id) {
        return roomService.getOne(id);
    }

    @QueryMapping
    public List<Room> getAllRoomsRecommended(@Argument String id) {
        return roomService.getAllRoomsRecommended(id);
    }

    @MutationMapping
    public Room createRoom(@Valid @Argument CreateRoomDto createRoomDto) {
        return roomService.create(createRoomDto);
    }

    @MutationMapping
    public RoomServiceEntity addServices(@Argument CreateRoomServiceDto createRoomServiceDto) {
        return roomService.addServices(createRoomServiceDto);
    }

    @MutationMapping
    public Room updateRoom(@Argument String id, @Argument UpdateRoomDto updateRoomDto) {
        return roomService.update(id, updateRoomDto);
    }

}
