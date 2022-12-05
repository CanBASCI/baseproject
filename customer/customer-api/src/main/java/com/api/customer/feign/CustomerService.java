package com.api.customer.feign;

import com.api.customer.dto.CustomerCreateDto;
import com.api.customer.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name = "customer"
)
public interface CustomerService {
    @GetMapping("api/customer/getAllCustomers")
    List<CustomerDto> getAllCustomers();

    @PostMapping("api/customer/save")
    CustomerDto save(@RequestBody CustomerCreateDto customerCreateDto);
}
