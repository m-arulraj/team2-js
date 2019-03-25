package com.virtusa.semicolon.employer_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.semicolon.employer_service.domain.CompanyDetails;
import com.virtusa.semicolon.employer_service.repository.CompanyDetailsRepository;

@Service
public class CompanyDetailsService {
	
	@Autowired
	CompanyDetailsRepository companyDetailsRepository;
	
	public CompanyDetails updateCompanyDetails(String userName,CompanyDetails companyDetails){
		CompanyDetails companyDetails2 = companyDetailsRepository.findByUserName(userName);
		
		if(companyDetails2!=null){
			if(companyDetails.getCompanyName()!=null){
				companyDetails2.setCompanyName(companyDetails.getCompanyName());
			}
			if(companyDetails.getContactNumber()!=null){
				companyDetails2.setContactNumber(companyDetails.getContactNumber());
			}
			if(companyDetails.getAddress()!=null){
				companyDetails2.setAddress(companyDetails.getAddress());
			}
			if(companyDetails.getEstablishedOn()!=null){
				companyDetails2.setEstablishedOn(companyDetails.getEstablishedOn());
			}
			return companyDetailsRepository.save(companyDetails2);
		}else{
			return companyDetailsRepository.save(companyDetails);
		}
	}

}
