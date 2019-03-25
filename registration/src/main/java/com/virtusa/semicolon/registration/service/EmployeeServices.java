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
public class EmployeeServices {
	
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

	/*
	@Transactional
	public Registration register(String userName, String password,String authorities){
		Authorities aut = new Authorities();
		Registration reg = new Registration();
		reg.setUserName(userName);
		reg.setPassword(password);
		if(authorities.equals("ROLE_EMPLOYER")){
			reg.setEnabled((long) 0);
		}else if(authorities.equals("ROLE_JOBSEEKER")){
			reg.setEnabled((long) 1);
		}
		Registration emp1 =employerRepository.save(reg);
		aut.setUser(reg);
		aut.setAuthorities(authorities);
		registerAuthorities(aut);
		return emp1;	
	}*/
	
	public Authorities registerAuthorities(Authorities auth){
		return authoritiesRepository.save(auth);
	}
	
	@Transactional
	public Registration register(Authorities aut) {
		
		Registration regstration = aut.getUser();
		PersonalDetails personalDetails = new PersonalDetails();
		EducationDetails educationDetails= new EducationDetails();
		CompanyDetails  companyDetails = new CompanyDetails();
	
		if(aut.getAuthorities().equals("ROLE_EMPLOYER")){
			regstration.setEnabled((long) 0);
		}else if(aut.getAuthorities().equals("ROLE_JOBSEEKER")){
			regstration.setEnabled((long) 1);
		}
		personalDetails.setUserName(regstration.getUserName());
		educationDetails.setUserName(regstration.getUserName());
	
		companyDetails.setUserName(regstration.getUserName());
		
		Registration reg =employerRepository.save(regstration);
		registerAuthorities(aut);
		personalDetailRepository.save(personalDetails);
		educationDetailsRepository.save(educationDetails);
		companyDetailsRepository.save(companyDetails);
		return reg;	
		
	}

}
