package com.virtusa.semicolon.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.semicolon.registration.domain.Authorities;

@Repository
public interface Authoritiesrepositories extends JpaRepository<Authorities, Long>{

}
