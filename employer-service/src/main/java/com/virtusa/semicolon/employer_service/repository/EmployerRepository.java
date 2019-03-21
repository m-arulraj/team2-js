package com.virtusa.semicolon.employer_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.semicolon.employer_service.domain.CompanyDetails;


public interface EmployerRepository extends JpaRepository<CompanyDetails, Long>{

}
