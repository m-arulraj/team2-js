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
			if (personalDetails.getFirstName() != null) {
				personalDetails2.setFirstName(personalDetails.getFirstName());
			}
			if (personalDetails.getLastName() != null) {
				personalDetails2.setLastName(personalDetails.getLastName());
			}
			if (personalDetails.getGender() != null) {
				personalDetails2.setGender(personalDetails.getGender());
			}
			if (personalDetails.getDateOfBirth() != null) {
				personalDetails2.setDateOfBirth(personalDetails.getDateOfBirth());
			}
			if (personalDetails.getFatherName() != null) {
				personalDetails2.setFatherName(personalDetails.getFatherName());
			}
			if (personalDetails.getCountry() != null) {
				personalDetails2.setCountry(personalDetails.getCountry());
			}
			if (personalDetails.getState() != null) {
				personalDetails2.setState(personalDetails.getState());
			}
			if (personalDetails.getContactNumber() != null) {
				personalDetails2.setContactNumber(personalDetails.getContactNumber());
			}
			if (personalDetails.getAddress() != null) {
				personalDetails2.setAddress(personalDetails.getAddress());
			}
			if (personalDetails.getPincode() != null) {
				personalDetails2.setPincode(personalDetails.getPincode());
			}
			return personalDetailsRepository.save(personalDetails2);
		} else {
			return personalDetailsRepository.save(personalDetails);
		}
	}

}
