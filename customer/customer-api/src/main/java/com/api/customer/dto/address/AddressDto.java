package com.api.customer.dto.address;

import com.api.customer.dto.CustomerDto;
import com.api.customer.dto.util.BaseDto;
import com.api.customer.enums.AddressType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class AddressDto extends BaseDto {
    private UUID id;
    private String address;
    private DistrictDto district;
    private CustomerDto customer;
    private AddressType addressType;
    private String postalCode;
    private String phoneNumber;
    private Boolean isActive;
}
