<<<<<<< HEAD
package com.virtusa.semicolon.employer_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.semicolon.employer_service.domain.PostedJobsList;

@Repository

public interface PostedJobsListRepository extends JpaRepository<PostedJobsList,Long>{

}
=======
package com.virtusa.semicolon.employer_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.semicolon.employer_service.domain.PostedJobsList;

@Repository

public interface PostedJobsListRepository extends JpaRepository<PostedJobsList,Long>{

	@Query("select p.jobId from PostedJobsList p where p.jobTitle=:jobTitle")
	public List<String> managingJobList(@Param("jobTitle") String jobTitle);
}
>>>>>>> 908a1bf75b7469635f0b7d499725f6ff684b05df
