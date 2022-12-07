package com.api.gateway.operation;

import com.api.customer.dto.address.PhoneCodeDto;
import com.api.customer.feign.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PhoneOperation {
    private final static Logger logger = LoggerFactory.getLogger(PhoneOperation.class);
    @Autowired
    CustomerService customerService;

    public List<PhoneCodeDto> getPhoneCodes(){
        return customerService.getPhoneCodes();
    }

}
