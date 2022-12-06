package com.api.customer.dto.util;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@SuperBuilder
public class BaseDto{
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;
}
