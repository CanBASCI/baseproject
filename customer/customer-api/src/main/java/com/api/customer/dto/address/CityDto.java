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
public class CityDto {

    private UUID id;

    private String name;

    private Double latitude;

    private Double longitude;

    private Double northeastLatitude;

    private Double northeastLongitude;

    private Double southwestLatitude;

    private Double southwestLongitude;

    private CountryDto country;

    @JsonIgnore
    private List<DistrictDto> districts;
}
