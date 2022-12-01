package com.api.gateway.operation;

import com.api.iyzico.dto.InstallmentInfoDto;
import com.api.iyzico.dto.InstallmentRequestDto;
import com.api.iyzico.feign.IyzicoService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IyzicoOperation {
    private final static Logger logger = LoggerFactory.getLogger(UserOperation.class);
    @Autowired
    IyzicoService iyzicoService;

    public InstallmentInfoDto getInstallmentInfo(InstallmentRequestDto installmentRequest){

        logger.info("IyzicoOperation -> getInstallmentInfo");
        return iyzicoService.getInstallmentInfo(installmentRequest);
    }
}
