package com.api.gateway.operation;

import com.api.customer.dto.CustomerCreateDto;
import com.api.customer.dto.CustomerDto;
import com.api.customer.feign.CustomerService;
import com.api.gateway.dto.customer.CustomerCreate;
import com.api.gateway.mapper.CustomerMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerOperation {
    private final static Logger logger = LoggerFactory.getLogger(CustomerOperation.class);
    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerMapper customerMapper;

    public List<CustomerDto> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    public CustomerDto save(CustomerCreate customerCreate){
        CustomerCreateDto customerCreateDto = customerMapper.toDto(customerCreate);
        customerCreateDto.setUserName((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return customerService.save(customerCreateDto);
    }
}
