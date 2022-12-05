package com.api.gateway.dto.customer;

import lombok.*;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class CustomerCreate {
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;
}
