package com.virtusa.semicolon.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping("/homepage")
	public String welcome(){
		return "home";
	}
}
