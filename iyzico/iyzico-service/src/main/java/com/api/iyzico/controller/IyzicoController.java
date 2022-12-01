package com.api.iyzico.controller;

import com.api.iyzico.dto.InstallmentInfoDto;
import com.api.iyzico.dto.InstallmentRequestDto;
import com.api.iyzico.feign.IyzicoService;
import com.api.iyzico.operation.IyzicoOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class IyzicoController implements IyzicoService {
    @Autowired
    IyzicoOperation iyzicoOperation;

    @Override
    public InstallmentInfoDto getInstallmentInfo(InstallmentRequestDto installmentRequest) {
        return iyzicoOperation.getInstallmentInfo();
    }
}
