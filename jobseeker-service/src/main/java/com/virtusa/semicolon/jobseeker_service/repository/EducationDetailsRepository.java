package com.virtusa.semicolon.jobseeker_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.semicolon.jobseeker_service.domain.EducationDetails;

@Repository
public interface EducationDetailsRepository extends JpaRepository<EducationDetails, Long> {

}
