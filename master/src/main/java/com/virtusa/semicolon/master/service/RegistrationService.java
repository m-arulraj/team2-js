package com.virtusa.semicolon.master.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.virtusa.semicolon.master.domain.Authorities;
import com.virtusa.semicolon.master.domain.Registration;
import com.virtusa.semicolon.master.util.EndPointConstant;

@Service
public class RegistrationService {
	RestTemplate template = new RestTemplate();
	
	public Registration registerUser(Authorities authorities){
	
		System.out.println("uri" +EndPointConstant.REGISTRATION_URI);
		System.out.println(authorities);
		ResponseEntity<Authorities> response = template.postForEntity(EndPointConstant.REGISTRATION_URI, authorities, 
				Authorities.class );
		
		return response.getBody();
	}

}
