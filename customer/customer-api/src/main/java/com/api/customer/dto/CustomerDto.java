package com.api.customer.dto;

import lombok.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class CustomerDto {
    private UUID id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Integer age;
}
