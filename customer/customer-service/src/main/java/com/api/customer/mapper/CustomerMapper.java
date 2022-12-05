package com.api.customer.mapper;

import com.api.customer.data.entity.CustomerEntity;
import com.api.customer.dto.CustomerDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface CustomerMapper {

    List<CustomerDto> toDtos(List<CustomerEntity> customerEntityList);

}
