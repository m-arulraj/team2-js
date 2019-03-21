package com.virtusa.semicolon.registration.resource;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.semicolon.registration.domain.Authorities;
import com.virtusa.semicolon.registration.domain.Registration;
import com.virtusa.semicolon.registration.service.EmployeeServices;

@RestController
@RequestMapping("/api/registration/employer")
public class RegistrationController {
	@Autowired
	EmployeeServices employerService;
	
	@PostMapping(value="")
	public ResponseEntity<Registration> registerEmployee(@ModelAttribute("auth") Authorities reg) throws URISyntaxException{	
		System.out.println(reg);
	/*	return ResponseEntity.created(new URI("/api/registration/employer/"+employerService.register(reg
				userName,password,authorities))).build();*/
		Registration emp= employerService.register(reg);		
		return new ResponseEntity<Registration>(emp,HttpStatus.CREATED);
		
	}
		
	
}
