/**
 * 
 */
package com.smh.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.smh.dao.model.PregnancyVisit;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 15, 2016 7:24:46 PM
 * @version 1.0
 */
public interface PregnancyVisitRepository  extends JpaRepository<PregnancyVisit, Long>, QueryDslPredicateExecutor<PregnancyVisit> {
	public List<PregnancyVisit> findByWidOrderByCreatedDateDesc(Integer uid);
}
