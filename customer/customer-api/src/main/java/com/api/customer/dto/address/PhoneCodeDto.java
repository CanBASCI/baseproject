package com.api.customer.dto.address;

import lombok.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class PhoneCodeDto {
    private UUID id;
    private String code;
    private CountryDto country;
}
