package com.api.iyzico.mapper;

import com.api.iyzico.dto.InstallmentRequestDto;
import com.api.iyzico.dto.RetrieveInstallmentInfoRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-01T14:43:42+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class IyzicoMapperImpl implements IyzicoMapper {

    @Override
    public InstallmentRequestDto toInstallmentDto(RetrieveInstallmentInfoRequest installmentRequestDto) {
        if ( installmentRequestDto == null ) {
            return null;
        }

        InstallmentRequestDto.InstallmentRequestDtoBuilder installmentRequestDto1 = InstallmentRequestDto.builder();

        installmentRequestDto1.binNumber( installmentRequestDto.getBinNumber() );
        installmentRequestDto1.locale( installmentRequestDto.getLocale() );
        installmentRequestDto1.conversationId( installmentRequestDto.getConversationId() );
        if ( installmentRequestDto.getPrice() != null ) {
            installmentRequestDto1.price( installmentRequestDto.getPrice().toString() );
        }

        return installmentRequestDto1.build();
    }
}
