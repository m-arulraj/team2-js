package com.virtusa.semicolon.jobseeker_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.semicolon.jobseeker_service.domain.EducationDetails;
import com.virtusa.semicolon.jobseeker_service.repository.EducationDetailsRepository;

@Service
public class EducationDetailsService {

	@Autowired
	EducationDetailsRepository educationDetailsRepository;

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

}
