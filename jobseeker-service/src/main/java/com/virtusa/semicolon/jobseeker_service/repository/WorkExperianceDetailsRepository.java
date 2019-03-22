<<<<<<< HEAD
package com.virtusa.semicolon.jobseeker_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.semicolon.jobseeker_service.domain.WorkExperianceDetails;

@Repository
public interface WorkExperianceDetailsRepository extends JpaRepository<WorkExperianceDetails, Long> {

}
=======
package com.virtusa.semicolon.jobseeker_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.semicolon.jobseeker_service.domain.WorkExperianceDetails;

public interface WorkExperianceDetailsRepository extends JpaRepository<WorkExperianceDetails, String> {

}
>>>>>>> d8f298d814b5899653bdb07ad2dd03fb7795d5f5
