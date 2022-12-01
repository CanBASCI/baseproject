package com.api.iyzico.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class InstallmentRequestDto {
    private String binNumber;
    private String locale;
    private String conversationId;
    private String price;
}
