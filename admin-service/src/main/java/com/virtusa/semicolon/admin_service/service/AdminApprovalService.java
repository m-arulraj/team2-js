package com.virtusa.semicolon.admin_service.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.semicolon.admin_service.domain.Employer;
import com.virtusa.semicolon.admin_service.domain.User;
import com.virtusa.semicolon.admin_service.repository.IAdminApprovalRepository;

@Service
public class AdminApprovalService {

	@Autowired
	IAdminApprovalRepository adminApprovalRepository;
	
	public List<User> showApprovalRequests()
	{
		List<User> list = adminApprovalRepository.showApprovalRequests();
		return list;
	}

	public Integer approveEmployerRequest(String username)
	{
	
		return adminApprovalRepository.approveEmployerRequest(username);
	}
	
}
