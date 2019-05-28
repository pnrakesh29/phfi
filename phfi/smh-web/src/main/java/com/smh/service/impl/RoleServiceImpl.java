package com.smh.service.impl;

import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import com.smh.exception.SmhAdminException;
import com.smh.model.EditRoleResponse;
import com.smh.model.GetRolesOnUserTypeRequest;
import com.smh.model.GetRolesOnUserTypeResponse;
import com.smh.model.Response;
import com.smh.model.RoleFeatureResponse;
import com.smh.model.RoleLevelFeatureRequest;
import com.smh.model.UserRoleRequest;
import com.smh.model.UserRoleResponse;
import com.smh.service.RoleService;
import com.smh.util.JsonUtil;
import com.smh.util.Properties;
import com.sun.jersey.api.client.ClientResponse;

@Service
public class RoleServiceImpl implements RoleService{


	public static Logger logger = Logger.getLogger(RoleServiceImpl.class);

	private ObjectMapper mapper = new ObjectMapper();
	@Override
	public RoleFeatureResponse getFeatureOnRoleLevel(RoleLevelFeatureRequest roleLevelFeatureRequest) throws SmhAdminException {

		logger.info("Entering :: UserRoleServiceImpl :: getFeatureOnRoleLevel method");
		try {
			ClientResponse response = JsonUtil.postRequest(roleLevelFeatureRequest, "/roleService/getFeatureOnRoleLevel");
			if (response.getStatus() != HttpStatus.SC_OK) {
				logger.error("Error :: UserRoleServiceImpl :: getFeatureOnRoleLevel method " + response.getStatus());
				throw new SmhAdminException("Unable to process your request. Please try again");
			}
			String output = response.getEntity(String.class);
			RoleFeatureResponse roleFeatureResponse = mapper.readValue(output, RoleFeatureResponse.class);
			logger.info("Exiting :: UserRoleServiceImpl :: getFeatureOnRoleLevel method");
			return roleFeatureResponse;
		} catch (Exception e) {
			logger.error("Error :: UserRoleServiceImpl :: getFeatureOnRoleLevel method", e);
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

	@Override
	public Response createOrUpdateRole(UserRoleRequest userRoleRequest) throws SmhAdminException {
		logger.info("Entering :: UserRoleServiceImpl :: createOrUpdateRole method");
		try {
			ClientResponse response = JsonUtil.postRequest(userRoleRequest, "/roleService/createOrUpdateRole");
			if (response.getStatus() != HttpStatus.SC_OK) {
				logger.error("Error :: UserRoleServiceImpl :: createOrUpdateRole method " + response.getStatus());
				throw new SmhAdminException("Unable to process your request. Please try again");
			}
			String output = response.getEntity(String.class);
			Response response1 = mapper.readValue(output, RoleFeatureResponse.class);
			logger.info("Exiting :: UserRoleServiceImpl :: createOrUpdateRole method");
			return response1;
		} catch (Exception e) {
			logger.error("Error :: UserRoleServiceImpl :: createOrUpdateRole method", e);
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}
	
	/*
	   * Method to Search Role
	   * @see com.prepaid.admin.rest.service.RoleService#searchRole(com.prepaid
	   * .admin.controller.model.SearchRole)
	   */
	  @Override
	  public UserRoleResponse searchRole(UserRoleRequest roleRequest) throws SmhAdminException {
	    logger.info("Entering:: UserRoleServiceImpl:: searchRole method");

	    try {
	      
	    	ClientResponse response = JsonUtil.postRequest(roleRequest, "/roleService/searchRole");
	    	if (response.getStatus() != HttpStatus.SC_OK) {
				logger.error("Error :: UserRoleServiceImpl :: searchRole method " + response.getStatus());
				throw new SmhAdminException("Unable to process your request. Please try again");
			}
			String output = response.getEntity(String.class);
			UserRoleResponse response1 = mapper.readValue(output, UserRoleResponse.class);
			logger.info("Exiting :: UserRoleServiceImpl :: searchRole method");
			return response1;
	    }
	       catch(Exception e) {
	      logger.error("ERROR:: UserRoleServiceImpl:: searchRole method", e);
	      throw new SmhAdminException("Unable to process your request. Please try again");
	    }

	  }
	  
	  /*
	   * Method to edit Role
	   * @see
	   * com.prepaid.admin.rest.service.RoleService#getRoleDetails(java.lang.Long)
	   */
	  @Override
	  public EditRoleResponse getRoleDetails(UserRoleRequest roleRequest) throws SmhAdminException {
	    logger.info("Entering:: UserRoleServiceImpl:: getEditRole method");
	    try {
	      ClientResponse response = JsonUtil.postRequest(roleRequest, "/roleService/getRoleData");
	      if (response.getStatus() != HttpStatus.SC_OK) {
				logger.error("Error :: UserRoleServiceImpl :: getEditRole method " + response.getStatus());
				throw new SmhAdminException("Unable to process your request. Please try again");
			}
			String output = response.getEntity(String.class);
			EditRoleResponse editRoleResponse = mapper.readValue(output, EditRoleResponse.class);
			logger.info("Exiting :: UserRoleServiceImpl :: getEditRole method");
	      return editRoleResponse;
	    }
	    catch(Exception e) {
	      logger.error("ERROR:: UserRoleServiceImpl:: getEditRole method", e);
	      throw new SmhAdminException("Unable to process your request. Please try again");
	    }
	  }
	  
	  @Override
	  public Response changeRoleStatus(UserRoleRequest userRoleRequest) throws SmhAdminException {
	    logger.info("Entering:: UserRoleServiceImpl:: changeRoleStatus method");
	    try {
	        ClientResponse response = JsonUtil.postRequest(userRoleRequest, "/roleService/changeRoleStatus");
	      if (response.getStatus() != HttpStatus.SC_OK) {
				logger.error("Error :: UserRoleServiceImpl :: changeRoleStatus method " + response.getStatus());
				throw new SmhAdminException("Unable to process your request. Please try again");
			}
	       String output = response.getEntity(String.class);
	       Response responseData = mapper.readValue(output, Response.class);
			logger.info("Exiting:: UserRoleServiceImpl:: changeRoleStatus method");
	      return responseData;
	    }
	    catch(SmhAdminException e) {
	      logger.error("ERROR:: UserRoleServiceImpl:: changeRoleStatus method", e);
	      throw new SmhAdminException(e.getMessage());
	    }
	    catch(Exception e) {
	      logger.error("error:method2::UserRoleServiceImpl::addRole", e);
	      throw new SmhAdminException(Properties.getProperty("chatak.genral.error"));
	    }
	  }
	  
	  
	  @Override
	  public Response deleteRole(Long roleId) throws SmhAdminException {
	    logger.info("Entering:: UserRoleServiceImpl:: deleteRole method");
	    try {
	        ClientResponse response = JsonUtil.postRequest(roleId, "/roleService/deleteRole");
	      if (response.getStatus() != HttpStatus.SC_OK) {
				logger.error("Error :: UserRoleServiceImpl :: deleteRole method " + response.getStatus());
				throw new SmhAdminException("Unable to process your request. Please try again");
			}
	       String output = response.getEntity(String.class);
	       Response responseData = mapper.readValue(output, Response.class);
			logger.info("Exiting:: UserRoleServiceImpl:: deleteRole method");
	      return responseData;
	    }
	    catch(SmhAdminException e) {
	      logger.error("ERROR:: UserRoleServiceImpl:: changeRoleStatus method", e);
	      throw new SmhAdminException(e.getMessage());
	    }
	    catch(Exception e) {
	      logger.error("error:method2::UserRoleServiceImpl::addRole", e);
	      throw new SmhAdminException(Properties.getProperty("chatak.genral.error"));
	    }
	  }

	@Override
	public GetRolesOnUserTypeResponse getRolesOnUserType(GetRolesOnUserTypeRequest getRolesOnUserTypeRequest)
			throws SmhAdminException {
		logger.info("Entering :: UtilityServiceImpl :: getStatesByCountry method");
		try {
			ClientResponse response = JsonUtil.postRequest(getRolesOnUserTypeRequest, "/roleService/getRolesByUserType");
			if (response.getStatus() != HttpStatus.SC_OK) {
				logger.error("Error :: UtilityServiceImpl :: getStatesByCountry method " + response.getStatus());
				throw new SmhAdminException("Unable to process your request. Please try again");
			}
			String output = response.getEntity(String.class);
			GetRolesOnUserTypeResponse getRolesOnUserTypeResponse = mapper.readValue(output, GetRolesOnUserTypeResponse.class);
			logger.info("Exiting :: UtilityServiceImpl :: getStatesByCountry method");
			return getRolesOnUserTypeResponse;
		} catch (Exception e) {
			logger.error("Error :: UtilityServiceImpl :: getStatesByCountry method", e);
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

	/**
	 * @param roleRequest
	 * @return
	 * @throws SmhAdminException
	 */
	@Override
	public UserRoleResponse getActiveRole(UserRoleRequest roleRequest)throws SmhAdminException {
	    logger.info("Entering:: UserRoleServiceImpl:: searchRole method");

	    try {
	      
	    	ClientResponse response = JsonUtil.postRequest(roleRequest, "/roleService/getActiveRole");
	    	if (response.getStatus() != HttpStatus.SC_OK) {
				logger.error("Error :: UserRoleServiceImpl :: searchRole method " + response.getStatus());
				throw new SmhAdminException("Unable to process your request. Please try again");
			}
			String output = response.getEntity(String.class);
			UserRoleResponse response1 = mapper.readValue(output, UserRoleResponse.class);
			logger.info("Exiting :: UserRoleServiceImpl :: searchRole method");
			return response1;
	    }
	       catch(Exception e) {
	      logger.error("ERROR:: UserRoleServiceImpl:: searchRole method", e);
	      throw new SmhAdminException("Unable to process your request. Please try again");
	    }

	  }


}
