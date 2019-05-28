package com.smh.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.smh.dao.model.LoginSessionDetails;

public interface LoginSessionDetailsRepository extends JpaRepository<LoginSessionDetails, Long>, QueryDslPredicateExecutor<LoginSessionDetails> {

}
