package com.api.customer.dto.phone;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class PhoneCodeNumberDto {
    private String phoneCode;
    private String phoneNumber;
}
