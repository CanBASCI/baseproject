package com.api.customer.data.mapper;

import com.api.customer.data.entity.address.AddressEntity;
import com.api.customer.dto.address.AddressCreateDto;
import com.api.customer.dto.address.AddressDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface AddressMapper {

    @Mapping(target = "district.city.districts", ignore = true)
    @Mapping(target = "district.city.country.cities", ignore = true)
    @Mapping(target = "district.city.country.phoneCode.country", ignore = true)
    @Mapping(target = "customer", ignore = true)
    AddressDto toDto(AddressEntity address);

    @Mapping(target = "isActive", constant  = "true")
    @Mapping(target = "district.city.country.phoneCode", ignore = true)
    AddressEntity toEntity(AddressCreateDto addressCreateDto);
}
