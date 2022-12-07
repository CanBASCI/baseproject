package com.api.customer.dto.address;

import com.api.customer.dto.util.BaseDto;
import com.api.customer.enums.AddressType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class AddressCreateDto extends BaseDto {
    private String address;
    private UUID districtId;
    private UUID customerId;
    private AddressType addressType;
    private String postalCode;
    private String phoneNumber;
}
