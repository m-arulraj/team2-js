package com.virtusa.semicolon.master.service;

import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import com.virtusa.semicolon.master.domain.EmployerRegistration;
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

}
