/**
 * 
 */
package com.smh.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 24, 2016 6:58:33 PM
 * @version 1.0
 */
@Entity
@Table(name = "SYMPTOM")
public class Symptom implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3200334442113470494L;
	@Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column(name = "ID")
	private Integer id;	
	
	@Column(name = "SYMPTOM_ID")
	private String symptomId;
	
	@Column(name = "SYMPTOM_PHRASES")
	private String symptomPhrases;
	 
	@Column(name = "SYMPTOM_SIGNS")
	private String symptomSigns;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the symptomId
	 */
	public String getSymptomId() {
		return symptomId;
	}

	/**
	 * @param symptomId the symptomId to set
	 */
	public void setSymptomId(String symptomId) {
		this.symptomId = symptomId;
	}

	/**
	 * @return the symptomPhrases
	 */
	public String getSymptomPhrases() {
		return symptomPhrases;
	}

	/**
	 * @param symptomPhrases the symptomPhrases to set
	 */
	public void setSymptomPhrases(String symptomPhrases) {
		this.symptomPhrases = symptomPhrases;
	}

	/**
	 * @return the symptomSigns
	 */
	public String getSymptomSigns() {
		return symptomSigns;
	}

	/**
	 * @param symptomSigns the symptomSigns to set
	 */
	public void setSymptomSigns(String symptomSigns) {
		this.symptomSigns = symptomSigns;
	}			
	
	

}
