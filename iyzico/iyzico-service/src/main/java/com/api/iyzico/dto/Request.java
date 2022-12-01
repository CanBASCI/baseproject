package com.api.iyzico.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@SuperBuilder(toBuilder = true)
public class Request {
    private String locale;
    private String conversationId;
}
