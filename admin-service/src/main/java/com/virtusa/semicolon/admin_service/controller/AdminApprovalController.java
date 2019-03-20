package com.virtusa.semicolon.admin_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.semicolon.admin_service.domain.User;
import com.virtusa.semicolon.admin_service.service.AdminApprovalService;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminApprovalController {

	@Autowired
	AdminApprovalService adminApprovalService;

	@GetMapping("/approval/requests")
	public List<User> showApprovalRequests() {

		List<User> list = adminApprovalService.showApprovalRequests();

		return list;
	}

	@PutMapping("/approval/requests/accept/{username}")
	public Integer acceptApprovalRequests(@PathVariable("username") String username) {
		System.out.println(username);
		return adminApprovalService.approveEmployerRequest(username);
	}

	/*
	 * @PostMapping("/approval/requests/reject/{username}") public Integer
	 * acceptRejectRequests(@PathVariable("username") String username) {
	 * System.out.println(username); return
	 * adminApprovalService.approveEmployerRequest(username); }
	 */

}