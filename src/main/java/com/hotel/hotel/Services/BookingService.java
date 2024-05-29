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

import com.hotel.hotel.Dtos.CreateBookingDto;
import com.hotel.hotel.Dtos.UpdateBookingDto;
import com.hotel.hotel.Entities.Booking;

@Service
public class BookingService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${API_SYSTEM}")
    private String URL;

    public List<Booking> getAll() {
        try {
            String url = URL + "/booking";
            ResponseEntity<List<Booking>> response = restTemplate.exchange(url,
                    HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Booking>>() {
                    });
            return response.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Booking create(CreateBookingDto createBookingDto) {
        try {
            String url = URL + "/booking";
            ResponseEntity<Booking> response = restTemplate.postForEntity(url, createBookingDto, Booking.class);
            return response.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Booking getOne(String id) {
        try {
            String url = URL + "/booking/" + id;
            ResponseEntity<Booking> response = restTemplate.exchange(url, HttpMethod.GET, null,
                    new ParameterizedTypeReference<Booking>() {
                    });
            return response.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Booking> getAllBookingsBy(String attr, String value) {
        try {
            String url = URL + "/booking/by/" + attr + "/" + value;
            ResponseEntity<List<Booking>> response = restTemplate.exchange(url,
                    HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Booking>>() {
                    });
            return response.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Booking update(String id, UpdateBookingDto updateBookingDto) {
        try {
            String url = URL + "/booking/" + id;
            restTemplate.put(url, updateBookingDto);
            return getOne(id);
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void delete(String id) {
        try {
            String url = URL + "/booking/" + id;
            restTemplate.delete(url);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
    }
}
