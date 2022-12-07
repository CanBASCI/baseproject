package com.api.gateway.mapper;

import com.api.customer.dto.CustomerCreateDto;
import com.api.gateway.dto.customer.CustomerCreate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface CustomerMapper {
    @Mapping(target = "phoneCodeNumber.phoneCode", source = "phoneCode")
    @Mapping(target = "phoneCodeNumber.phoneNumber", source = "phoneNumber")
    CustomerCreateDto toDto(CustomerCreate customerCreate);
}
