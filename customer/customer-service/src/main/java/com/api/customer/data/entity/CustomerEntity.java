package com.api.customer.data.entity;

import com.api.customer.data.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="CUSTOMERS")
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

    @Column(name="BIRTH_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Boolean isActive;

}
