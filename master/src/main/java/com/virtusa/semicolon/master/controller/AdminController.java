package com.virtusa.semicolon.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/admin")
public class AdminController {

	// homepage
	@GetMapping("")
	public String adminHomePage() {
		return "admin-home";
	}

	// request approval
	@GetMapping("/requests")
	public String adminApprovalRequest() {
		return "admin-approval-request";
	}

	// reports
	@GetMapping("/reports")
	public String getReports() {
		return "admin-reports";
	}

	// profile
	@GetMapping("/profile")
	public String updateProfile() {
		return "admin-profile";
	}

	//block
	@GetMapping("/users/block")
	public String blockUser() {
		return "admin-block";
	}

}
