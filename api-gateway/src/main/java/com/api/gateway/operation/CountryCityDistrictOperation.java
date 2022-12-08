package com.api.gateway.operation;

import com.api.customer.dto.address.CityDto;
import com.api.customer.dto.address.CountryDto;
import com.api.customer.dto.address.DistrictDto;
import com.api.customer.dto.address.PhoneCodeDto;
import com.api.customer.feign.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class CountryCityDistrictOperation {
    private final static Logger logger = LoggerFactory.getLogger(CountryCityDistrictOperation.class);
    @Autowired
    CustomerService customerService;

    public List<CountryDto> getCountries(){
        return customerService.getAllCountries();
    }
    public CountryDto getCountry(UUID uuid) throws Exception {
        return customerService.getCountry(uuid);
    }

    public List<CityDto> getCities(){
        return customerService.getAllCities();
    }
    public CityDto getCity(UUID uuid) throws Exception {
        return customerService.getCity(uuid);
    }

    public List<DistrictDto> getDistricts(){
        return customerService.getAllDistricts();
    }
    public DistrictDto getDistrict(UUID uuid) throws Exception {
        return customerService.getDistrict(uuid);
    }
}
