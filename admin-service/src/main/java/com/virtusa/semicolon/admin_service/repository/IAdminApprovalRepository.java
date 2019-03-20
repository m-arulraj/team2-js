package com.virtusa.semicolon.admin_service.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.semicolon.admin_service.domain.Employer;
import com.virtusa.semicolon.admin_service.domain.User;

@Repository
public interface IAdminApprovalRepository extends JpaRepository<User, String> {

	/* as u where u.enabled = 0 */
	@Query("select u from User u where u.enabled = 0")
	List<User> showApprovalRequests();

	@Transactional
	@Modifying
	@Query("UPDATE User SET enabled = 1 WHERE userName = :username")
	public Integer approveEmployerRequest(@Param("username") String username);
}
