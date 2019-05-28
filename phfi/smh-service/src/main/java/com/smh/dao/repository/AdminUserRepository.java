package com.smh.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.smh.dao.model.AdminUser;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long>, QueryDslPredicateExecutor<AdminUser> {

	List<AdminUser> findByUserNameAndPassword(String userName, String password);

	public List<AdminUser> findByUserName(String userName);

	public List<AdminUser> findByEmail(String email);
	
	public List<AdminUser> findByUserNameOrEmail(String userName,String email);

}
