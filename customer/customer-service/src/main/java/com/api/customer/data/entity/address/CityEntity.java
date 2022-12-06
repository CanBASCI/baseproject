package com.api.customer.data.entity.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="CITY")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityEntity {

    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private CountryEntity country;

    @Column(name="NAME")
    private String name;

    @Column(name="LATITUDE", precision=11, scale=8)
    private Double latitude;

    @Column(name="LONGITUDE", precision=11, scale=8)
    private Double longitude;

    @Column(name="NORTHEAST_LATITUDE", precision=11, scale=8)
    private Double northeastLatitude;

    @Column(name="NORTHEAST_LONGITUDE", precision=11, scale=8)
    private Double northeastLongitude;

    @Column(name="SOUTHWEST_LATITUDE", precision=11, scale=8)
    private Double southwestLatitude;

    @Column(name="SOUTHWEST_LONGITUDE", precision=11, scale=8)
    private Double southwestLongitude;

    @OneToMany(mappedBy="city", cascade = CascadeType.ALL)
    private Set<DistrictEntity> districts = new HashSet<>();

}
