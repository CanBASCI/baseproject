package com.api.customer.dto.address;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class AddressDto {

    private UUID id;

    private String address;

    private DistrictDto district;

    private String postalCode;

    private String phoneNumber;

    private Boolean isActive;
}
