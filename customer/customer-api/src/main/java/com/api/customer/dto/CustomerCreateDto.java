package com.api.customer.dto;

import com.api.customer.dto.phone.PhoneCodeNumberDto;
import com.api.customer.enums.GenderType;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class CustomerCreateDto {
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;
    private String userName;
    private String emailNumber;
    private PhoneCodeNumberDto phoneCodeNumber;
    private GenderType genderType;
    private String identityNumber;
}
