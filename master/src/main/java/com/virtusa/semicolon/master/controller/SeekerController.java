package com.virtusa.semicolon.master.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seeker")
public class SeekerController {

	//seeker homepage
	@GetMapping("")
	public String seekerHomePage(Principal principal, Model model) {
		String uName= principal.getName();
		model.addAttribute(uName);
		return "seeker-home";
	}
	
	//seeker profile
		@GetMapping("/profile")
		public String updateProfile() {
			return "seeker-profile";
		}

		//seeker applied jobs
		@GetMapping("/jobs")
		public String appliedJobs() {
			return "seeker-applied-jobs";
		}
	
		//seeker report
		@GetMapping("/report")
		public String report() {
			return "seeker-report-something";
		}
}
