package com.yisus.yisus_game_of_thrones.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public Faker faker(){
        return  new Faker();
    }
}
