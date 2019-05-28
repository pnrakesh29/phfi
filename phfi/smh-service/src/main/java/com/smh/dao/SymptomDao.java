/**
 * 
 */
package com.smh.dao;

import java.util.List;

import com.smh.dao.model.Symptom;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 24, 2016 7:35:24 PM
 * @version 1.0
 */
public interface SymptomDao {

	/**
	 * @return
	 */
	public List<Symptom> findAll();

}
