package com.virtusa.semicolon.admin_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.semicolon.admin_service.domain.FeedBack;
import com.virtusa.semicolon.admin_service.domain.User;
import com.virtusa.semicolon.admin_service.repository.UserRepository;
import com.virtusa.semicolon.admin_service.repository.FeedBackRepository;

@Service
public class AdminService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	FeedBackRepository feedback;

	public List<User> showApprovalRequests() {
		List<User> list = userRepository.showApprovalRequests();
		return list;
	}

	// accept
	public void approveEmployerRequest(User user) {

		if (userRepository.findById(user.getUserName()) != null) {
			userRepository.approveEmployerRequest(user.getUserName());
		}

	}

	//reject delete
	public void rejectRequest(User user) {
		System.out.println("i am the admin service");
		if (userRepository.findById(user.getUserName()) != null)
				userRepository.delete(user);
	}	

	//block user
	public User blockUserByUsername(String username) {
		return userRepository.blockUserByUsername(username);
	}

	//list of feedback
	public List<FeedBack> showReport() {
		List<FeedBack> list = feedback.findAll();
		return list;

	}

	public List<User> getAllUser() {

		return userRepository.findAll();
	}

}
