package com.virtusa.semicolon.employer_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.semicolon.employer_service.domain.PostedJobsList;

@Repository

public interface PostedJobsListRepository extends JpaRepository<PostedJobsList,Long>{

	
}
