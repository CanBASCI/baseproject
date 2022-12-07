package com.api.customer.mapper;

import com.api.customer.data.entity.CustomerEntity;
import com.api.customer.data.entity.address.AddressEntity;
import com.api.customer.dto.CustomerCreateDto;
import com.api.customer.dto.CustomerDto;
import com.api.customer.dto.address.AddressDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public interface CustomerMapper {

    @Mapping(target = "addresses.customer", ignore = true)
    CustomerDto toDto(CustomerEntity customerEntity);
    List<CustomerDto> toDtos(List<CustomerEntity> customerEntityList);
    CustomerEntity toEntity(CustomerCreateDto customerCreateDto);
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "district.city.districts", ignore = true)
    @Mapping(target = "district.city.country.cities", ignore = true)
    AddressDto toDto(AddressEntity addresses);
}
