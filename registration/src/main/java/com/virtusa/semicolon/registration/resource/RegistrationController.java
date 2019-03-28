package com.virtusa.semicolon.registration.resource;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.semicolon.registration.domain.Authorities;
import com.virtusa.semicolon.registration.domain.PersonalDetails;
import com.virtusa.semicolon.registration.domain.Registration;
import com.virtusa.semicolon.registration.service.RegistrationServices;

@RestController
@RequestMapping("/api")
public class RegistrationController {
	@Autowired
	RegistrationServices registrationService;
	@Autowired
	AdminServiceProxy adminproxy;
	@Autowired
	jobseekerServiceProxy jobproxy;
	
	@PostMapping(value="/registration")
	public ResponseEntity<Authorities> registerEmployee(@RequestBody Authorities reg) throws URISyntaxException{	
		
	/*	return ResponseEntity.created(new URI("/api/registration/employer/"+employerService.register(reg
				userName,password,authorities))).build();*/
		Authorities emp= registrationService.register(reg);		
		System.out.println("registration" +emp);
		return new ResponseEntity<Authorities>(emp,HttpStatus.CREATED);
		
	}
	@RequestMapping("/admin/requests")
	public List<Registration> findall(){
		return adminproxy.findall();
		
	}
	@PutMapping("/jobseeker/updatepersonaldetails")
	public PersonalDetails updatePersonalDetails(@RequestParam("userName") String userName,
			@RequestBody PersonalDetails personalDetails){
		System.out.println("regcontroller" +userName);
		return jobproxy.updatePersonalDetails(userName, personalDetails);
	}
		
	
}
