package com.virtusa.semicolon.employer_service.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.semicolon.employer_service.domain.CompanyDetails;

@Repository
public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails, Long>{

	@Query("SELECT cd.userName FROM CompanyDetails cd WHERE cd.userName = :userName")
	public List<String> getEmployerList(@Param("userName") String userName);
	
	@Transactional
	@Modifying
	@Query("update CompanyDetails c set c.companyName=:companyName, c.contactNumber=:contactNumber,c.establishedOn=:establishedOn,c.address=:address where c.userName=:userName")
	int updateCompanyDetails(@Param("userName") String userName,@Param("companyName") String companyName,@Param("contactNumber") Long contactNumber,@Param("establishedOn") String establishedOn,@Param("address") String address);
	
}

