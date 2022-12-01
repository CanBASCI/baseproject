package com.api.iyzico.feign;

import com.api.iyzico.dto.InstallmentInfoDto;
import com.api.iyzico.dto.InstallmentRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "iyzico"
)
public interface IyzicoService {
    @GetMapping("api/iyzico/getInstallmentInfo")
    InstallmentInfoDto getInstallmentInfo(@SpringQueryMap InstallmentRequestDto installmentRequest);
}
