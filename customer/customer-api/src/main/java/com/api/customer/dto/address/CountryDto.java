package com.api.customer.dto.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class CountryDto {
    private UUID id;
    private String name;
    private String twoCharCountryCode ;
    private String threeCharCountryCode ;
    private PhoneCodeDto phoneCode;
    @JsonIgnore
    private List<CityDto> cities;
}
