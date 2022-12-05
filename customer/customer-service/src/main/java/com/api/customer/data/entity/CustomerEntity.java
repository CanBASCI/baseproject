package com.api.customer.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="CUSTOMERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="MIDDLE_NAME")
    private String middleName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="AGE")
    private Integer age;
}
