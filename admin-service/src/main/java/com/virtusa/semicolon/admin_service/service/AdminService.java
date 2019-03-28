package com.virtusa.semicolon.admin_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.semicolon.admin_service.domain.FeedBack;
import com.virtusa.semicolon.admin_service.domain.UpdateUser;
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

	// unblock
	public void unblockUser(User user) {

		if (userRepository.findById(user.getUserName()) != null) {
			userRepository.approveEmployerRequest(user.getUserName());
		}

	}

	// reject delete
	public void rejectRequest(String userName) {
		User user = null;

		Optional<User> optUser = userRepository.findById(userName);
		if (optUser.isPresent()) {
			user = optUser.get();
			userRepository.delete(user);
		}
	}

	// block user
	public User blockUserByUsername(String username) {
		return userRepository.blockUserByUsername(username);
	}

	// list of feedback
	public List<FeedBack> showReport() {
		List<FeedBack> list = feedback.findAll();
		return list;

	}

	public List<User> getAllUser() {

		return userRepository.findAll();
	}

	public List<User> getAllBlockedUser() {
		return userRepository.showBlockedUser();
	}

	public void updateUsername(UpdateUser user) {
		User currentUser= null;
		System.out.println("this is admin service service"+user);
		Optional<User> optUser = userRepository.findById(user.getUserName());
		
		if(optUser.isPresent())
		{
			currentUser = optUser.get();
			
			if (currentUser.getPassword().equals(user.getPassword())) {
				userRepository.updateUsername(user.getUserName(), user.getNewUserName());
			}
			else
			{
				System.out.println("password not matched");
			}
		}
		else 
		{
			System.out.println("user is not present");
		}		
	}

}
