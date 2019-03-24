package com.virtusa.semicolon.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String welcome() {
		return "login";
	}
	
	@RequestMapping("/signup")
	public String signup() {
		return "signup";
	}
}
