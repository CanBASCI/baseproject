package com.api.customer.operation;

import com.api.core.exception.NotFoundException;
import com.api.customer.data.CustomerRepository;
import com.api.customer.data.entity.CustomerEntity;
import com.api.customer.dto.CustomerCreateDto;
import com.api.customer.dto.CustomerDto;
import com.api.customer.data.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CustomerOperation {
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    CustomerRepository customerRepository;

    public List<CustomerDto> getAllCustomers() {
        return customerMapper.toDtos(customerRepository.findAll());
    }

    public CustomerDto getCustomerById(UUID uuid) throws Exception{
        CustomerEntity customerEntity = customerRepository.findById(uuid).orElseThrow(() -> new NotFoundException("can not find customer"));
        return customerMapper.toDto(customerEntity);
    }

    public CustomerDto save(CustomerCreateDto customerCreateDto){
        CustomerEntity customerEntity = customerMapper.toEntity(customerCreateDto);
        CustomerEntity customer = customerRepository.save(customerEntity);
        return customerMapper.toDto(customer);
    }
}
