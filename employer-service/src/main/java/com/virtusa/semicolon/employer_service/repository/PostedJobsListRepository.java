
package com.virtusa.semicolon.employer_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.semicolon.employer_service.domain.PostedJobsList;

@Repository

public interface PostedJobsListRepository extends JpaRepository<PostedJobsList, Long> {

	@Query("select p from PostedJobsList p where p.postedBy=:userName and p.jobId=:jobId")
	PostedJobsList findByUserNameAndJobId(@Param("userName") String userName, @Param("jobId") String jobId);

	@Query("select p from PostedJobsList p where p.postedBy=:userName")
	List<PostedJobsList> findByUserName(@Param("userName")String userName);
	
	@Query("select p from PostedJobsList p where p.id=:id")
	PostedJobsList findjobsById( @Param("id") Long id);
}
