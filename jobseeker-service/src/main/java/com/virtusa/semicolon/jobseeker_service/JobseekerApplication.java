package com.virtusa.semicolon.jobseeker_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class JobseekerApplication {

	public static void main(String[] args){
		SpringApplication.run(JobseekerApplication.class, args);
	}
}
