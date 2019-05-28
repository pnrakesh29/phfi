/**
 * 
 */
package com.smh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smh.dao.SymptomDao;
import com.smh.dao.model.Symptom;
import com.smh.dao.repository.SymptomRepository;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 24, 2016 7:35:36 PM
 * @version 1.0
 */
@Repository("symptomDao")
public class SymptomDaoImpl implements SymptomDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private SymptomRepository symptomRepository;

	/**
	 * @return
	 */
	@Override
	public List<Symptom> findAll() {
		return symptomRepository.findAll();
	}

}
