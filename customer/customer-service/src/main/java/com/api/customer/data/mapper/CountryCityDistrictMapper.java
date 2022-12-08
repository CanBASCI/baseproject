package com.api.customer.data.mapper;

import com.api.customer.data.entity.address.CityEntity;
import com.api.customer.data.entity.address.CountryEntity;
import com.api.customer.data.entity.address.DistrictEntity;
import com.api.customer.dto.address.CityDto;
import com.api.customer.dto.address.CountryDto;
import com.api.customer.dto.address.DistrictDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public interface CountryCityDistrictMapper {

    @Mapping(target = "cities", ignore = true)
    CountryDto toCountryDto(CountryEntity countryEntity);
    List<CountryDto> toCountryDtos(List<CountryEntity> countryEntities);

    @Mapping(target = "districts", ignore = true)
    @Mapping(target = "country", ignore = true)
    CityDto toCityDto(CityEntity cityEntity);
    List<CityDto> toCityDtos(List<CityEntity> cityEntities);

    @Mapping(target = "city", ignore = true)
    DistrictDto toDistrictDto(DistrictEntity districtEntity);
    List<DistrictDto> toDistrictDtos(List<DistrictEntity> districtEntities);

}
