package com.smh.handler.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smh.constants.PhfiErrorCodes;
import com.smh.constants.Constant;
import com.smh.dao.BeaconFeatureDao;
import com.smh.dao.RolesServiceProviderMappingDao;
import com.smh.dao.UserRoleDao;
import com.smh.dao.UserRoleEntityMapDao;
import com.smh.dao.UserRoleFeatureMapDao;
import com.smh.dao.model.BeaconFeature;
import com.smh.dao.model.UserRole;
import com.smh.dao.model.UserRoleEntityMap;
import com.smh.dao.model.UserRoleFeatureMap;
import com.smh.enums.RoleLevel;
import com.smh.exception.BeaconServiceException;
import com.smh.handler.RoleServiceHandler;
import com.smh.model.PHFIFeatureRequest;
import com.smh.model.EditRoleResponse;
import com.smh.model.GetRolesOnUserTypeRequest;
import com.smh.model.GetRolesOnUserTypeResponse;
import com.smh.model.Response;
import com.smh.model.RoleFeatureResponse;
import com.smh.model.RoleLevelFeatureRequest;
import com.smh.model.UserRoleRequest;
import com.smh.model.UserRoleResponse;
import com.smh.util.CommonUtil;
import com.smh.util.DateUtil;
import com.smh.util.MapUtil;
import com.smh.util.Properties;
import com.smh.util.StringUtil;

@Service("roleServiceHandler")
public class RoleServiceHandlerImpl implements RoleServiceHandler {
	

	
	private Logger logger = LogManager.getLogger(this.getClass());

	
	@Autowired
	private UserRoleFeatureMapDao userRoleFeatureMapDao;
	
	@Autowired
	private BeaconFeatureDao stylopayFeatureDao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Autowired
	private UserRoleEntityMapDao userRoleEntityMapDao;
	
	@Autowired
	private RolesServiceProviderMappingDao roleServiceMappingDao;
	
	 
	@Override
	@Transactional(rollbackFor=BeaconServiceException.class)
	public Response createOrUpdateRole(UserRoleRequest userRoleRequest) throws BeaconServiceException {
    logger.info("Entering:: AdminRoleHandlerImpl:: addOrUpdateRole method");
    Response responseErrorData = new Response();
    UserRole userRoles = new UserRole();
    try {
    	List<UserRole> roleData = userRoleDao.findByRoleName(userRoleRequest.getRoleName());
    	if (userRoleRequest.getUpdateCheckFlage()== null){
    		if(StringUtil.isListNotNullNEmpty(roleData)){
    			for(int i=0;i<roleData.size();i++){
    				UserRoleEntityMap userRoleEntityMap=userRoleEntityMapDao.findByUserRoleId(roleData.get(i).getUser_role_id());
    					if(userRoleEntityMap != null){
    						responseErrorData.setResponseCode(PhfiErrorCodes.ROLE_NAME_ALREADY_EXIST);
    						responseErrorData.setResponseMessage(Properties.getProperty(responseErrorData.getResponseCode()));
   	       	            	logger.info("Exiting:: AdminRoleHandlerImpl:: RoleNameExist:: addOrUpdateRole method");
   	       	         	    return responseErrorData;
    				} 
				}
			}
		}
    	
    	UserRole createUserRole = CommonUtil.copyBeanProperties(userRoleRequest, UserRole.class);
    	if (userRoleRequest.getRoleId() == null) {
    		createUserRole.setRole_type(String.valueOf(userRoleRequest.getRoleType()));
    		createUserRole.setStatus(Constant.ACTIVE);
    		createUserRole.setName(userRoleRequest.getRoleName());
    		createUserRole.setCreatedDate(DateUtil.getCurrentTimestamp());
    		}
    		
    		if (userRoleRequest.getRoleId() !=null) {
    			UserRole userRole = userRoleDao.findByUserRoleId(Long.valueOf(userRoleRequest.getRoleId()));
      	
      		if (userRoleRequest.getStatus() == null) {
      			userRoleRequest.setStatus(userRole.getStatus());
      			userRoleRequest.setReason(userRole.getReason());
        }
      		else if(!(userRole.getStatus().equals(Constant.ACTIVE))){
      			responseErrorData.setResponseCode(PhfiErrorCodes.ROLE_NOT_ACTIVE);
      			responseErrorData.setResponseMessage(Properties.getProperty(responseErrorData.getResponseCode()));
				  return responseErrorData;
      		}
      		createUserRole.setStatus(userRoleRequest.getStatus());
      		createUserRole.setName(userRoleRequest.getRoleName());
      		createUserRole.setDescription(userRoleRequest.getDescription());
      		createUserRole.setRole_type(userRole.getRole_type());
      		createUserRole.setUpdated_Date(DateUtil.getCurrentTimestamp());
      		createUserRole.setUser_role_id(Long.valueOf(userRoleRequest.getRoleId()));
    	}
    		logger.info(" AdminRoleHandlerImpl:: Before saveOrUpdate ::addOrUpdateRole");
    		userRoles =  userRoleDao.saveOrUpdateUserRole(createUserRole);
      		if(userRoles.getUser_role_id() == null)
      			throw new BeaconServiceException(Properties.getProperty("prepaid.role.error.message"));
      
      		if(userRoleRequest.getRoleId()== null && !StringUtil.isNull(userRoleRequest.getUserRoleEntityMapRequest())){
      			UserRoleEntityMap userRoleEntityMap = CommonUtil.copyBeanProperties(userRoleRequest.getUserRoleEntityMapRequest(), UserRoleEntityMap.class);
      			userRoleEntityMap.setUserRoleId(userRoles.getUser_role_id());
      			logger.info(" AdminRoleHandlerImpl:: Before saveOrUpdateUserRoleEntityMap:: addOrUpdateRole");
          		userRoleEntityMap =  userRoleDao.saveOrUpdateUserRoleEntityMap(userRoleEntityMap);
      		}
      		
      		if(userRoleRequest.getFeature() != null) {
      			for(String featureData : userRoleRequest.getFeature()) {
      				UserRoleFeatureMap featureMap = new UserRoleFeatureMap();
      					featureMap.setRoleId(userRoles.getUser_role_id());
						featureMap.setFeatureId(Long.valueOf(featureData));
      					featureMap.setCreatedBy(userRoleRequest.getCreatedBy());
      					featureMap.setCreatedDate(new Timestamp(System.currentTimeMillis()));
      					logger.info(" AdminRoleHandlerImpl:: Before saveOrUpdateUserRoleEntityMap:: addOrUpdateRole");
      					userRoleFeatureMapDao.saveOrUpdateUserRoleFeatureMap(featureMap);
      					logger.info("Saving:: AdminRoleHandlerImpl:: FeaturesIn PortalRoleFeatureMap:: addOrUpdateRole method");
      			}
      		}
      		
      		if (userRoleRequest.getRoleId() != null && userRoleRequest.getFeature() != null) {
      			logger.info(" AdminRoleHandlerImpl:: Before deleteUserRoleFeatureMap:: addOrUpdateRole");
      			userRoleFeatureMapDao.deleteUserRoleFeatureMap(Long.valueOf(userRoleRequest.getRoleId()));
      			if(userRoleRequest.getFeature() != null) {
      				for(String featureData : userRoleRequest.getFeature()) {
      					UserRoleFeatureMap featureMap = new UserRoleFeatureMap();
          				featureMap.setRoleId(userRoles.getUser_role_id());
          				featureMap.setFeatureId(Long.valueOf(featureData));
          				featureMap.setCreatedBy(userRoleRequest.getCreatedBy());
          				featureMap.setCreatedDate(new Timestamp(System.currentTimeMillis()));
          				logger.info(" AdminRoleHandlerImpl:: Before saveOrUpdateUserRoleEntityMap:: addOrUpdateRole");
          				userRoleFeatureMapDao.saveOrUpdateUserRoleFeatureMap(featureMap);
          				logger.info("Updating:: AdminRoleHandlerImpl:: FeaturesIn PortalRoleFeatureMap:: addOrUpdateRole method");
      				//	featureMappingDao.addFeatureDataList(Long.valueOf(userRoleRequest.getRoleId()), featureData, String.valueOf(userId));
      				}
      			}
      			logger.info("Exiting:: AdminRoleHandlerImpl:: addOrUpdateRole method");
      		}
      		responseErrorData.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
      		logger.info("Exiting:: AdminRoleHandlerImpl:: addOrUpdateRole method");
    	} catch(BeaconServiceException e) {
    		logger.error("ERROR:: AdminRoleHandlerImpl:: addOrUpdateRole method", e);
    		throw e;
    	} catch(Exception e) {
    		userRoleFeatureMapDao.deleteUserRoleFeatureMap(Long.valueOf(userRoleRequest.getRoleId()));
    		logger.error("ERROR:: AdminRoleHandlerImpl:: addOrUpdateRole method", e);
    		responseErrorData.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
    		responseErrorData.setResponseMessage(Properties.getProperty(responseErrorData.getResponseCode()));
    	}
    return responseErrorData;
	}
	
	@Override
	public GetRolesOnUserTypeResponse getRolesByUserType(UserRoleRequest userRoleRequest) throws BeaconServiceException {
		logger.info("Entering:: AdminRoleHandlerImpl:: getRolesByUserType method");
		GetRolesOnUserTypeResponse response = new GetRolesOnUserTypeResponse();
		try {
			List<UserRoleRequest> userRoles = new ArrayList<UserRoleRequest>();
			userRoles = userRoleDao.getUserRolesByRoleTypes(userRoleRequest);
			response.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
			response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
			response.setRoles(userRoles);
			logger.info("Exiting:: AdminRoleHandlerImpl:: getRolesOnUserType method");
		} catch(Exception e) {
			logger.error("ERROR:: AdminRoleHandlerImpl:: getRolesByUserType method", e);
			response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
    		response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
		}
		return response;
	}
	
  @Override
  public UserRoleResponse searchRole(UserRoleRequest roleRequest) throws BeaconServiceException {
    logger.info("Entering:: AdminRoleHandlerImpl:: searchRole method");
    UserRoleResponse searchRoleResponse = new UserRoleResponse();
    try {
      List<UserRoleRequest> roleList = userRoleDao.searchRoles(roleRequest);
      	searchRoleResponse.setUserRoleRequests(roleList);
      	searchRoleResponse.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
      	searchRoleResponse.setResponseMessage(Properties.getProperty(searchRoleResponse.getResponseCode()));
		searchRoleResponse.setNoOfRecords(roleRequest.getNoOfRecords());
		logger.info("Exiting:: AdminRoleHandlerImpl:: searchRole method");
    } catch(Exception e) {
      logger.error("ERROR:: AdminRoleHandlerImpl:: searchRole method", e);
      searchRoleResponse.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
      searchRoleResponse.setResponseMessage(Properties.getProperty(searchRoleResponse.getResponseCode()));
    }
    return searchRoleResponse;
  }

  
  @Override
  public EditRoleResponse getRoleData(UserRoleRequest roleRequest) throws BeaconServiceException {
    logger.info("Entering:: AdminRoleHandlerImpl:: getRoleData method");

    EditRoleResponse editRoleResponseData = new EditRoleResponse();
    try {
      UserRole userRole = userRoleDao.findByUserRoleId(Long.valueOf(roleRequest.getRoleId()));
      List<Long> existingFeature = stylopayFeatureDao.getFeatureDataOnRoleIdData(Long.valueOf(roleRequest.getRoleId()));
 
      List<PHFIFeatureRequest> features = stylopayFeatureDao.getFeatureOnRoleLevel((userRole.getRole_type()), Constant.ACTIVE);
     
     // List<BeaconFeatureRequest> features = CommonUtil.copyListBeanProperty(featureList, BeaconFeatureRequest.class);
      roleRequest.setCreatedBy(userRole.getCreatedBy());
      roleRequest.setDescription(userRole.getDescription());
      roleRequest.setMakerCheckerRequired(userRole.getMaker_checker_req());
      roleRequest.setRoleName(userRole.getName());
      roleRequest.setReason(userRole.getReason());
      roleRequest.setRoleType(RoleLevel.valueOf(userRole.getRole_type()));
      roleRequest.setStatus(userRole.getStatus());
      roleRequest.setUpdatedBy(userRole.getUpdatedBy());
      roleRequest.setRoleId(String.valueOf(userRole.getUser_role_id()));
    
      editRoleResponseData.setRoleRequest(roleRequest);
      editRoleResponseData.setFeatureMap((StringUtil.isListNotNullNEmpty(features)) ? getfeatureMap(features)  : null);
      editRoleResponseData.setExistingFeature(existingFeature);
      editRoleResponseData.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
      editRoleResponseData.setResponseMessage(Properties.getProperty(editRoleResponseData.getResponseCode()));
      logger.info("Exiting:: AdminRoleHandlerImpl:: getRoleData method");
    } catch(Exception e) {
      logger.error("ERROR:: AdminRoleHandlerImpl:: getRoleData method", e);
      editRoleResponseData.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
      editRoleResponseData.setResponseMessage(Properties.getProperty(editRoleResponseData.getResponseCode()));
    }
    return editRoleResponseData;
  }

  
 
   
  @Override
  public RoleFeatureResponse getFeatureList() throws BeaconServiceException {
    logger.info("Entering:: AdminRoleHandlerImpl:: getFeatureList method");

    RoleFeatureResponse roleFeatureResponse = new RoleFeatureResponse();
    try {
      List<BeaconFeature> featureList = stylopayFeatureDao.getFeatureList(Constant.ACTIVE);
      
      List<PHFIFeatureRequest> features = CommonUtil.copyListBeanProperty(featureList, PHFIFeatureRequest.class);
      
      if(StringUtil.isListNotNullNEmpty(features)) {
    	  logger.info("Exiting:: AdminRoleHandlerImpl:: getFeatureList method");
      	  roleFeatureResponse.setFeatureList(features);
      	  roleFeatureResponse.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
      	  roleFeatureResponse.setResponseMessage(Properties.getProperty(roleFeatureResponse.getResponseCode()));
       }
    } catch(Exception e) {
       logger.error("ERROR:: AdminRoleHandlerImpl:: getFeatureList method", e);
       roleFeatureResponse.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
       roleFeatureResponse.setResponseMessage(Properties.getProperty(roleFeatureResponse.getResponseCode()));
     }
     return roleFeatureResponse;
  }

  private Map<Long, List<PHFIFeatureRequest>> getfeatureMap(List<PHFIFeatureRequest> featureList) {
    logger.info("Entering:: AdminRoleHandlerImpl:: getFeatureList method");
    List<PHFIFeatureRequest> featureListData = null;
    Map<Long, List<PHFIFeatureRequest>> featureMap = new HashMap<Long, List<PHFIFeatureRequest>>();
    for(PHFIFeatureRequest feature : featureList) {
      if(feature.getFeatureLevel().longValue() == 0) {
        featureListData = featureMap.get(feature.getFeatureId());
        if(featureListData == null)
          featureListData = new ArrayList<PHFIFeatureRequest>();
        featureListData.add(feature);
        featureMap.put(feature.getFeatureId(), featureListData);
      }
      else if(feature.getFeatureLevel().longValue() == 1) {
        featureListData = featureMap.get(feature.getRefFeatureId());
        if(featureListData == null)
          featureListData = new ArrayList<PHFIFeatureRequest>();
        featureListData.add(feature);
        featureMap.put(feature.getRefFeatureId(), featureListData);

      }

    }
    logger.info("Exiting:: AdminRoleHandlerImpl:: getFeatureList method");
    return MapUtil.mySortedMap(featureMap);
  }


  @Override
  public RoleFeatureResponse getFeatureOnRoleLevel(RoleLevelFeatureRequest roleLevelFeatureRequest) throws BeaconServiceException {
    logger.info("Entering:: AdminRoleHandlerImpl:: getFeatureOnRoleLevel method");
    RoleFeatureResponse roleFeatureResponse = new RoleFeatureResponse();
    try {
    	List<PHFIFeatureRequest> features = stylopayFeatureDao.getFeatureOnRoleLevel("ADMIN".toString(),Constant.ACTIVE);
    
       roleFeatureResponse.setFeatureList((StringUtil.isListNotNullNEmpty(features)) ? features : null);
       roleFeatureResponse.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
   	   roleFeatureResponse.setResponseMessage(Properties.getProperty(roleFeatureResponse.getResponseCode()));
      logger.info("Exiting:: AdminRoleHandlerImpl:: getFeatureOnRoleLevel method");
    } catch(Exception e) {
      logger.error("ERROR:: AdminRoleHandlerImpl:: getFeatureOnRoleLevel method", e);
      roleFeatureResponse.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
      roleFeatureResponse.setResponseMessage(Properties.getProperty(roleFeatureResponse.getResponseCode()));
    }
    return roleFeatureResponse;

  }

  
  
  @Override
  public GetRolesOnUserTypeResponse getRolesOnUserType(GetRolesOnUserTypeRequest getRolesOnUserTypeRequest) throws BeaconServiceException {
    logger.info("Entering:: AdminRoleHandlerImpl:: getRolesOnUserType method");
    GetRolesOnUserTypeResponse response = new GetRolesOnUserTypeResponse();
    try {
      List<UserRoleRequest> userRoles = new ArrayList<UserRoleRequest>();
      UserRoleRequest request = new UserRoleRequest();
      if(!StringUtil.isNull(getRolesOnUserTypeRequest) && getRolesOnUserTypeRequest.getUserType() != null){
    	  List<String> roleType = Arrays.asList(getRolesOnUserTypeRequest.getUserType().name());
    	  	request.setRoleTypeList(roleType);
			request.setStatus(Constant.ACTIVE);
			userRoles = userRoleDao.getUserRolesByRoleTypes(request);
      } else if(!StringUtil.isNull(getRolesOnUserTypeRequest) && getRolesOnUserTypeRequest.getRoleTypeList() != null){
			request.setStatus(Constant.ACTIVE);
			request.setRoleTypeList(getRolesOnUserTypeRequest.getRoleTypeList());
			if(!StringUtil.isNull(getRolesOnUserTypeRequest.getEntityId())){
				request.setEntityId(getRolesOnUserTypeRequest.getEntityId());
			}
			userRoles = userRoleDao.getUserRolesByRoleTypes(request);
      } 
      response.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
  	  response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
      response.setRoles(userRoles);
      logger.info("Exiting:: AdminRoleHandlerImpl:: getRolesOnUserType method");
    } catch(Exception e) {
      logger.error("ERROR:: AdminRoleHandlerImpl:: getRolesOnUserType method", e);
      response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
      response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
    }
    return response;
  }

@Override
public Response changeRoleStatus(UserRoleRequest userRoleRequest)
		throws BeaconServiceException {

    logger.info("Entering:: AdminRoleHandlerImpl:: addOrUpdateRole method");
    Response responseErrorData = new Response();
    UserRole userRoles = new UserRole();
    try {
    	
    	UserRole createUserRole = CommonUtil.copyBeanProperties(userRoleRequest, UserRole.class);
    	if (userRoleRequest.getRoleId() == null) {
    		createUserRole.setRole_type(String.valueOf(userRoleRequest.getRoleType()));
    		createUserRole.setStatus(Constant.ACTIVE);
    		createUserRole.setName(userRoleRequest.getRoleName());
    		createUserRole.setCreatedDate(DateUtil.getCurrentTimestamp());
    		}
    		
    		if (userRoleRequest.getRoleId() !=null) {
    			UserRole userRole = userRoleDao.findByUserRoleId(Long.valueOf(userRoleRequest.getRoleId()));
    			
      		if (userRoleRequest.getStatus() == null) {
      			userRoleRequest.setStatus(userRole.getStatus());
      			userRoleRequest.setReason(userRole.getReason());
        }
      		UserRole updateUserRole = CommonUtil.copyBeanProperties(userRole, UserRole.class);
      		updateUserRole.setStatus(userRoleRequest.getStatus());
      		updateUserRole.setReason(userRoleRequest.getReason());
      		updateUserRole.setUpdated_Date(DateUtil.getCurrentTimestamp());
      		updateUserRole.setUpdatedBy(userRoleRequest.getUpdatedBy());
      		updateUserRole.setUser_role_id(Long.valueOf(userRoleRequest.getRoleId()));
      		userRoles =  userRoleDao.saveOrUpdateUserRole(updateUserRole);
    	}
    		logger.info(" AdminRoleHandlerImpl:: Before saveOrUpdate ::addOrUpdateRole");
    		
      		if(userRoles.getUser_role_id() == null)
      			throw new BeaconServiceException(Properties.getProperty("prepaid.role.error.message"));
      
      		if(userRoleRequest.getRoleId()== null && !StringUtil.isNull(userRoleRequest.getUserRoleEntityMapRequest())){
      			UserRoleEntityMap userRoleEntityMap = CommonUtil.copyBeanProperties(userRoleRequest.getUserRoleEntityMapRequest(), UserRoleEntityMap.class);
      			userRoleEntityMap.setUserRoleId(userRoles.getUser_role_id());
      			logger.info(" AdminRoleHandlerImpl:: Before saveOrUpdateUserRoleEntityMap:: addOrUpdateRole");
          		userRoleEntityMap =  userRoleDao.saveOrUpdateUserRoleEntityMap(userRoleEntityMap);
      		}
      		
      		if(userRoleRequest.getFeature() != null) {
      			for(String featureData : userRoleRequest.getFeature()) {
      				UserRoleFeatureMap featureMap = new UserRoleFeatureMap();
      					featureMap.setRoleId(userRoles.getUser_role_id());
						featureMap.setFeatureId(Long.valueOf(featureData));
      					featureMap.setCreatedBy(userRoleRequest.getCreatedBy());
      					featureMap.setCreatedDate(new Timestamp(System.currentTimeMillis()));
      					logger.info(" AdminRoleHandlerImpl:: Before saveOrUpdateUserRoleEntityMap:: addOrUpdateRole");
      					userRoleFeatureMapDao.saveOrUpdateUserRoleFeatureMap(featureMap);
      					logger.info("Saving:: AdminRoleHandlerImpl:: FeaturesIn PortalRoleFeatureMap:: addOrUpdateRole method");
      			}
      		}
      		
      		if (userRoleRequest.getRoleId() != null && userRoleRequest.getFeature() != null) {
      			logger.info(" AdminRoleHandlerImpl:: Before deleteUserRoleFeatureMap:: addOrUpdateRole");
      			userRoleFeatureMapDao.deleteUserRoleFeatureMap(Long.valueOf(userRoleRequest.getRoleId()));
      			if(userRoleRequest.getFeature() != null) {
      				for(String featureData : userRoleRequest.getFeature()) {
      					UserRoleFeatureMap featureMap = new UserRoleFeatureMap();
          				featureMap.setRoleId(userRoles.getUser_role_id());
          				featureMap.setFeatureId(Long.valueOf(featureData));
          				featureMap.setCreatedBy(userRoleRequest.getCreatedBy());
          				featureMap.setCreatedDate(new Timestamp(System.currentTimeMillis()));
          				logger.info(" AdminRoleHandlerImpl:: Before saveOrUpdateUserRoleEntityMap:: addOrUpdateRole");
          				userRoleFeatureMapDao.saveOrUpdateUserRoleFeatureMap(featureMap);
          				logger.info("Updating:: AdminRoleHandlerImpl:: FeaturesIn PortalRoleFeatureMap:: addOrUpdateRole method");
      				//	featureMappingDao.addFeatureDataList(Long.valueOf(userRoleRequest.getRoleId()), featureData, String.valueOf(userId));
      				}
      			}
      			logger.info("Exiting:: AdminRoleHandlerImpl:: addOrUpdateRole method");
      		}
      		responseErrorData.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
      		logger.info("Exiting:: AdminRoleHandlerImpl:: addOrUpdateRole method");
    	} catch(BeaconServiceException e) {
    		logger.error("ERROR:: AdminRoleHandlerImpl:: addOrUpdateRole method", e);
    		throw e;
    	} catch(Exception e) {
    		userRoleFeatureMapDao.deleteUserRoleFeatureMap(Long.valueOf(userRoleRequest.getRoleId()));
    		logger.error("ERROR:: AdminRoleHandlerImpl:: addOrUpdateRole method", e);
    		responseErrorData.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
    		responseErrorData.setResponseMessage(Properties.getProperty(responseErrorData.getResponseCode()));
    	}
    return responseErrorData;
	}

	@Override
	public Response deleteRole(Long roleId) throws BeaconServiceException {
		logger.info("Entering :: RoleServiceimpl :: deleteRole method");
		Response response = new Response();
		try {
			UserRole userRole = userRoleDao.findByUserRoleId(roleId);
			if (userRole == null) {
				throw new BeaconServiceException(PhfiErrorCodes.INVALID_ACCESS, Properties.getProperty(PhfiErrorCodes.INVALID_ACCESS));
			}
			if (!Constant.ACTIVE.equals(userRole.getStatus())) {
				throw new BeaconServiceException(PhfiErrorCodes.ROLE_NOT_ACTIVE, Properties.getProperty(PhfiErrorCodes.ROLE_NOT_ACTIVE));
			}
			userRole.setStatus(Constant.DELETED);
			userRole.setCreatedDate(userRole.getCreatedDate());
			userRole.setUpdated_Date(new Timestamp(System.currentTimeMillis()));
			userRoleDao.saveOrUpdateUserRole(userRole);
			response.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
			response.setResponseMessage(Properties.getProperty(response.getResponseCode()));

		} catch (BeaconServiceException e) {
			logger.error("Error :: RoleServiceimpl :: deleteRole method", e);
			response.setResponseCode(e.getErrorCode());
			response.setResponseMessage(e.getMessage());
		} catch (Exception e) {
			logger.error("Error :: RoleServiceimpl :: deleteRole method", e);
			response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
		    response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
		}
		logger.info("Exiting :: RoleServiceimpl :: deleteRole method");
		return response;
	}

	/**
	 * @param roleRequest
	 * @return
	 * @throws BeaconServiceException
	 */
	@Override
	public UserRoleResponse getActiveRole(UserRoleRequest roleRequest)throws BeaconServiceException {
	    logger.info("Entering:: AdminRoleHandlerImpl:: getActiveRole method");
	    UserRoleResponse searchRoleResponse = new UserRoleResponse();
	    try {
	      List<UserRoleRequest> roleList = userRoleDao.getActiveRole(roleRequest);
	      	searchRoleResponse.setUserRoleRequests(roleList);
	      	searchRoleResponse.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
	      	searchRoleResponse.setResponseMessage(Properties.getProperty(searchRoleResponse.getResponseCode()));
			searchRoleResponse.setNoOfRecords(roleRequest.getNoOfRecords());
			logger.info("Exiting:: AdminRoleHandlerImpl:: getActiveRole method");
	    } catch(Exception e) {
	      logger.error("ERROR:: AdminRoleHandlerImpl:: getActiveRole method", e);
	      searchRoleResponse.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
	      searchRoleResponse.setResponseMessage(Properties.getProperty(searchRoleResponse.getResponseCode()));
	    }
	    return searchRoleResponse;
	  }



}
