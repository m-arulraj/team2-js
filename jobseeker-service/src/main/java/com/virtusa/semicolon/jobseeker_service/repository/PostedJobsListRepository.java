package com.virtusa.semicolon.jobseeker_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.semicolon.jobseeker_service.domain.PostedJobsList;

@Repository
public interface PostedJobsListRepository extends JpaRepository<PostedJobsList, Long>{
	
	List<PostedJobsList> findByJobTitleContainingIgnoreCase(String jobTitle);

	@Query("select p from PostedJobsList p where p.id=:jobId")
	PostedJobsList findByJobId(@Param("jobId")Long jobId);

}
