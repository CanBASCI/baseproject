package com.api.gateway.controller;

import com.api.customer.dto.address.AddressDto;
import com.api.gateway.operation.AddressOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "api_gw/address", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressController {
    @Autowired
    AddressOperation addressOperation;

    @GetMapping("/getAddress")
    ResponseEntity<AddressDto> getAddress(@RequestParam UUID id) throws Exception {
        return ResponseEntity.ok().body(addressOperation.getAddressById(id));
    }
}
