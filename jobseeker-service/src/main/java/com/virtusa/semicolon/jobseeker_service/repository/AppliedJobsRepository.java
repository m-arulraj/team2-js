package com.virtusa.semicolon.jobseeker_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.semicolon.jobseeker_service.domain.AppliedJobs;

@Repository
public interface AppliedJobsRepository extends JpaRepository<AppliedJobs, Long> {

	@Query("select a from AppliedJobs a where a.userName=:userName and a.jobId=:jobId")
	AppliedJobs findByUserNameAndJobId(@Param("userName") String userName, @Param("jobId") Long jobId);
}
