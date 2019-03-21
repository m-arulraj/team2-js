
package com.virtusa.semicolon.employer_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.semicolon.employer_service.domain.PostedJobsList;

@Repository

public interface PostedJobsListRepository extends JpaRepository<PostedJobsList,Long>{

@Query("SELECT p.jobId from PostedJobsList p WHERE p.jobTitle=:jobTitle")
List<String> getJobsIdList(@Param("jobTitle") String jobTitle);

@Query("SELECT p.jobTitle from PostedJobsList p WHERE p.jobTitle=:jobTitle")
List<String> getJobsTitleList(@Param("jobTitle") String jobTitle);


}
