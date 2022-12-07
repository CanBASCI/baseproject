package com.api.gateway.controller;

import com.api.customer.dto.address.PhoneCodeDto;
import com.api.gateway.operation.PhoneOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api_gw/phone", produces = MediaType.APPLICATION_JSON_VALUE)
public class PhoneController {
    @Autowired
    PhoneOperation phoneOperation;

    @GetMapping("/getPhoneCodes")
    ResponseEntity<List<PhoneCodeDto>> getPhoneCodes() {
        return ResponseEntity.ok().body(phoneOperation.getPhoneCodes());
    }
}
