package com.api.iyzico.mapper;

import com.api.iyzico.dto.InstallmentRequestDto;
import com.api.iyzico.dto.RetrieveInstallmentInfoRequest;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-01T14:51:19+0300",
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

    @Override
    public RetrieveInstallmentInfoRequest toRetrieveInstallmentDto(InstallmentRequestDto installmentRequestDto) {
        if ( installmentRequestDto == null ) {
            return null;
        }

        RetrieveInstallmentInfoRequest.RetrieveInstallmentInfoRequestBuilder<?, ?> retrieveInstallmentInfoRequest = RetrieveInstallmentInfoRequest.builder();

        retrieveInstallmentInfoRequest.locale( installmentRequestDto.getLocale() );
        retrieveInstallmentInfoRequest.conversationId( installmentRequestDto.getConversationId() );
        retrieveInstallmentInfoRequest.binNumber( installmentRequestDto.getBinNumber() );
        if ( installmentRequestDto.getPrice() != null ) {
            retrieveInstallmentInfoRequest.price( new BigDecimal( installmentRequestDto.getPrice() ) );
        }

        return retrieveInstallmentInfoRequest.build();
    }
}
