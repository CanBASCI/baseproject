package com.api.gateway.mapper;

import com.api.customer.dto.CustomerCreateDto;
import com.api.gateway.dto.customer.CustomerCreate;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface CustomerMapper {
    CustomerCreateDto toDto(CustomerCreate customerCreate);
}
