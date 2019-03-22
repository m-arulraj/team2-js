package com.virtusa.semicolon.admin_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@PutMapping("/approval/requests/accept/{username}")
	public Integer acceptApprovalRequests(@PathVariable("username") String username) {
		System.out.println(username);
		return adminService.approveEmployerRequest(username);
	}

	@DeleteMapping("/approval/requests/delete/{username}")
	public void deleteUser(@PathVariable("username") String username) {
		adminService.deleteUserByUsername(username);
	}
	
	@PutMapping("/user/block/{username}")
	public Integer disableAccount(@PathVariable("username") String username) {
		return adminService.blockUserByUsername(username);
	}
}