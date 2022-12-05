package com.api.customer.controller;

import com.api.customer.dto.CustomerCreateDto;
import com.api.customer.dto.CustomerDto;
import com.api.customer.feign.CustomerService;
import com.api.customer.operation.CustomerOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerController implements CustomerService {
    @Autowired
    CustomerOperation customerOperation;

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerOperation.getAllCustomers();
    }

    @Override
    public CustomerDto save(CustomerCreateDto customerCreateDto) {
        return customerOperation.save(customerCreateDto);
    }
}
