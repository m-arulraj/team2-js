package com.virtusa.semicolon.registration.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.semicolon.registration.domain.Registration;
import com.virtusa.semicolon.registration.service.EmployeeServices;

@RestController
@RequestMapping("/api/registration/employer")
public class RegistrationController {
	@Autowired
	EmployeeServices employerService;
	
	@RequestMapping( method= RequestMethod.POST)
	public ResponseEntity<String> registerEmployee(@RequestParam("userName") String userName,@RequestParam("password") String password,@RequestParam("authorities") String authorities) throws Exception{
		
		/*Registration emp= employerService.registerEmployee(register,authorities);		
		return new ResponseEntity<Registration>(emp,HttpStatus.CREATED);*/
		
		return ResponseEntity.created(new URI("/api/registration/employer/"+employerService.register(userName,password,authorities))).build();
		
	}
		
	
}
