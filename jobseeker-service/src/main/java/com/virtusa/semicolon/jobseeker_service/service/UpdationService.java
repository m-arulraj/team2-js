<<<<<<< HEAD
package com.virtusa.semicolon.jobseeker_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.virtusa.semicolon.jobseeker_service.domain.PersonalDetails;
import com.virtusa.semicolon.jobseeker_service.repository.PersonalDetailsRepository;

@Service
public class UpdationService {
	
	@Autowired
	PersonalDetailsRepository personalDetailsRepository;
	
	public PersonalDetails savePersonalDetails(PersonalDetails personalDetails){
		return personalDetailsRepository.save(personalDetails);
		
	}
	
	public PersonalDetails get(Long u){
		System.out.println(u);
		PersonalDetails p =  personalDetailsRepository.getPersonalDetails(u);
		System.out.println(p.getAddress());
		return p;
	}

	public PersonalDetails save(PersonalDetails personalDetails) {
	
		return personalDetailsRepository.save(personalDetails);
	}
}
=======
package com.virtusa.semicolon.jobseeker_service.service;

import org.springframework.stereotype.Service;

@Service
public class UpdationService {

}
>>>>>>> d8f298d814b5899653bdb07ad2dd03fb7795d5f5
