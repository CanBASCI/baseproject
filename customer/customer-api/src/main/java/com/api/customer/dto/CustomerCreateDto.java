package com.api.customer.dto;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class CustomerCreateDto {
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;
    private String userName;
}
