package com.hotel.hotel.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.hotel.hotel.Dtos.CreateRoomDto;
import com.hotel.hotel.Dtos.CreateRoomServiceDto;
import com.hotel.hotel.Dtos.UpdateRoomDto;
import com.hotel.hotel.Entities.Resource;
import com.hotel.hotel.Entities.Room;
import com.hotel.hotel.Entities.RoomServiceEntity;

@Service
public class RoomService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${API_IA}")
    private String URL_IA;

    @Value("${API_SYSTEM}")
    private String URL_SYSTEM;

    public List<Room> getAll() {
        try {
            String url = URL_SYSTEM + "/room";
            ResponseEntity<List<Room>> response = restTemplate.exchange(url,
                    HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Room>>() {
                    });
            List<Room> rooms = response.getBody();
            for (Room room : rooms) {
                room.setServices(getServicesByRoom(room.getId()));
                room.setResources(getResourcesByRoom(room.getId()));
            }
            return rooms;
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Room> getAllRoomsBy(String attr, String value) {
        try {
            String url = URL_SYSTEM + "/room/by/" + attr + "/" + value;
            ResponseEntity<List<Room>> response = restTemplate.exchange(url,
                    HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Room>>() {
                    });
            List<Room> rooms = response.getBody();
            for (Room room : rooms) {
                room.setServices(getServicesByRoom(room.getId()));
                room.setResources(getResourcesByRoom(room.getId()));
            }
            return rooms;
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Room create(CreateRoomDto createRoomDto) {
        try {
            String url = URL_SYSTEM + "/room";
            ResponseEntity<Room> response = restTemplate.postForEntity(url, createRoomDto, Room.class);
            return response.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Room getOne(String id) {
        try {
            String url = URL_SYSTEM + "/room/" + id;
            ResponseEntity<Room> response = restTemplate.exchange(url, HttpMethod.GET, null,
                    new ParameterizedTypeReference<Room>() {
                    });
            Room room = response.getBody();
            room.setServices(getServicesByRoom(room.getId()));
            room.setResources(getResourcesByRoom(room.getId()));
            return room;
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Room update(String id, UpdateRoomDto updateRoomDto) {
        try {
            String url = URL_SYSTEM + "/room/" + id;
            restTemplate.put(url, updateRoomDto);
            return getOne(id);
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<RoomServiceEntity> getServicesByRoom(String id) {
        try {
            String url = URL_SYSTEM + "/room/services/" + id;
            ResponseEntity<List<RoomServiceEntity>> response = restTemplate.exchange(url,
                    HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<RoomServiceEntity>>() {
                    });
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public RoomServiceEntity addServices(CreateRoomServiceDto createRoomServiceDto) {
        try {
            String url = URL_SYSTEM + "/room/service";
            ResponseEntity<RoomServiceEntity> response = restTemplate.postForEntity(url, createRoomServiceDto,
                    RoomServiceEntity.class);
            return response.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Resource> getResourcesByRoom(String id) {
        try {
            String url = URL_SYSTEM + "/resource/" + id;
            ResponseEntity<List<Resource>> response = restTemplate.exchange(url,
                    HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Resource>>() {
                    });
            return response.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Room> getAllRoomsRecommended(String id) {
        try {
            // String url = URL_IA + "/room/recommended/" + id;
            String url = URL_SYSTEM + "/room";
            ResponseEntity<List<Room>> response = restTemplate.exchange(url,
                    HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Room>>() {
                    });
            List<Room> rooms = response.getBody();
            for (Room room : rooms) {
                room.setServices(getServicesByRoom(room.getId()));
                room.setResources(getResourcesByRoom(room.getId()));
            }
            return rooms;
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

}
