package com.api.iyzico.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class Options {
    private String apiKey;
    private String secretKey;
    private String baseUrl;
    private String proxyHost;
    private int proxyPort;
}
