package com.api.customer.data.mapper;

import com.api.customer.data.entity.phone.PhoneCodeEntity;
import com.api.customer.dto.address.PhoneCodeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public interface PhoneCodeMapper {

    @Mapping(target = "country.cities", ignore = true)
    PhoneCodeDto toDto(PhoneCodeEntity phoneCodeEntity);

    List<PhoneCodeDto> toDtos(List<PhoneCodeEntity> phoneCodeEntity);
}
