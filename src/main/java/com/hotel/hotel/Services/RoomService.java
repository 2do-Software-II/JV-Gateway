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
import com.hotel.hotel.Dtos.UpdateRoomDto;
import com.hotel.hotel.Entities.Room;

@Service
public class RoomService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${API_SYSTEM}")
    private String URL;

    public List<Room> getAll() {
        try {
            String url = URL + "/room";
            ResponseEntity<List<Room>> response = restTemplate.exchange(url,
                    HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Room>>() {
                    });
            return response.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Room> getAllRoomsBy(String attr, String value) {
        try {
            String url = URL + "/room/by/" + attr + "/" + value;
            ResponseEntity<List<Room>> response = restTemplate.exchange(url,
                    HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Room>>() {
                    });
            return response.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Room create(CreateRoomDto createRoomDto) {
        try {
            String url = URL + "/room";
            ResponseEntity<Room> response = restTemplate.postForEntity(url, createRoomDto, Room.class);
            return response.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Room getOne(String id) {
        try {
            String url = URL + "/room/" + id;
            ResponseEntity<Room> response = restTemplate.exchange(url, HttpMethod.GET, null,
                    new ParameterizedTypeReference<Room>() {
                    });
            return response.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Room update(String id, UpdateRoomDto updateRoomDto) {
        try {
            String url = URL + "/room/" + id;
            restTemplate.put(url, updateRoomDto);
            return getOne(id);
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }
}
