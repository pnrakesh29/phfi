package com.smh.model;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRolesOnUserTypeResponse extends Response {

  /**
   * 
   */
  private static final long serialVersionUID = 2777308290381808811L;

  private List<UserRoleRequest> userRoleRequests;

/**
 * @return the roles
 */
public List<UserRoleRequest> getRoles() {
	return userRoleRequests;
}

/**
 * @param roles the roles to set
 */
public void setRoles(List<UserRoleRequest> roles) {
	this.userRoleRequests = roles;
}


}
