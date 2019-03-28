package com.virtusa.semicolon.registration.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.semicolon.registration.domain.Authorities;
import com.virtusa.semicolon.registration.domain.CompanyDetails;
import com.virtusa.semicolon.registration.domain.EducationDetails;
import com.virtusa.semicolon.registration.domain.PersonalDetails;
import com.virtusa.semicolon.registration.domain.Registration;
import com.virtusa.semicolon.registration.repository.Authoritiesrepositories;
import com.virtusa.semicolon.registration.repository.CompanyDetailsRepository;
import com.virtusa.semicolon.registration.repository.EducationDetailsRepository;
import com.virtusa.semicolon.registration.repository.EmployerRepository;
import com.virtusa.semicolon.registration.repository.PersonalDetailsRepository;

@Service
public class RegistrationServices {
	
	@Autowired
	EmployerRepository employerRepository;	
	@Autowired
	Authoritiesrepositories authoritiesRepository;
	@Autowired
	PersonalDetailsRepository personalDetailRepository;
	@Autowired
	EducationDetailsRepository educationDetailsRepository;
	@Autowired
	CompanyDetailsRepository companyDetailsRepository;	
	
	public Authorities registerAuthorities(Authorities auth){
		Authorities temp = authoritiesRepository.save(auth);
		System.out.println(temp);
		return temp;
	}
	
@Transactional
	public Authorities register(Authorities aut) {
		
		Registration regstration = aut.getUser();
		PersonalDetails personalDetails = new PersonalDetails();
		EducationDetails educationDetails= new EducationDetails();
		CompanyDetails  companyDetails = new CompanyDetails();
	
		if(aut.getAuthorities().equals("ROLE_EMPLOYER")){
			regstration.setEnabled((long) 0);
			companyDetails.setUserName(regstration.getUserName());

		}else if(aut.getAuthorities().equals("ROLE_JOBSEEKER")){
			regstration.setEnabled((long) 1);
			personalDetails.setUserName(regstration.getUserName());
			educationDetails.setUserName(regstration.getUserName());
		}
		Authorities auth =registerAuthorities(aut);
			
		personalDetailRepository.save(personalDetails);
		
		educationDetailsRepository.save(educationDetails);
		
		companyDetailsRepository.save(companyDetails);
		
		return auth;	
		
	}

}
