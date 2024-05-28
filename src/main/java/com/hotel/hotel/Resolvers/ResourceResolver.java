package com.hotel.hotel.Resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import com.hotel.hotel.Dtos.CreateResourceDto;
import com.hotel.hotel.Entities.Resource;
import com.hotel.hotel.Services.ResourceService;

@Controller
@Validated
public class ResourceResolver {

    @Autowired
    private ResourceService resourceService;

    @QueryMapping
    public List<Resource> getAllResourcesByRoom(@Argument String id) {
        return resourceService.getAll(id);
    }

    @MutationMapping
    public Resource addResource(@Argument CreateResourceDto createResourceDto) {
        return resourceService.create(createResourceDto);
    }

    @MutationMapping
    public void deleteResource(@Argument String id) {
        resourceService.delete(id);
    }

}
