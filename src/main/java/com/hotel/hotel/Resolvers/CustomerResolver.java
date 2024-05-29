package com.hotel.hotel.Resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.hotel.hotel.Dtos.CreateCustomerDto;
import com.hotel.hotel.Dtos.UpdateCustomerDto;
import com.hotel.hotel.Entities.Customer;
import com.hotel.hotel.Services.CustomerService;

@Controller
public class CustomerResolver {

    @Autowired
    private CustomerService customerService;

    @QueryMapping()
    public List<Customer> getAllCustomers() {
        return customerService.getAll();
    }

    @QueryMapping()
    public Customer getOneCustomer(@Argument String id) {
        return customerService.getOne(id);
    }

    @MutationMapping()
    public Customer createCustomer(@Argument CreateCustomerDto createCustomerDto) {
        return customerService.create(createCustomerDto);
    }

    @MutationMapping()
    public Customer updateCustomer(@Argument String id, @Argument UpdateCustomerDto updateCustomerDto) {
        return customerService.update(id, updateCustomerDto);
    }

    @MutationMapping()
    public void deleteCustomer(@Argument String id) {
        customerService.delete(id);
    }

}
