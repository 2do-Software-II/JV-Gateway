package com.hotel.hotel.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.hotel.hotel.Dtos.CreateServiceDto;
import com.hotel.hotel.Dtos.UpdateServiceDto;
import com.hotel.hotel.Entities.Service;

@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${API_SYSTEM}")
    private String URL;

    public List<Service> getAll() {
        try {
            String url = URL + "/services";
            ResponseEntity<List<Service>> response = restTemplate.exchange(url,
                    HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Service>>() {
                    });
            return response.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Service create(CreateServiceDto createServiceDto) {
        try {
            String url = URL + "/services";
            ResponseEntity<Service> response = restTemplate.postForEntity(url, createServiceDto, Service.class);
            return response.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Service getOne(String id) {
        try {
            String url = URL + "/services/" + id;
            ResponseEntity<Service> response = restTemplate.exchange(url, HttpMethod.GET, null,
                    new ParameterizedTypeReference<Service>() {
                    });
            return response.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Service update(String id, UpdateServiceDto updateServiceDto) {
        try {
            String url = URL + "/services/" + id;
            restTemplate.put(url, updateServiceDto);
            return getOne(id);
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }
}
