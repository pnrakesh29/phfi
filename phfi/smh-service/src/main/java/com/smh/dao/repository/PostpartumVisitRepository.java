/**
 * 
 */
package com.smh.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.smh.dao.model.PostpartumVisit;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 17, 2016 12:06:27 AM
 * @version 1.0
 */
public interface PostpartumVisitRepository extends JpaRepository<PostpartumVisit, Long>, QueryDslPredicateExecutor<PostpartumVisit> {
	public List<PostpartumVisit> findByWidOrderByCreatedDateDesc(int wid);
}
