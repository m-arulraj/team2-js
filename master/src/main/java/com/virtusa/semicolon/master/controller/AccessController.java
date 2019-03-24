package com.virtusa.semicolon.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AccessController {

	@GetMapping("/access-denied")
	public String accessDenied()
	{
		return "forbidden";
	}
	
}
