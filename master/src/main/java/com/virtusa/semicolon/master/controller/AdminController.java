package com.virtusa.semicolon.master.controller;

import java.util.List;

import org.omg.CORBA.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView blockedUser() {
		ModelAndView model = new ModelAndView("admin-block");
		String uri = "/users/blocked";
		List<User> users = adminService.getAllblockedUsers(uri);
		model.addObject("users", users);
		return model;
	}
	
	//unblock
	@GetMapping("/users/unblock")
	public ModelAndView unblockUser(@RequestParam("userName") String userName) {
		String uri = "/user/unblock";
		adminService.unblockUser(uri, userName);
		return blockedUser();
	}
	
	@PostMapping(value="/profile/username")
	public ModelAndView updateUserName(@ModelAttribute("user") User user)
	{
		ModelAndView model = new ModelAndView("admin-profile");
		String uri="/profile/username";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(user);
		user.setUserName(auth.getName());
		System.out.println(user.getUserName());
		adminService.updateUserName(user,uri);
		return model;
	}
	
}
