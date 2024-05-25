package com.hotel.hotel.Resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.hotel.hotel.Dtos.CreateServiceDto;
import com.hotel.hotel.Dtos.UpdateServiceDto;
import com.hotel.hotel.Entities.Service;
import com.hotel.hotel.Services.ServiceService;

import jakarta.validation.Valid;

@Controller
public class ServiceResolver {

    @Autowired
    private ServiceService serviceService;

    @QueryMapping
    public List<Service> getAllServices() {
        return serviceService.getAll();
    }

    @QueryMapping
    public Service getOneService(@Argument String id) {
        return serviceService.getOne(id);
    }

    @MutationMapping
    public Service createService(@Valid @Argument CreateServiceDto createServiceDto) {
        return serviceService.create(createServiceDto);
    }

    @MutationMapping
    public Service updateService(@Argument String id, @Argument UpdateServiceDto updateServiceDto) {
        return serviceService.update(id, updateServiceDto);
    }
}
