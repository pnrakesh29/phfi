package com.smh.rest.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.smh.exception.BeaconServiceException;
import com.smh.model.EditRoleResponse;
import com.smh.model.GetRolesOnUserTypeRequest;
import com.smh.model.GetRolesOnUserTypeResponse;
import com.smh.model.Response;
import com.smh.model.RoleFeatureResponse;
import com.smh.model.RoleLevelFeatureRequest;
import com.smh.model.UserRoleRequest;
import com.smh.model.UserRoleResponse;

@Service
public interface RestRoleService {
	
	/**
	 * An handler method used to create role
	 * @param createRoleRequest
	 * @return
	 * @throws BeaconServiceException
	 */
	public Response createOrUpdateRole(HttpServletRequest request,
									   HttpServletResponse response,
									   HttpSession session,
									   UserRoleRequest userRoleRequest) throws BeaconServiceException;
	
	/**
	 * An handler method used to create role
	 * @param createRoleRequest
	 * @return
	 * @throws BeaconServiceException
	 */
	public Response changeRoleStatus(HttpServletRequest request,
								     HttpServletResponse response,
								     HttpSession session,
								     UserRoleRequest userRoleRequest) throws BeaconServiceException;
	
	
	/**
	 * An handler method user to retrieve the user roles
	 * @param userRoleRequest
	 * @return
	 * @throws BeaconServiceException
	 */
	public GetRolesOnUserTypeResponse getRolesByUserType(HttpServletRequest request,
											   HttpServletResponse response,
											   HttpSession session,
											   UserRoleRequest userRoleRequest) throws BeaconServiceException;
	
	/**
	 * An handler method used to search role
	 * @param searchRoleRequest
	 * @return
	 * @throws BeaconServiceException
	 */
	public UserRoleResponse searchRole(HttpServletRequest request,
									   HttpServletResponse response,
									   HttpSession session,
									   UserRoleRequest userRoleRequest) throws BeaconServiceException;
 
	/**
	 * An handler method used to retrieve the role details
	 * @param editRoleRequest
	 * @return
	 * @throws BeaconServiceException
	 */
	public EditRoleResponse getRoleData(HttpServletRequest request,
									    HttpServletResponse response,
									    HttpSession session,
									    UserRoleRequest userRoleRequest) throws BeaconServiceException;

	/**
	 * An handler method used to retrieve the feature list
	 * @return
	 * @throws BeaconServiceException
	 */
	public RoleFeatureResponse getFeatureList() throws BeaconServiceException;

	/**
	 * An handler method used to retrieve the feature on role leave
	 * @param roleLevelFeatureRequest
	 * @return
	 * @throws BeaconServiceException
	 */
	public RoleFeatureResponse getFeatureOnRoleLevel(HttpServletRequest request,
													 HttpServletResponse response,
												     HttpSession session,
												     RoleLevelFeatureRequest roleLevelFeatureRequest) throws BeaconServiceException;

	/**
	 * An handler method used to retrieve the roles on user type
	 * @param getRolesOnUserTypeRequest
	 * @return
	 * @throws BeaconServiceException
	 */
	public GetRolesOnUserTypeResponse getRolesOnUserType(HttpServletRequest request,
														 HttpServletResponse response,
													     HttpSession session,
													   	 GetRolesOnUserTypeRequest getRolesOnUserTypeRequest) throws BeaconServiceException;
	
	/** Service to delete Role
	 * 
	 * @param roleId
	 * @return
	 * @throws BeaconServiceException
	 */
	public Response deleteRole(Long roleId) throws BeaconServiceException;
	
	public UserRoleResponse getActiveRole(HttpServletRequest request,
			  HttpServletResponse response,
			  HttpSession session,
			  UserRoleRequest roleRequest)	throws BeaconServiceException;



}