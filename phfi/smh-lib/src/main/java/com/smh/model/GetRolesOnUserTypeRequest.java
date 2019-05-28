/**
 * 
 */
package com.smh.model;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.smh.enums.RoleLevel;

/**
 * Model class to process Get Roles on User Type, SP and SSP request
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRolesOnUserTypeRequest extends Request implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 4689989935165767909L;

  private RoleLevel userType;

  private String spId;

  private String sspId;
  
  private List<String> statusListIn;
  
  private List<String> roleTypeList;
  
  private Long entityId;
  
  
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

	/**
	 * @return the userType
	 */
	public RoleLevel getUserType() {
		return userType;
	}
	
	/**
	 * @return the spId
	 */
	public String getSpId() {
		return spId;
	}
	
	/**
	 * @return the sspId
	 */
	public String getSspId() {
		return sspId;
	}
	
	/**
	 * @return the statusListIn
	 */
	public List<String> getStatusListIn() {
		return statusListIn;
	}
	
	/**
	 * @return the roleTypeList
	 */
	public List<String> getRoleTypeList() {
		return roleTypeList;
	}
	
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(RoleLevel userType) {
		this.userType = userType;
	}
	
	/**
	 * @param spId the spId to set
	 */
	public void setSpId(String spId) {
		this.spId = spId;
	}
	
	/**
	 * @param sspId the sspId to set
	 */
	public void setSspId(String sspId) {
		this.sspId = sspId;
	}
	
	/**
	 * @param statusListIn the statusListIn to set
	 */
	public void setStatusListIn(List<String> statusListIn) {
		this.statusListIn = statusListIn;
	}
	
	/**
	 * @param roleTypeList the roleTypeList to set
	 */
	public void setRoleTypeList(List<String> roleTypeList) {
		this.roleTypeList = roleTypeList;
	}
	  
}