package com.api.iyzico.operation;

import com.api.iyzico.dto.*;
import com.api.iyzico.mapper.IyzicoMapper;
import com.api.iyzico.model.InstallmentInfo;
import com.api.iyzico.property.IyzicoProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class IyzicoOperation {

    @Autowired
    IyzicoProperties iyzicoProperties;

    @Autowired
    IyzicoMapper iyzicoMapper;

    public InstallmentInfoDto getInstallmentInfo(){

        RetrieveInstallmentInfoRequest retrieveInstallmentInfoRequest = RetrieveInstallmentInfoRequest.builder()
                .locale(LocaleType.TR.getValue())
                .conversationId("123456789")
                .binNumber("554960")
                .price(new BigDecimal("100"))
                .build();


        //Test for mapStruct
        InstallmentRequestDto installmentRequestDto = iyzicoMapper.toInstallmentDto(retrieveInstallmentInfoRequest);


        Options options = Options.builder()
                .apiKey(iyzicoProperties.getApiKey())
                .secretKey(iyzicoProperties.getSecretKey())
                .baseUrl(iyzicoProperties.getBaseUrl())
                .build();

        InstallmentInfo installmentInfo = InstallmentInfo.retrieve(retrieveInstallmentInfoRequest, options);

        return null;
    }
}
