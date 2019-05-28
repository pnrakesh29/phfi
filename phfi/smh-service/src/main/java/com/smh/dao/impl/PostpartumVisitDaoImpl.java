/**
 * 
 */
package com.smh.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.smh.dao.PostpartumVisitDao;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 17, 2016 12:04:52 AM
 * @version 1.0
 */
@Repository("postpartumVisitDao")
public class PostpartumVisitDaoImpl implements PostpartumVisitDao{

	@PersistenceContext
	private EntityManager entityManager;
}
