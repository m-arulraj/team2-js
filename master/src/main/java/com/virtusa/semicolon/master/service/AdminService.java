package com.virtusa.semicolon.master.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.virtusa.semicolon.master.domain.EmployerRegistration;
import com.virtusa.semicolon.master.domain.FeedBack;
import com.virtusa.semicolon.master.domain.User;
import com.virtusa.semicolon.master.util.EndPointConstant;

@Repository
public class AdminService {

	RestTemplate template = new RestTemplate();

	public List<EmployerRegistration> getListOfRequests(String uri) {
		ResponseEntity<List<EmployerRegistration>> response = template.exchange(EndPointConstant.ADMIN_URI+uri,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<EmployerRegistration>>() {
				});
		return response.getBody();
	}



	public void acceptRequest(String uri, String userName) {	
		EmployerRegistration emp = new EmployerRegistration();
		emp.setUserName(userName);
		template.put(EndPointConstant.ADMIN_URI+uri, emp);
	}
	
	
	//delete
	public void rejectRequest(String uri, String userName) {	
		EmployerRegistration emp = new EmployerRegistration();
		emp.setUserName(userName);
		System.out.println(EndPointConstant.ADMIN_URI+uri);
		template.delete(EndPointConstant.ADMIN_URI+uri,emp);
	}
	
	public List<FeedBack> getReports(String uri)
	{
		ResponseEntity<List<FeedBack>> response = template.exchange(EndPointConstant.ADMIN_URI+uri,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<FeedBack>>() {
				});
		return response.getBody();
	}

	public List<User> getAllUsers(String uri) {
		System.out.println(EndPointConstant.ADMIN_URI+uri);
		ResponseEntity<List<User>> response = template.exchange(EndPointConstant.ADMIN_URI+uri,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
				});
		return response.getBody();
	}

}
