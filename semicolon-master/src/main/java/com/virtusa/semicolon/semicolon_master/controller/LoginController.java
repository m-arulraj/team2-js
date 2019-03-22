package com.virtusa.semicolon.semicolon_master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/")
	public void welcome()
	{
		System.out.println("hello");
	}
}
