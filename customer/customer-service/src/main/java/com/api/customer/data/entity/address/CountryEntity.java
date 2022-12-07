package com.api.customer.data.entity.address;

import com.api.customer.data.entity.phone.PhoneCodeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="COUNTRY")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryEntity {

    @Id
    private UUID id;

    @Column(name="NAME")
    private String name;

    @Column(name="TWO_CHAR_COUNTRY_CODE", length = 2)
    private String twoCharCountryCode ;

    @Column(name="THREE_CHAR_COUNTRY_CODE", length = 3)
    private String ThreeCharCountryCode ;

    @OneToMany(mappedBy="country", cascade = CascadeType.ALL)
    private Set<CityEntity> cities = new HashSet<>();

    @OneToOne(mappedBy = "country")
    private PhoneCodeEntity phoneCode;
}
