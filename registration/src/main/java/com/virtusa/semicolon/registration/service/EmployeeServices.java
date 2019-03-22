package com.virtusa.semicolon.registration.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.semicolon.registration.domain.Authorities;
import com.virtusa.semicolon.registration.domain.Registration;
import com.virtusa.semicolon.registration.repository.Authoritiesrepositories;
import com.virtusa.semicolon.registration.repository.EmployerRepository;

@Service
public class EmployeeServices {
	
	@Autowired
	EmployerRepository employerRepository;
	
	@Autowired
	Authoritiesrepositories authoritiesRepository;
	
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
	}
	
	public Authorities registerAuthorities(Authorities auth){
		return authoritiesRepository.save(auth);
	}

	public Registration register(Authorities aut) {
		
		Registration reg1 = aut.getUser();
		if(aut.getAuthorities().equals("ROLE_EMPLOYER")){
			reg1.setEnabled((long) 0);
		}else if(aut.getAuthorities().equals("ROLE_JOBSEEKER")){
			reg1.setEnabled((long) 1);
		}
		Registration reg =employerRepository.save(reg1);
		registerAuthorities(aut);
		return reg;	
		
	}

}
