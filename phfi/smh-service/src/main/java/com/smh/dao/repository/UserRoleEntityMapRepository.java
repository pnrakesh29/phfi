package com.smh.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.smh.dao.model.UserRoleEntityMap;

public interface UserRoleEntityMapRepository extends JpaRepository<UserRoleEntityMap,Long>,QueryDslPredicateExecutor<UserRoleEntityMap> {
	
	public UserRoleEntityMap findByUserRoleId(Long userRoleId);
}
