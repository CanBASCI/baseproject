package com.api.iyzico.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class InstallmentInfoDto {
    private String status;
    private String locale;
    private Integer systemTime;
    private String conversationId;
    private InstallmentPriceDto installmentPriceDto;
}
