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
@Table(name="USER_ROLE")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 8990116697641153696L;

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="USER_ROLE_ID")
	private Long userRoleId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "ROLE_TYPE")
	private String role_type;
	
	@Column(name = "MAKER_CHECKER_REQ")
	private String maker_checker_req;
	
	@Column(name = "REASON")
	private String reason;
	
	@Column(name = "CREATED_DATE",updatable=false)
	private Timestamp createdDate;

	@Column(name = "UPDATED_DATE")
	private Timestamp updated_Date;

	@Column(name = "UPDATED_BY")
	private String updatedBy;
	
	@Column(name = "CREATED_BY",updatable=false)
	private String createdBy;
	
	@Column(name="ENTITY_ID",updatable=false)
	private Long entityId;

	/**
	 * @return the user_role_id
	 */
	public Long getUser_role_id() {
		return userRoleId;
	}

	/**
	 * @param user_role_id the user_role_id to set
	 */
	public void setUser_role_id(Long userRoleId) {
		this.userRoleId = userRoleId;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the role_type
	 */
	public String getRole_type() {
		return role_type;
	}

	/**
	 * @param role_type the role_type to set
	 */
	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}

	/**
	 * @return the maker_checker_req
	 */
	public String getMaker_checker_req() {
		return maker_checker_req;
	}

	/**
	 * @param maker_checker_req the maker_checker_req to set
	 */
	public void setMaker_checker_req(String maker_checker_req) {
		this.maker_checker_req = maker_checker_req;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
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

	/**
	 * @return the entityId
	 */
	public Long getEntityId() {
		return entityId;
	}

	/**
	 * @param entityId the entityId to set
	 */
	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	
}
