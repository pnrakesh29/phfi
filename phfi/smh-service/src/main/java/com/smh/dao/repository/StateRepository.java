package com.smh.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.smh.dao.model.State;

public interface StateRepository extends JpaRepository<State, Long>, QueryDslPredicateExecutor<State> {

	public List<State> findById(Long id);

	public List<State> findByStatus(String status);

	public List<State> findByCountryId(Long countryId);

}
