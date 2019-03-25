package com.virtusa.semicolon.master.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.semicolon.master.domain.EmployerRegistration;
import com.virtusa.semicolon.master.service.AdminService;

@Controller

@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	// homepage
	@GetMapping("")
	public ModelAndView adminHomePage() {
		ModelAndView model = new ModelAndView("admin-home");
		return model;
	}

	// request approval
	@GetMapping("/requests")
	public ModelAndView adminApprovalRequest() {
		ModelAndView model = new ModelAndView("admin-approval-request");
		List<EmployerRegistration> requestList =adminService.getListOfRequests();
		model.addObject("reqList",requestList);
		for (EmployerRegistration employerRegistration : requestList) {
			System.out.println(employerRegistration);
		}
		return model;
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
