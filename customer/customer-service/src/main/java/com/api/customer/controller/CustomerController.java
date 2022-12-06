package com.api.customer.controller;

import com.api.customer.dto.CustomerCreateDto;
import com.api.customer.dto.CustomerDto;
import com.api.customer.dto.address.AddressDto;
import com.api.customer.feign.CustomerService;
import com.api.customer.operation.AddressOperation;
import com.api.customer.operation.CustomerOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class CustomerController implements CustomerService {
    @Autowired
    CustomerOperation customerOperation;

    @Autowired
    AddressOperation addressOperation;

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerOperation.getAllCustomers();
    }

    @Override
    public CustomerDto save(CustomerCreateDto customerCreateDto) {
        return customerOperation.save(customerCreateDto);
    }

    @Override
    public AddressDto getAddress(UUID id) throws Exception {
        return addressOperation.getAddressById(id);
    }
}
