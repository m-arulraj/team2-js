package com.virtusa.semicolon.master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.semicolon.master.domain.Authorities;
import com.virtusa.semicolon.master.domain.Registration;
import com.virtusa.semicolon.master.service.RegistrationService;

@Controller
public class LoginController {
	@Autowired
	RegistrationService  registrationService;

	@RequestMapping("/login")
	public String welcome() {
		return "login";
	}
	
	@RequestMapping("/signup")
	public String signup() {
		return "Registration";
	}
	
	
	@ModelAttribute("auth")
	public Authorities createauthoritiesModel(){
		return new Authorities();
	}
@PostMapping("/register")
public ModelAndView registerUser(@ModelAttribute("auth") Authorities authorities){
	System.out.println("sign" +authorities);
	ModelAndView model = new ModelAndView();
	Registration registration = registrationService.registerUser( authorities);
	System.out.println("reg" +registration);
	if(registration.getEnabled()==1){
		model.setViewName("seeker-home");
	}
	else{
	model.setViewName("approval");
	}
	return model;
	
}
	

	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	
	
}
