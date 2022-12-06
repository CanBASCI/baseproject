package com.api.customer.dto;

import com.api.customer.dto.util.BaseDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class CustomerDto extends BaseDto {
    private UUID id;
    private String userName;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;
    private Boolean isActive;
}
