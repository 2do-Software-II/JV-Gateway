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

import com.hotel.hotel.Dtos.CreateResourceDto;
import com.hotel.hotel.Entities.Resource;

@Service
public class ResourceService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${API_SYSTEM}")
    private String URL;

    public List<Resource> getAll(String id) {
        try {
            String url = URL + "/resource/" + id;
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

    public Resource create(CreateResourceDto createResourceDto) {
        try {
            String url = URL + "/resource";
            ResponseEntity<Resource> response = restTemplate.postForEntity(url, createResourceDto, Resource.class);
            return response.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void delete(String id) {
        try {
            String url = URL + "/resource/" + id;
            restTemplate.exchange(url,
                    HttpMethod.DELETE, null,
                    new ParameterizedTypeReference<Resource>() {
                    });
        } catch (RestClientException e) {
            e.printStackTrace();
        }
    }

}
