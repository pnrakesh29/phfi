package com.smh.model;

import java.util.ArrayList;
import java.util.List;

public class AdminUserResponse extends Response {

	private static final long serialVersionUID = 1353406983467779109L;

	  private List<AdminUserRequest> adminUserList = new ArrayList<AdminUserRequest>();

	/**
	 * @return the adminUserList
	 */
	public List<AdminUserRequest> getAdminUserList() {
		return adminUserList;
	}

	/**
	 * @param adminUserList the adminUserList to set
	 */
	public void setAdminUserList(List<AdminUserRequest> adminUserList) {
		this.adminUserList = adminUserList;
	}
	  
	  
}
