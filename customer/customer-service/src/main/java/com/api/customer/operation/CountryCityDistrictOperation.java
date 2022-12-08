package com.api.customer.operation;

import com.api.customer.data.entity.address.*;
import com.api.customer.dto.address.CityDto;
import com.api.customer.dto.address.CountryDto;
import com.api.customer.dto.address.DistrictDto;
import com.api.customer.mapper.CountryCityDistrictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CountryCityDistrictOperation {
    @Autowired
    CountryCityDistrictMapper countryCityDistrictMapper;
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    DistrictRepository districtRepository;

    public List<CountryDto> getCountries(){
        List<CountryEntity> countryEntities = countryRepository.findAll();
        return countryCityDistrictMapper.toCountryDtos(countryEntities);
    }

    public CountryDto getCountryById(UUID uuid) throws Exception {
        CountryEntity countryEntity = countryRepository.findById(uuid).orElseThrow(() -> new Exception("can not find country"));
        return countryCityDistrictMapper.toCountryDto(countryEntity);
    }

    public List<CityDto> getCities(){
        return countryCityDistrictMapper.toCityDtos(cityRepository.findAll());
    }

    public CityDto getCityById(UUID uuid) throws Exception {
        CityEntity cityEntity = cityRepository.findById(uuid).orElseThrow(() -> new Exception("can not find city"));
        return countryCityDistrictMapper.toCityDto(cityEntity);
    }

    public List<DistrictDto> getDistricts(){
        return countryCityDistrictMapper.toDistrictDtos(districtRepository.findAll());
    }

    public DistrictDto getDistrictById(UUID uuid) throws Exception {
        DistrictEntity districtEntity = districtRepository.findById(uuid).orElseThrow(() -> new Exception("can not find district"));
        return countryCityDistrictMapper.toDistrictDto(districtEntity);
    }
}
