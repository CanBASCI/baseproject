package com.api.customer.mapper;

import com.api.customer.data.entity.address.AddressEntity;
import com.api.customer.dto.address.AddressDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface AddressMapper {

    @Mapping(target = "district.city.districts", ignore = true)
    @Mapping(target = "district.city.country.cities", ignore = true)
    AddressDto toDto(AddressEntity address);
}
