package com.virtusa.semicolon.employer_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class EmployerServiceApplication 
{
    public static void main( String[] args )
    {
      SpringApplication.run(EmployerServiceApplication.class, args);
    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
       return builder.build();
    }
}
