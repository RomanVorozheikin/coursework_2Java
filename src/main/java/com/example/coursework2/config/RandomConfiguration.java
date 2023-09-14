package com.example.coursework2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class RandomConfiguration {
    @Bean
    public Random random() {
        return new Random();
    }
}
