package com.virtusa.semicolon.admin_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.semicolon.admin_service.domain.User;
import com.virtusa.semicolon.admin_service.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	public List<User> showApprovalRequests()
	{
		List<User> list = adminRepository.showApprovalRequests();
		return list;
	}

	public Integer approveEmployerRequest(String username)
	{
		return adminRepository.approveEmployerRequest(username);
	}
	
	public void deleteUserByUsername(String username)
	{
		adminRepository.deleteAccountByUsername(username);
	}
	
	public Integer blockUserByUsername(String username)
	{
		return adminRepository.blockUserByUsername(username);
	}
	
}
