package com.api.customer.feign;

import com.api.customer.dto.CustomerCreateDto;
import com.api.customer.dto.CustomerDto;
import com.api.customer.dto.address.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient(
        name = "customer"
)
public interface CustomerService {
    @GetMapping("api/customer/getAllCustomers")
    List<CustomerDto> getAllCustomers();

    @GetMapping("api/address/getCustomer/{id}")
    CustomerDto getCustomer(@PathVariable(value = "id") UUID id) throws Exception;

    @PostMapping("api/customer/save")
    CustomerDto save(@RequestBody CustomerCreateDto customerCreateDto);

    @GetMapping("api/address/getAddress/{id}")
    AddressDto getAddress(@PathVariable(value = "id") UUID id) throws Exception;

    @GetMapping("api/phone/getPhoneCodes")
    List<PhoneCodeDto> getPhoneCodes();

    @PostMapping("api/address/save")
    AddressDto save(@RequestBody AddressCreateDto addressCreateDto) throws Exception;

    @GetMapping("api/CustomerCityDistrict/getAllCountries")
    List<CountryDto> getAllCountries();
    @GetMapping("api/CustomerCityDistrict/getCountry/{id}")
    CountryDto getCountry(@PathVariable(value = "id") UUID id) throws Exception;

    @GetMapping("api/CustomerCityDistrict/getAllCities")
    List<CityDto> getAllCities();
    @GetMapping("api/CustomerCityDistrict/getCity/{id}")
    CityDto getCity(@PathVariable(value = "id") UUID id) throws Exception;

    @GetMapping("api/CustomerCityDistrict/getAllDistricts")
    List<DistrictDto> getAllDistricts();
    @GetMapping("api/CustomerCityDistrict/getDistrict/{id}")
    DistrictDto getDistrict(@PathVariable(value = "id") UUID id) throws Exception;
}
