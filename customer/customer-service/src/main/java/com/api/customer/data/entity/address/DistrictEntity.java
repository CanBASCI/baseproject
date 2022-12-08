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
@Table(name="DISTRICT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DistrictEntity {

    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private CityEntity city;

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

    @OneToMany(mappedBy="district", cascade = CascadeType.ALL)
    private Set<AddressEntity> addresses = new HashSet<>();

}
