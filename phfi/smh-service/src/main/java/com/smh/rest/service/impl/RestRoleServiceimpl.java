package com.smh.rest.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smh.exception.BeaconServiceException;
import com.smh.handler.RoleServiceHandler;
import com.smh.model.EditRoleResponse;
import com.smh.model.GetRolesOnUserTypeRequest;
import com.smh.model.GetRolesOnUserTypeResponse;
import com.smh.model.Response;
import com.smh.model.RoleFeatureResponse;
import com.smh.model.RoleLevelFeatureRequest;
import com.smh.model.UserRoleRequest;
import com.smh.model.UserRoleResponse;
import com.smh.rest.service.RestRoleService;


@RestController
@RequestMapping(value = "/roleService", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestRoleServiceimpl implements RestRoleService {

	private Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private RoleServiceHandler roleServiceHandler;

	@Override
	@RequestMapping(value = "/createOrUpdateRole", method = RequestMethod.POST)
	public Response createOrUpdateRole(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			@RequestBody UserRoleRequest userRoleRequest)
			throws BeaconServiceException {
		logger.info("Entering:: RoleServiceimpl:: createOrUpdateRole method");
		Response responseErrorData = roleServiceHandler
				.createOrUpdateRole(userRoleRequest);
		logger.info("Exiting:: RoleServiceimpl:: createOrUpdateRole method");
		return responseErrorData;
	}

	@Override
	@RequestMapping(value = "/getRolesByUserType", method = RequestMethod.POST)
	public GetRolesOnUserTypeResponse getRolesByUserType(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			@RequestBody UserRoleRequest userRoleRequest)
			throws BeaconServiceException {
		logger.info("Entering:: RoleServiceimpl:: getRolesByUserType method");
		GetRolesOnUserTypeResponse response1 = roleServiceHandler
				.getRolesByUserType(userRoleRequest);
		logger.info("Exiting:: RoleServiceimpl:: getRolesByUserType method");
		return response1;
	}

	@Override
	@RequestMapping(value = "/searchRole", method = RequestMethod.POST)
	public UserRoleResponse searchRole(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			@RequestBody UserRoleRequest roleRequest)
			throws BeaconServiceException {
		logger.info("Entering:: RoleServiceimpl:: searchRole method");
		UserRoleResponse searchRoleResponse = roleServiceHandler.searchRole(roleRequest);
		logger.info("Exiting:: RoleServiceimpl:: searchRole method");
		return searchRoleResponse;
	}

	@Override
	@RequestMapping(value = "/getRoleData", method = RequestMethod.POST)
	public EditRoleResponse getRoleData(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			@RequestBody UserRoleRequest roleRequest)
			throws BeaconServiceException {
		logger.info("Entering:: RoleServiceimpl:: getRoleData method");
		EditRoleResponse editRoleResponseData = roleServiceHandler
				.getRoleData(roleRequest);
		logger.info("Exiting:: RoleServiceimpl:: getRoleData method");
		return editRoleResponseData;
	}

	@Override
	@RequestMapping(value = "/getFeatureList", method = RequestMethod.POST)
	public RoleFeatureResponse getFeatureList() throws BeaconServiceException {
		logger.info("Entering:: RoleServiceimpl:: getFeatureList method");
		RoleFeatureResponse roleFeatureResponse = roleServiceHandler
				.getFeatureList();
		logger.info("Exiting:: RoleServiceimpl:: getFeatureList method");
		return roleFeatureResponse;
	}

	@Override
	@RequestMapping(value = "/getFeatureOnRoleLevel", method = RequestMethod.POST)
	public RoleFeatureResponse getFeatureOnRoleLevel(
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session,
			@RequestBody RoleLevelFeatureRequest roleLevelFeatureRequest)
			throws BeaconServiceException {
		logger.info("Entering:: RoleServiceimpl:: getFeatureOnRoleLevel method");
		RoleFeatureResponse roleFeatureResponse = roleServiceHandler
				.getFeatureOnRoleLevel(roleLevelFeatureRequest);
		logger.info("Exiting:: RoleServiceimpl:: getFeatureOnRoleLevel method");
		return roleFeatureResponse;

	}

	@Override
	@RequestMapping(value = "/getRolesOnUserType", method = RequestMethod.POST)
	public GetRolesOnUserTypeResponse getRolesOnUserType(
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session,
			@RequestBody GetRolesOnUserTypeRequest getRolesOnUserTypeRequest)
			throws BeaconServiceException {
		logger.info("Entering:: RoleServiceimpl:: getRolesOnUserType method");
		GetRolesOnUserTypeResponse response1 = roleServiceHandler
				.getRolesOnUserType(getRolesOnUserTypeRequest);
		logger.info("Exiting:: RoleServiceimpl:: getRolesOnUserType method");
		return response1;
	}

	@Override
	@RequestMapping(value = "/changeRoleStatus", method = RequestMethod.POST)
	public Response changeRoleStatus(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			@RequestBody UserRoleRequest userRoleRequest)
			throws BeaconServiceException {

		logger.info("Entering:: RoleServiceimpl:: addOrUpdateRole method");
		Response responseErrorData = roleServiceHandler
				.changeRoleStatus(userRoleRequest);
		logger.info("Exiting:: RoleServiceimpl:: addOrUpdateRole method");

		return responseErrorData;
	}

	@Override
	@RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
	public Response deleteRole(@RequestBody Long roleId) throws BeaconServiceException {
		logger.info("Entering :: RoleServiceimpl :: deleteRole method");
		Response response = roleServiceHandler.deleteRole(roleId);
		logger.info("Exiting :: RoleServiceimpl :: deleteRole method");
		return response;
	}

	
	@Override
	@RequestMapping(value = "/getActiveRole", method = RequestMethod.POST)
	public UserRoleResponse getActiveRole(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			@RequestBody UserRoleRequest roleRequest)
			throws BeaconServiceException {
		logger.info("Entering:: RoleServiceimpl:: getActiveRole method");
		UserRoleResponse searchRoleResponse = roleServiceHandler.getActiveRole(roleRequest);
		logger.info("Exiting:: RoleServiceimpl:: getActiveRole method");
		return searchRoleResponse;
	}
	
	

}
