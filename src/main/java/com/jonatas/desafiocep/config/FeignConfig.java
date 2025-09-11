package com.jonatas.desafiocep.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Retryer retryer() {
        // Retryer.Default(period, maxPeriod, maxAttempts)
        return new Retryer.Default(1000, 2000, 3);
    }
}
