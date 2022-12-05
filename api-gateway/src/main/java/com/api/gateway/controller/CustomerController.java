package com.api.gateway.controller;

import com.api.customer.dto.CustomerDto;
import com.api.gateway.operation.CustomerOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api_gw/customer", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {
    @Autowired
    CustomerOperation customerOperation;

    @GetMapping("/getAllCustomers")
    ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return ResponseEntity.ok().body(customerOperation.getAllCustomers());
    }
}
