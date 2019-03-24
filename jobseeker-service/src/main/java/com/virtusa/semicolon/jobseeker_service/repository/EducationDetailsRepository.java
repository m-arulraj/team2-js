
package com.virtusa.semicolon.jobseeker_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.semicolon.jobseeker_service.domain.EducationDetails;

@Repository
public interface EducationDetailsRepository extends JpaRepository<EducationDetails, Long> {
	
	@Query("select e from EducationDetails e where e.userName=:userName")
	EducationDetails findByUserName(@Param("userName") String userName);
}
