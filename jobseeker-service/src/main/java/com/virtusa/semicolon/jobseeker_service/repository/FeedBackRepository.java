package com.virtusa.semicolon.jobseeker_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.semicolon.jobseeker_service.domain.FeedBack;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack, Long>{

	@Query("select f from FeedBack f where f.userName=:userName and f.jobId=:jobId")
	FeedBack findByUserNameAndJobId(@Param("userName") String userName, @Param("jobId") Long jobId);
}
