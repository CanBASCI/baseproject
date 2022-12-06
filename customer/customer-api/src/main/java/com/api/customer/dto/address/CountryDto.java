package com.api.customer.dto.address;

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

    private String ThreeCharCountryCode ;

    private List<CityDto> cities;
}
