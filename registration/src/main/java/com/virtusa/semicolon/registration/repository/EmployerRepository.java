package com.virtusa.semicolon.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.semicolon.registration.domain.Registration;

@Repository
public interface EmployerRepository extends JpaRepository<Registration, String>{

}
