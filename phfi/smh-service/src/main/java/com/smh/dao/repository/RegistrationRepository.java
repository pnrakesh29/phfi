/**
 * 
 */
package com.smh.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.smh.dao.model.Registration;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 4, 2016 8:13:47 PM
 * @version 1.0
 */
public interface RegistrationRepository extends JpaRepository<Registration, Long>, QueryDslPredicateExecutor<Registration> {
	public Registration findByUid(int uid);
}
