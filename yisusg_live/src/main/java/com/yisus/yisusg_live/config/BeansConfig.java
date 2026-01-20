package com.yisus.yisusg_live.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.resilience.annotation.ConcurrencyLimit;

@Configuration
public class BeansConfig {

    @Bean
    public Faker faker(){
        return new Faker();
    }
}
