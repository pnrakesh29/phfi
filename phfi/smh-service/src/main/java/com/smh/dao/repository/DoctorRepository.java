/**
 * 
 */
package com.smh.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.smh.dao.model.Doctor;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Mar 6, 2016 12:23:25 AM
 * @version 1.0
 */
public interface DoctorRepository extends JpaRepository<Doctor, Long>, QueryDslPredicateExecutor<Doctor>  {

}
