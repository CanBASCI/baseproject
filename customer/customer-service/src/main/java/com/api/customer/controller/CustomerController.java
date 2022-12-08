package com.api.customer.controller;

import com.api.customer.dto.CustomerCreateDto;
import com.api.customer.dto.CustomerDto;
import com.api.customer.dto.address.*;
import com.api.customer.feign.CustomerService;
import com.api.customer.operation.AddressOperation;
import com.api.customer.operation.CountryCityDistrictOperation;
import com.api.customer.operation.CustomerOperation;
import com.api.customer.operation.PhoneOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class CustomerController implements CustomerService {
    @Autowired
    CountryCityDistrictOperation countryCityDistrictOperation;
    @Autowired
    CustomerOperation customerOperation;
    @Autowired
    AddressOperation addressOperation;
    @Autowired
    PhoneOperation phoneOperation;

    //CUSTOMER
    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerOperation.getAllCustomers();
    }
    @Override
    public CustomerDto getCustomer(UUID id) throws Exception {
        return customerOperation.getCustomerById(id);
    }
    @Override
    public CustomerDto save(CustomerCreateDto customerCreateDto) {
        return customerOperation.save(customerCreateDto);
    }

    //ADDRESS
    @Override
    public AddressDto getAddress(UUID id) throws Exception {
        return addressOperation.getAddressById(id);
    }
    @Override
    public AddressDto save(AddressCreateDto addressCreateDto) throws Exception {
        return addressOperation.save(addressCreateDto);
    }

    //PHONE
    @Override
    public List<PhoneCodeDto> getPhoneCodes(){
        return phoneOperation.getPhoneCodes();
    }

    //COUNTRY-CITY-DISTRICT
    @Override
    public List<CountryDto> getAllCountries() {
        return countryCityDistrictOperation.getCountries();
    }
    @Override
    public CountryDto getCountry(UUID id) throws Exception {
        return countryCityDistrictOperation.getCountryById(id);
    }
    @Override
    public List<CityDto> getAllCities() {
        return countryCityDistrictOperation.getCities();
    }
    @Override
    public CityDto getCity(UUID id) throws Exception {
        return countryCityDistrictOperation.getCityById(id);
    }
    @Override
    public List<DistrictDto> getAllDistricts() {
        return countryCityDistrictOperation.getDistricts();
    }
    @Override
    public DistrictDto getDistrict(UUID id) throws Exception {
        return countryCityDistrictOperation.getDistrictById(id);
    }
}
