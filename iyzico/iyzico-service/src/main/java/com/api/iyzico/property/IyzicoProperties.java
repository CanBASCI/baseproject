package com.api.iyzico.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "iyzico")
@Configuration("iyzicoProperties")
@Getter
@Setter
public class IyzicoProperties {
    private String apiKey;
    private String secretKey;
    private String baseUrl;
}
