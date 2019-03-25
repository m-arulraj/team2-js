package com.virtusa.semicolon.employer_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.semicolon.employer_service.domain.CompanyDetails;

@Repository
public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails, Long>{
	
	@Query("select c from CompanyDetails c where c.userName=:userName")
	CompanyDetails findByUserName(@Param("userName")String userName);
	
}

