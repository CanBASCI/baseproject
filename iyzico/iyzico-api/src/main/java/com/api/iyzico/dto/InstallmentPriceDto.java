package com.api.iyzico.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class InstallmentPriceDto {
    private String installmentPrice;
    private String totalPrice;
    private String installmentNumber;
}
