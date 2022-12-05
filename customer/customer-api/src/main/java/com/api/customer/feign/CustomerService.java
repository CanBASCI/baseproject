package com.api.customer.feign;

import com.api.customer.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
        name = "customer"
)
public interface CustomerService {
    @GetMapping("api/customer/getAllCustomers")
    List<CustomerDto> getAllCustomers();
}
