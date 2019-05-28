package com.smh.dao.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="BEACON_FEATURE")
public class BeaconFeature implements Serializable {

	private static final long serialVersionUID = -1821600500204006944L;

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="FEATURE_ID")
	private Long featureId;
	
	@Column(name="FEATURE_LEVEL")
	private Long featureLevel;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "ROLE_TYPE")
	private String roleType;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name="REF_FEATURE_ID")
	private Long refFeatureId;
	
	@Column(name = "CREATED_DATE",updatable=false)
	private Timestamp createdDate;

	/**
	 * @return the featureId
	 */
	public Long getFeatureId() {
		return featureId;
	}

	/**
	 * @param featureId the featureId to set
	 */
	public void setFeatureId(Long featureId) {
		this.featureId = featureId;
	}

	/**
	 * @return the roleType
	 */
	public String getRoleType() {
		return roleType;
	}

	/**
	 * @param roleType the roleType to set
	 */
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	/**
	 * @return the featureLevel
	 */
	public Long getFeatureLevel() {
		return featureLevel;
	}

	/**
	 * @param featureLevel the featureLevel to set
	 */
	public void setFeatureLevel(Long featureLevel) {
		this.featureLevel = featureLevel;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the refFeatureId
	 */
	public Long getRefFeatureId() {
		return refFeatureId;
	}

	/**
	 * @param refFeatureId the refFeatureId to set
	 */
	public void setRefFeatureId(Long refFeatureId) {
		this.refFeatureId = refFeatureId;
	}

	/**
	 * @return the createdDate
	 */
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

}
