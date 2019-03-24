
package com.virtusa.semicolon.jobseeker_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.semicolon.jobseeker_service.domain.WorkExperianceDetails;

@Repository
public interface WorkExperianceDetailsRepository extends JpaRepository<WorkExperianceDetails, Long> {
	
	@Query("select w from WorkExperianceDetails w where w.userName=:userName")
	Optional<WorkExperianceDetails> findByUserName(@Param("userName") String userName);
	
	@Query("select w from WorkExperianceDetails w where w.userName=:userName")
	WorkExperianceDetails findByUserName2(@Param("userName") String userName);

}
