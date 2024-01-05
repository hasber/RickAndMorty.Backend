package com.rickandmory.backend.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringConfig {

    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
