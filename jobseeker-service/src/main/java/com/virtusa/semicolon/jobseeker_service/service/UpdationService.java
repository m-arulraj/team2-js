
package com.virtusa.semicolon.jobseeker_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.semicolon.jobseeker_service.domain.EducationDetails;
import com.virtusa.semicolon.jobseeker_service.domain.PersonalDetails;
import com.virtusa.semicolon.jobseeker_service.domain.WorkExperianceDetails;
import com.virtusa.semicolon.jobseeker_service.repository.EducationDetailsRepository;
import com.virtusa.semicolon.jobseeker_service.repository.PersonalDetailsRepository;
import com.virtusa.semicolon.jobseeker_service.repository.WorkExperianceDetailsRepository;

@Service
public class UpdationService {

	@Autowired
	PersonalDetailsRepository personalDetailsRepository;

	@Autowired
	EducationDetailsRepository educationDetailsRepository;
	
	@Autowired
	WorkExperianceDetailsRepository workExperianceDetailsRepository;

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

	public EducationDetails updateEducationDetails(String userName, EducationDetails educationDetails) {

		EducationDetails educationDetails2 = educationDetailsRepository.findByUserName(userName);
		if (educationDetails != null) {
			if (educationDetails.getHighestDegree() != null) {
				educationDetails2.setHighestDegree(educationDetails.getHighestDegree());
			}
			if (educationDetails.getCollege() != null) {
				educationDetails2.setCollege(educationDetails.getCollege());
			}
			if (educationDetails.getSpecialization() != null) {
				educationDetails2.setSpecialization(educationDetails.getSpecialization());
			}
			if (educationDetails.getYearOfPassout() != null) {
				educationDetails2.setYearOfPassout(educationDetails.getYearOfPassout());
			}
			if (educationDetails.getPercentage() != null) {
				educationDetails2.setPercentage(educationDetails.getPercentage());
			}
			if (educationDetails.getYearGap() != null) {
				educationDetails2.setYearGap(educationDetails.getYearGap());
			}
			if (educationDetails.getSkills() != null) {
				educationDetails2.setSkills(educationDetails.getSkills());
			}
			if (educationDetails.getResume() != null) {
				educationDetails2.setResume(educationDetails.getResume());
			}
			if (educationDetails.getNumberOfBacklogs() != null) {
				educationDetails2.setNumberOfBacklogs(educationDetails.getNumberOfBacklogs());
			}
			return educationDetailsRepository.save(educationDetails2);
		} else {
			return educationDetailsRepository.save(educationDetails);
		}
	}

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
