package com.api.user.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class CreateUserDto {
    private String name;
    private String userName;
    private String password;
}
