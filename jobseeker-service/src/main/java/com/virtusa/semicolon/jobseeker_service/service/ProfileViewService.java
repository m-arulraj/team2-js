package com.virtusa.semicolon.jobseeker_service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.semicolon.jobseeker_service.domain.EducationDetails;
import com.virtusa.semicolon.jobseeker_service.domain.PersonalDetails;
import com.virtusa.semicolon.jobseeker_service.domain.WorkExperianceDetails;
import com.virtusa.semicolon.jobseeker_service.repository.EducationDetailsRepository;
import com.virtusa.semicolon.jobseeker_service.repository.PersonalDetailsRepository;
import com.virtusa.semicolon.jobseeker_service.repository.WorkExperianceDetailsRepository;

@Service
public class ProfileViewService {
	
	@Autowired
	PersonalDetailsRepository personalDetailsRepository;
	
	@Autowired
	EducationDetailsRepository educationDetailsRepository;
	
	@Autowired
	WorkExperianceDetailsRepository workExperianceDetailsRepository;

	public PersonalDetails getPersonalDetails(String userName) {
		return personalDetailsRepository.findByUserName(userName);
	}

	public EducationDetails getEducationDetails(String userName) {
		return educationDetailsRepository.findByUserName(userName);
	}

	public Optional<WorkExperianceDetails> getWorkExperianceDetails(String userName) {
		return workExperianceDetailsRepository.findByUserName(userName);
	}

}
