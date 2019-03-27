package com.virtusa.semicolon.master.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.ls.LSInput;

import com.virtusa.semicolon.master.domain.EmployerRegistration;
import com.virtusa.semicolon.master.domain.FeedBack;
import com.virtusa.semicolon.master.domain.User;
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

	// list request approval
	@GetMapping("/requests")
	public ModelAndView adminApprovalRequest() {
		ModelAndView model = new ModelAndView("admin-approval-request");
		String uri = "/approval/requests";
		List<EmployerRegistration> requestList = adminService.getListOfRequests(uri);
		model.addObject("reqList", requestList);
		for (EmployerRegistration employerRegistration : requestList) {
			System.out.println(employerRegistration);
		}
		return model;
	}

	// accept request
	@GetMapping("/accept")
	public ModelAndView acceptRequest(@RequestParam("username") String userName) {

		String uri = "/approval/requests/accept";
		System.out.println(uri);
		adminService.acceptRequest(uri, userName);
		return adminApprovalRequest();
	}

	// delete or reject
	@GetMapping("/reject")
	public ModelAndView rejectRequest(@RequestParam("username") String userName) {
		String uri = "/approval/requests/reject";
		adminService.rejectRequest(uri, userName);
		return adminApprovalRequest();
		
	}

	// reports
	@GetMapping("/reports")
	public ModelAndView getReports() {
		ModelAndView model = new ModelAndView("admin-reports");
		String uri = "/reports";
		List<FeedBack> reportList = adminService.getReports(uri);
		model.addObject("repoList", reportList);
		return model;
	}

	// profile
	@GetMapping("/profile")
	public String updateProfile() {
		return "admin-profile";
	}

	// block
	@GetMapping("/users/block")
	public String blockUser() {
		ModelAndView model = new ModelAndView("admin-reports");
		String uri = "/users";
		List<User> users = adminService.getAllUsers(uri);
		model.addObject("users", users);
		return "admin-block";
	}

}
