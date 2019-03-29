package com.virtusa.semicolon.jobseeker_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.semicolon.jobseeker_service.domain.PersonalDetails;
import com.virtusa.semicolon.jobseeker_service.repository.PersonalDetailsRepository;

@Service
public class PersonalDetailsService {
	
	@Autowired
	PersonalDetailsRepository personalDetailsRepository;
	
	public PersonalDetails updatePersonalDetails(String userName, PersonalDetails personalDetails) {
		
		PersonalDetails personalDetails2 = personalDetailsRepository.findByUserName(userName);

		if (personalDetails2 != null) {
			return personalDetailsRepository.save(personalDetails2);
		} else {
			return personalDetailsRepository.save(personalDetails);
		}
	}
	
	

}
