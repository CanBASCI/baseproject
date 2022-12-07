package com.api.customer.data.entity.phone;

import com.api.customer.data.entity.address.CountryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="PHONE_CODE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhoneCodeEntity {

    @Id
    private UUID id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "id")
    private CountryEntity country;

    @Column(name="CODE")
    private String code;

}
