package com.virtusa.semicolon.jobseeker_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.semicolon.jobseeker_service.domain.AppliedJobs;

@Repository
public interface AppliedJobsRepository extends JpaRepository<AppliedJobs, Long>{

	@Query("select e.userName from EducationDetails e where e.skills like '%:skills%'")
	List<String> getUserNameBySkills(@Param("skills") String skills);
}
