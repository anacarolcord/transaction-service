package com.anadev.transaction_service.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientConfig {

    @Bean
    public RestClient accountRestClient(RestClient.Builder builder) {
        return builder.baseUrl("http://localhost:8080").build();
    }
}