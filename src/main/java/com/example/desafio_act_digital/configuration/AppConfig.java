package com.example.desafio_act_digital.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import lombok.Getter;

@Getter
@Configuration
public class AppConfig {
    
	@Value("${act-digital.via-cep-api}")
	private String urlBaseViaCep;
	
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

