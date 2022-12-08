package com.api.customer.data.entity;

import com.api.customer.data.entity.address.AddressEntity;
import com.api.customer.data.entity.util.BaseEntity;
import com.api.customer.enums.GenderType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="CUSTOMER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @Column(name="USER_NAME", unique = true, nullable = false)
    private String userName;

    @Column(name="FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name="MIDDLE_NAME")
    private String middleName;

    @Column(name="LAST_NAME", nullable = false)
    private String lastName;

    @Column(name="EMAIL_NUMBER", nullable = false)
    private String emailNumber;

    @Column(name="PHONE_CODE", length = 10, nullable = false)
    private String phoneCode;

    @Column(name="PHONE_NUMBER", length = 15, nullable = false)
    private String phoneNumber;

    @Column(name="BIRTH_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name="GENDER_TYPE")
    private GenderType genderType;

    @Column(name="IDENTITY_NUMBER", length = 20)
    private String identityNumber;

    @Column(name = "IS_MARRIED")
    private Boolean isMarried;

    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
    private Set<AddressEntity> addresses = new HashSet<>();

    @Column(name = "IS_ACTIVE", nullable = false)
    private Boolean isActive;

}
