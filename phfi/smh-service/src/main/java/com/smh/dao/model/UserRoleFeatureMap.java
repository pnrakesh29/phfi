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
@Table(name="PORTAL_ROLE_FEATURE_MAP")
public class UserRoleFeatureMap implements Serializable {

	private static final long serialVersionUID = -1821600400204006944L;

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="ROLE_FEATURE_MAP_ID")
	private Long featureSequenceId;
	
	@Column(name="USER_ROLE_ID")
	private Long roleId;
	
	@Column(name="FEATURE_ID")
	private Long featureId;
	
	@Column(name = "CREATED_DATE",updatable=false)
	private Timestamp createdDate;

	@Column(name = "UPDATED_DATE")
	private Timestamp updated_Date;

	@Column(name = "UPDATED_BY")
	private String updatedBy;
	
	@Column(name = "CREATED_BY",updatable=false)
	private String createdBy;

	/**
	 * @return the featureSequenceId
	 */
	public Long getFeatureSequenceId() {
		return featureSequenceId;
	}

	/**
	 * @param featureSequenceId the featureSequenceId to set
	 */
	public void setFeatureSequenceId(Long featureSequenceId) {
		this.featureSequenceId = featureSequenceId;
	}

	/**
	 * @return the roleId
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

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

	/**
	 * @return the updated_Date
	 */
	public Timestamp getUpdated_Date() {
		return updated_Date;
	}

	/**
	 * @param updated_Date the updated_Date to set
	 */
	public void setUpdated_Date(Timestamp updated_Date) {
		this.updated_Date = updated_Date;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
}
