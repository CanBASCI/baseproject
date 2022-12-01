package com.api.gateway.controller;

import com.api.gateway.operation.IyzicoOperation;
import com.api.iyzico.dto.InstallmentInfoDto;
import com.api.iyzico.dto.InstallmentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api_gw/iyzico", produces = MediaType.APPLICATION_JSON_VALUE)
public class IyzicoController {
    @Autowired
    IyzicoOperation iyzicoOperation;

    @GetMapping("/getInstallmentInfo")
    ResponseEntity<InstallmentInfoDto> getInstallmentInfo(@RequestBody InstallmentRequestDto installmentRequest){
        return ResponseEntity.ok().body(iyzicoOperation.getInstallmentInfo(installmentRequest));
    }
}
