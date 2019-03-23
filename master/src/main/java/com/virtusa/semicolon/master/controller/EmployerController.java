package com.virtusa.semicolon.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employer")
public class EmployerController {

	//employer homepage
	@GetMapping("")
	public String seekerHomePage() {
		return "employer-home";
	}
	
	//seeker profile
		@GetMapping("/profile")
		public String updateProfile() {
			return "employer-profile";
		}

		//seeker applied jobs
		@GetMapping("/jobs")
		public String appliedJobs() {
			return "employer-posted-jobs";
		}
	
		//seeker report
		@GetMapping("/report")
		public String report() {
			return "employer-report-something";
		}
}
