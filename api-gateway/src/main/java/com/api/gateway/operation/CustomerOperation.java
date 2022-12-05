package com.api.gateway.operation;

import com.api.customer.dto.CustomerDto;
import com.api.customer.feign.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerOperation {
    private final static Logger logger = LoggerFactory.getLogger(CustomerOperation.class);
    @Autowired
    CustomerService customerService;

    public List<CustomerDto> getAllCustomers(){
        return customerService.getAllCustomers();
    }
}
