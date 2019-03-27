
package com.virtusa.semicolon.jobseeker_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.semicolon.jobseeker_service.domain.WorkExperianceDetails;
import com.virtusa.semicolon.jobseeker_service.repository.WorkExperianceDetailsRepository;

@Service
public class WorkExperianceDetailsService {
	
	@Autowired
	WorkExperianceDetailsRepository workExperianceDetailsRepository;

	public WorkExperianceDetails updateWorkExperianceDetails(String userName,
			WorkExperianceDetails workExperianceDetails) {
		
		WorkExperianceDetails workExperianceDetails2 = workExperianceDetailsRepository.findByUserName2(userName);
		if(workExperianceDetails2!=null) {
			if(workExperianceDetails.getCompanyName()!=null) {
				workExperianceDetails2.setCompanyName(workExperianceDetails.getCompanyName());
			}
			if(workExperianceDetails.getDesignation()!=null) {
				workExperianceDetails2.setDesignation(workExperianceDetails.getDesignation());
			}
			if(workExperianceDetails.getRolesAndResponsibilities()!=null) {
				workExperianceDetails2.setRolesAndResponsibilities(workExperianceDetails.getRolesAndResponsibilities());
			}
			if(workExperianceDetails.getStartDate()!=null) {
				workExperianceDetails2.setStartDate(workExperianceDetails2.getStartDate());
			}
			if(workExperianceDetails.getEndDate()!=null) {
				workExperianceDetails2.setEndDate(workExperianceDetails.getEndDate());
			}
			if(workExperianceDetails.getCurrentSalary()!=null) {
				workExperianceDetails2.setCurrentSalary(workExperianceDetails.getCurrentSalary());
			}
			return workExperianceDetailsRepository.save(workExperianceDetails2);
		}else {
			workExperianceDetails.setUserName(userName);
			return workExperianceDetailsRepository.save(workExperianceDetails);
		}
	}
}
