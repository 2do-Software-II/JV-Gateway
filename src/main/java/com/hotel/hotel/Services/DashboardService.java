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

import com.hotel.hotel.Entities.Dashboard;
import com.hotel.hotel.Entities.One;
import com.hotel.hotel.Entities.Three;
import com.hotel.hotel.Entities.Two;

@Service
public class DashboardService {

    @Value("${API_DH}")
    private String URL;

    @Autowired
    private RestTemplate restTemplate;

    public Dashboard get() {
        try {
            String urlOne = URL + "/one";
            ResponseEntity<List<One>> response = restTemplate.exchange(urlOne,
                    HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<One>>() {
                    });
            List<One> one = response.getBody();

            String urlTwo = URL + "/two";
            ResponseEntity<List<Two>> responseTwo = restTemplate.exchange(urlTwo,
                    HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Two>>() {
                    });
            List<Two> two = responseTwo.getBody();

            String urlThree = URL + "/three";
            ResponseEntity<List<Three>> responseThree = restTemplate.exchange(urlThree,
                    HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Three>>() {
                    });
            List<Three> three = responseThree.getBody();

            Dashboard dashboard = new Dashboard();
            dashboard.setOptionOne(one);
            dashboard.setOptionTwo(two);
            dashboard.setOptionThree(three);
            return dashboard;
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }

    }

}
