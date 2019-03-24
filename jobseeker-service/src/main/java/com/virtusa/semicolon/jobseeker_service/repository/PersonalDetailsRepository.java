package com.virtusa.semicolon.jobseeker_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.semicolon.jobseeker_service.domain.PersonalDetails;

@Repository
public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long> {

	@Query("select p from PersonalDetails p where p.userName=:userName")
	PersonalDetails findByUserName(@Param("userName") String userName);
}