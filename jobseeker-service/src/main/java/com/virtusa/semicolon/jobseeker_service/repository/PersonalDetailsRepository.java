<<<<<<< HEAD
package com.virtusa.semicolon.jobseeker_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.semicolon.jobseeker_service.domain.PersonalDetails;

@Repository
public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long>
{
	
	@Query("select p from PersonalDetails p where p.id=:id")
	PersonalDetails getPersonalDetails(@Param("id") Long id);

	@Query("select p from PersonalDetails p where p.userName=:userName")
	PersonalDetails findByUserName(@Param("userName") String userName);
	

=======
package com.virtusa.semicolon.jobseeker_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetailsRepository, String>
{
	
>>>>>>> d8f298d814b5899653bdb07ad2dd03fb7795d5f5
}