package com.api.gateway.controller;

import com.api.customer.dto.address.CityDto;
import com.api.customer.dto.address.CountryDto;
import com.api.customer.dto.address.DistrictDto;
import com.api.gateway.operation.CountryCityDistrictOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api_gw/country_city_district", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryCityDistrictController {
    @Autowired
    CountryCityDistrictOperation countryCityDistrictOperation;

    @GetMapping("/getCountries")
    ResponseEntity<List<CountryDto>> getCountries() {
        return ResponseEntity.ok().body(countryCityDistrictOperation.getCountries());
    }

    @GetMapping("/getCountry")
    ResponseEntity<CountryDto> getCountry(@RequestParam UUID uuid) throws Exception {
        return ResponseEntity.ok().body(countryCityDistrictOperation.getCountry(uuid));
    }

    @GetMapping("/getCities")
    ResponseEntity<List<CityDto>> getCities() {
        return ResponseEntity.ok().body(countryCityDistrictOperation.getCities());
    }

    @GetMapping("/getCity")
    ResponseEntity<CityDto> getCity(@RequestParam UUID uuid) throws Exception {
        return ResponseEntity.ok().body(countryCityDistrictOperation.getCity(uuid));
    }

    @GetMapping("/getDistricts")
    ResponseEntity<List<DistrictDto>> getDistricts() {
        return ResponseEntity.ok().body(countryCityDistrictOperation.getDistricts());
    }

    @GetMapping("/getDistrict")
    ResponseEntity<DistrictDto> getDistrict(@RequestParam UUID uuid) throws Exception {
        return ResponseEntity.ok().body(countryCityDistrictOperation.getDistrict(uuid));
    }
}
