package com.smh.service;

import com.smh.exception.SmhAdminException;
import com.smh.model.EditRoleResponse;
import com.smh.model.GetRolesOnUserTypeRequest;
import com.smh.model.GetRolesOnUserTypeResponse;
import com.smh.model.Response;
import com.smh.model.RoleFeatureResponse;
import com.smh.model.RoleLevelFeatureRequest;
import com.smh.model.UserRoleRequest;
import com.smh.model.UserRoleResponse;

public interface RoleService {

	RoleFeatureResponse getFeatureOnRoleLevel(RoleLevelFeatureRequest roleLevelFeatureRequest) throws SmhAdminException;

	Response createOrUpdateRole(UserRoleRequest userRoleRequest) throws SmhAdminException;
	
	public UserRoleResponse searchRole(UserRoleRequest roleRequest)throws SmhAdminException;
	
	public EditRoleResponse getRoleDetails(UserRoleRequest createRole)throws SmhAdminException;
	
    public Response changeRoleStatus(UserRoleRequest userRoleRequest) throws SmhAdminException;
	 
	public Response deleteRole(Long roleId)throws SmhAdminException;

	public GetRolesOnUserTypeResponse getRolesOnUserType(GetRolesOnUserTypeRequest getRolesOnUserTypeRequest) throws SmhAdminException;

	/**
	 * @param roleRequest
	 * @return
	 */
	UserRoleResponse getActiveRole(UserRoleRequest roleRequest) throws SmhAdminException;
}
