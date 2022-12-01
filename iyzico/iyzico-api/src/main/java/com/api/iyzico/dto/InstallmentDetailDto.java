package com.api.iyzico.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class InstallmentDetailDto {
    private String binNumber;
    private String price;
    private String cardType;
    private String cardAssociation;
    private String cardFamilyName;
    private String force3ds;
    private String bankName;
    private Integer bankCode;
    private InstallmentInfoDto installmentInfoDto;
    private String errorCode;
    private String errorMessage;
    private String errorGroup;
}
