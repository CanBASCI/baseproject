package com.api.iyzico.mapper;


import com.api.iyzico.dto.InstallmentRequestDto;
import com.api.iyzico.dto.RetrieveInstallmentInfoRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface IyzicoMapper {
     InstallmentRequestDto toInstallmentDto(RetrieveInstallmentInfoRequest installmentRequestDto);
}
