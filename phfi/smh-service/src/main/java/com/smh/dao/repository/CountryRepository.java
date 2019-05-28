package com.smh.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.smh.dao.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long>, QueryDslPredicateExecutor<Country> {

	public List<Country> findById(Long id);

	public Country findByName(String name);
}
