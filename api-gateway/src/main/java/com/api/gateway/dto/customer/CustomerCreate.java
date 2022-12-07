package com.api.gateway.dto.customer;

import com.api.customer.enums.GenderType;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class CustomerCreate {
    @NotEmpty
    private String firstName;
    private String middleName;
    @NotEmpty
    private String lastName;
    @NotNull
    private Date birthDate;
    @NotEmpty
    private String emailNumber;
    @NotEmpty
    private String phoneCode;
    @NotEmpty
    private String phoneNumber;
    @NotNull
    private GenderType genderType;
    @NotEmpty
    private String identityNumber;
}
