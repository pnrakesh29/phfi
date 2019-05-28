/**
 * 
 */
package com.smh.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.smh.dao.model.Symptom;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 24, 2016 7:34:22 PM
 * @version 1.0
 */
public interface SymptomRepository extends JpaRepository<Symptom, Long>, QueryDslPredicateExecutor<Symptom> {

}
