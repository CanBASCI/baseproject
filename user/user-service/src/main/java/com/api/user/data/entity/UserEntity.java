package com.api.user.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name="USERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @Column(name="NAME", unique = true, nullable = false)
    private String name;

    @Column(name="USER_NAME", unique = true, nullable = false)
    private String userName;

    @Column(name="PASSWORD", nullable = false)
    private String password;

    @Column(name="ROLES")
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<RoleEntity> roleEntities = new ArrayList<>();
}
