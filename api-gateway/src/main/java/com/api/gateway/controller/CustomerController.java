package com.api.gateway.controller;

import com.api.customer.dto.CustomerCreateDto;
import com.api.customer.dto.CustomerDto;
import com.api.customer.dto.address.AddressDto;
import com.api.gateway.dto.customer.CustomerCreate;
import com.api.gateway.operation.CustomerOperation;
import com.api.user.dto.CreateRoleDto;
import com.api.user.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api_gw/customer", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {
    @Autowired
    CustomerOperation customerOperation;

    @GetMapping("/getAllCustomers")
    ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return ResponseEntity.ok().body(customerOperation.getAllCustomers());
    }

    @GetMapping("/getCustomer")
    ResponseEntity<CustomerDto> getCustomer(@RequestParam UUID id) throws Exception {
        return ResponseEntity.ok().body(customerOperation.getCustomerById(id));
    }

    @PostMapping("/save")
    ResponseEntity<CustomerDto> save(@RequestBody CustomerCreate customerCreateDto){
        return ResponseEntity.ok().body(customerOperation.save(customerCreateDto));
    }
}
