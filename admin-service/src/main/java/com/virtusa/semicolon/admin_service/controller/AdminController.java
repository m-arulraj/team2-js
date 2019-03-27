package com.virtusa.semicolon.admin_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.semicolon.admin_service.domain.FeedBack;
import com.virtusa.semicolon.admin_service.domain.User;
import com.virtusa.semicolon.admin_service.service.AdminService;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	

	@GetMapping("/approval/requests")
	public List<User> showApprovalRequests() {

		List<User> list = adminService.showApprovalRequests();

		return list;
	}
	
	@GetMapping("/reports")
	public List<FeedBack> showReports() {
		List<FeedBack> list = adminService.showReport();
		return list;
	}

	@PutMapping("/approval/requests/accept")
	public void acceptApprovalRequests(@RequestBody User user) {
		System.out.println(user.getUserName());
		adminService.approveEmployerRequest(user);
	}

	@DeleteMapping("/approval/requests/reject")
	public void rejectRequests(@RequestBody User user) {
		System.out.println(user.getUserName());
		adminService.rejectRequest(user);
	}

	
	
/*	@DeleteMapping("/approval/requests/delete/")
	public void deleteUser(@PathVariable("username") String username,@RequestBody User user) {
		adminService.deleteUserByUsername(username);
	}
*/	
	@GetMapping("/users")
	public List<User> getAllUser() {
		List<User> list = adminService.getAllUser();
		return list;
	}
	
	@PutMapping("/user/block")
	public void disableAccount(@PathVariable("username") String username,@RequestBody User user) {
		 adminService.blockUserByUsername(username);
	}
}