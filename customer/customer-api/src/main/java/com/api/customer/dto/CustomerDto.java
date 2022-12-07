package com.api.customer.dto;

import com.api.customer.dto.address.AddressDto;
import com.api.customer.dto.phone.PhoneCodeNumberDto;
import com.api.customer.dto.util.BaseDto;
import com.api.customer.enums.GenderType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class CustomerDto extends BaseDto {
    private UUID id;
    private String userName;
    private String firstName;
    private String middleName;
    private String lastName;
    private String emailNumber;
    private PhoneCodeNumberDto phoneCodeNumber;
    private Date birthDate;
    private GenderType genderType;
    private String identityNumber;
    private Boolean isActive;
    private List<AddressDto> addresses;
}
