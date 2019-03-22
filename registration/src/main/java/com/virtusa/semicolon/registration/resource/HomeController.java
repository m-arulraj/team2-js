package com.virtusa.semicolon.registration.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.virtusa.semicolon.registration.domain.Authorities;
import com.virtusa.semicolon.registration.domain.Registration;



@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String registration(){
		System.out.println("registration");
		return "Registration";
	}
	@ModelAttribute("user")
	public Registration createRegistrationModel(){
		return new Registration();
	}
	@ModelAttribute("auth")
	public Authorities createauthoritiesModel(){
		return new Authorities();
	}

}
