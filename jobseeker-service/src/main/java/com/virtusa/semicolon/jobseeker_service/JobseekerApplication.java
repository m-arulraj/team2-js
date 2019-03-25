package com.virtusa.semicolon.jobseeker_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
@EnableFeignClients
public class JobseekerApplication {

	public static void main(String[] args){
		SpringApplication.run(JobseekerApplication.class, args);
	}
	 @Bean
	   public RestTemplate restTemplate(RestTemplateBuilder builder) {
	      return builder.build();
	   }
}
