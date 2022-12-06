package com.api.gateway.operation;

import com.api.customer.dto.address.AddressDto;
import com.api.customer.feign.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class AddressOperation {
    private final static Logger logger = LoggerFactory.getLogger(AddressOperation.class);
    @Autowired
    CustomerService customerService;

    public AddressDto getAddressById(UUID uuid) throws Exception {
        return customerService.getAddress(uuid);
    }

}
