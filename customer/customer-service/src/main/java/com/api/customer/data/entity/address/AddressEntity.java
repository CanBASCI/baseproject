package com.api.customer.data.entity.address;

import com.api.customer.data.entity.CustomerEntity;
import com.api.customer.data.entity.util.BaseEntity;
import com.api.customer.enums.AddressType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="ADDRESS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @Column(name="ADDRESS", length = 510)
    private String address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DISTRICT_ID", referencedColumnName = "id")
    private DistrictEntity district;

    @Column(name="ADDRESS_TYPE")
    private AddressType addressType;

    @Column(name="POSTAL_CODE")
    private String postalCode;

    @Column(name="PHONE_NUMBER")
    private String phoneNumber;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private CustomerEntity customer;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Boolean isActive;

}
