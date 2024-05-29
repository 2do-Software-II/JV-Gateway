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

import com.hotel.hotel.Dtos.CreateCustomerDto;
import com.hotel.hotel.Dtos.UpdateCustomerDto;
import com.hotel.hotel.Entities.Customer;

@Service
public class CustomerService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${API_SYSTEM}")
    private String URL;

    public List<Customer> getAll() {
        try {
            String url = URL + "/customer";
            ResponseEntity<List<Customer>> response = restTemplate.exchange(url,
                    HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Customer>>() {
                    });
            return response.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Customer create(CreateCustomerDto createCustomerDto) {
        try {
            String url = URL + "/customer";
            ResponseEntity<Customer> response = restTemplate.postForEntity(url, createCustomerDto, Customer.class);
            return response.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Customer getOne(String id) {
        try {
            String url = URL + "/customer/" + id;
            ResponseEntity<Customer> response = restTemplate.exchange(url, HttpMethod.GET, null,
                    new ParameterizedTypeReference<Customer>() {
                    });
            return response.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Customer update(String id, UpdateCustomerDto updateCustomerDto) {
        try {
            String url = URL + "/customer/" + id;
            restTemplate.put(url, updateCustomerDto);
            return getOne(id);
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void delete(String id) {
        try {
            String url = URL + "/customer/" + id;
            restTemplate.delete(url);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
    }
}
