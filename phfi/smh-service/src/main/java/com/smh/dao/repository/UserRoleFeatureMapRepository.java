package com.smh.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.smh.dao.model.UserRoleFeatureMap;

public interface UserRoleFeatureMapRepository extends JpaRepository<UserRoleFeatureMap,Long>,QueryDslPredicateExecutor<UserRoleFeatureMap> {
	
	public List<UserRoleFeatureMap> findByRoleId(Long roleId);
}
