package com.api.customer.dto.address;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class DistrictDto {
    private UUID id;
    private String name;
    private Double latitude;
    private Double longitude;
    private Double northeastLatitude;
    private Double northeastLongitude;
    private Double southwestLatitude;
    private Double southwestLongitude;
    private CityDto city;
}
