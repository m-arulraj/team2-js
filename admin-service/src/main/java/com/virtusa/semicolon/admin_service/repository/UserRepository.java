package com.virtusa.semicolon.admin_service.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.virtusa.semicolon.admin_service.domain.User;

public interface UserRepository extends JpaRepository<User, String> {

	
	@Query("select u from User u where u.enabled = 0 ")
	List<User> showApprovalRequests();

	@Transactional
	@Modifying
	@Query("UPDATE User SET enabled = 1 WHERE userName = :username")
	public Integer approveEmployerRequest(@Param("username") String username);

	@Transactional
	@Modifying
	@Query("Delete User u where u.userName =:username ")
	public void deleteAccountByUsername(@Param("username") String username);

	@Transactional
	@Modifying
	@Query("UPDATE User SET enabled = 0 WHERE userName = :username")
	public User blockUserByUsername(@Param("username") String username);

	@Query("select u from User u where u.enabled = 0 ")
	List<User> showBlockedUser();

	@Transactional
	@Modifying
	@Query("UPDATE User SET userName =:newUserName WHERE userName = :username")
	void updateUsername(@Param("username") String username,@Param("newUserName") String newUserName);

}
