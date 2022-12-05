package com.api.customer.operation;

import com.api.customer.data.CustomerRepository;
import com.api.customer.data.entity.CustomerEntity;
import com.api.customer.dto.CustomerCreateDto;
import com.api.customer.dto.CustomerDto;
import com.api.customer.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerOperation {
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    CustomerRepository customerRepository;

    public List<CustomerDto> getAllCustomers() {
        return customerMapper.toDtos(customerRepository.findAll());
    }

    public CustomerDto save(CustomerCreateDto customerCreateDto){
        CustomerEntity customerEntity = customerMapper.toEntity(customerCreateDto);
        customerEntity.setIsActive(true);
        CustomerEntity customer = customerRepository.save(customerEntity);
        return customerMapper.toDto(customer);
    }
}
