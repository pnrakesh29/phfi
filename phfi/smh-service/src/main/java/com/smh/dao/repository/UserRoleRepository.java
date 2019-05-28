package com.smh.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.smh.dao.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole,Long>,QueryDslPredicateExecutor<UserRole> {
	
	public List<UserRole> findByUserRoleId(Long userRoleId);
	
	public List<UserRole> findByName(String name);

}
