package com.api.iyzico.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@SuperBuilder(toBuilder = true)
public class RetrieveInstallmentInfoRequest extends Request{
    private String binNumber;
    private BigDecimal price;
    private String currency;
}
