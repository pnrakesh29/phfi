/**
 * 
 */
package com.smh.handler.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smh.constants.PhfiErrorCodes;
import com.smh.constants.Constant;
import com.smh.dao.AdminUserDao;
import com.smh.dao.LoginSessionDetailsDao;
import com.smh.dao.UserRoleDao;
import com.smh.dao.model.AdminUser;
import com.smh.dao.model.UserRole;
import com.smh.enums.RoleLevel;
import com.smh.enums.Status;
import com.smh.exception.BeaconServiceException;
import com.smh.handler.UserHandler;
import com.smh.mailsender.service.impl.MailServiceManagementImpl;
import com.smh.model.AdminUserRequest;
import com.smh.model.AdminUserResponse;
import com.smh.model.Response;
import com.smh.util.CommonUtil;
import com.smh.util.DateUtil;
import com.smh.util.EncryptionUtil;
import com.smh.util.PasswordHandler;
import com.smh.util.Properties;
import com.smh.util.StringUtil;
import com.smh.velocity.IVelocityTemplateCreator;
import com.smh.velocity.impl.VelocityTemplateCreatorImpl;

@Service("userService")
public class UserHandlerImpl implements UserHandler {

  private static Logger logger = Logger.getLogger(UserHandlerImpl.class);

  @Autowired
  private AdminUserDao adminUserDao;
  
  @Autowired
  private UserRoleDao userRoleDao;
  
  @Autowired
  private LoginSessionDetailsDao loginSessionDetailsDao;
  
  @Autowired
  MailServiceManagementImpl mailServiceManagementImpl;

	    @Override
	    public Response createOrUpdateUser(AdminUserRequest adminUserRequest) throws BeaconServiceException {
	  	  logger.info("Entering:: AdminUserHandlerImpl:: addUpdateAdminUser method: ");
	  	  Response response = new Response();
	      try {
	    	  String emailToken = null;
	    	  if(StringUtil.isNull(adminUserRequest.getAdminUserId())) {
	    		  emailToken = StringUtil.getEmailToken(Constant.EMAIL_TOKEN_SET_NEW_PASSWORD,  Constant.EMPTY,  Constant.EMPTY, adminUserRequest.getEmail());
	    		  adminUserRequest.setEmailToken(emailToken);
	    	  }
	    	  AdminUser adminUserDetails = CommonUtil.copyBeanProperties(adminUserRequest, AdminUser.class);
	    	  if (StringUtil.isNull(adminUserRequest.getAdminUserId())) {
	    		  //Checking If Admin User is Already Exist With the UserName And Email id
	    		  List<AdminUser> adminUsersList = adminUserDao.findByAdminUserLoginNameOrEmail(adminUserRequest.getUserName(), adminUserRequest.getEmail());
	    		  if (CommonUtil.isListNotNullAndEmpty(adminUsersList)) {
	    			  if(CommonUtil.isListNotNullAndEmpty(adminUsersList) || adminUserRequest.getEmail().equalsIgnoreCase(adminUsersList.get(0).getEmail())){
	    				  if (adminUsersList.get(0).getEmail().equalsIgnoreCase(adminUserRequest.getEmail())) {
	    					    logger.error("info:: AdminUserHandlerImpl:: email already exist:: addUpdateAdminUser method: ");
	    					    response.setResponseCode(PhfiErrorCodes.USER_EMAIL_ALRAEDY_EXIST);
	    		    	        response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
	      				  		return response;
	    				  } else if(adminUsersList.get(0).getUserName().equalsIgnoreCase(adminUserRequest.getUserName())) {
	    					  logger.error("info:: AdminUserHandlerImpl:: email already exist:: addUpdateAdminUser method: ");
	    					  logger.error("info:: AdminUserHandlerImpl:: usename already exist:: addUpdateAdminUser method: ");
	    					  response.setResponseCode(PhfiErrorCodes.ADMIN_USER_ALREADY_EXIST);
	    					  response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
	    					  return response;
	    				  }
	    				 
	    			  }
	    		  } else {
	    			  adminUserDetails.setPhone(adminUserRequest.getPhone());
	    			  adminUserDetails.setUserRoleId(adminUserRequest.getUserRoleId());
	    			  adminUserDetails.setEmail(adminUserRequest.getEmail());
	    			  adminUserDetails.setStatus(Status.Active.name());
	    			  adminUserDetails.setLoginMode(Constant.LONG_ZERO);
	    			  adminUserDetails.setLastPassWordChange(DateUtil.getCurrentTimestamp());
	    			  adminUserDetails.setPassRetryCount(0);
	    			  adminUserDetails.setCreatedDate(DateUtil.getCurrentTimestamp());
	    		  }
	    	  }
	       // Updating the AdminUser Details and Checking if Email id is Exist throwing the Error  
	    	  if ((!StringUtil.isNull(adminUserRequest.getAdminUserId())) && (!StringUtil.isNull(adminUserRequest.getEmail()))) {
	    		  List<AdminUser> adminUsersList = adminUserDao.findByUserEmailId(adminUserRequest.getEmail());
	    		  if (CommonUtil.isListNotNullAndEmpty(adminUsersList) && adminUsersList.get(0).getAdminUserId().compareTo(adminUserRequest.getAdminUserId())!= 0) {
	    			  logger.error("info:: AdminUserHandlerImpl:: email id already exist:: addUpdateAdminUser method: ");
	    			  response.setResponseCode(PhfiErrorCodes.USER_EMAIL_ALRAEDY_EXIST);
	    	          response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
	  			      return response;
	    		  } 
	    		  else if(CommonUtil.isListNotNullAndEmpty(adminUsersList) && !(adminUsersList.get(0).getStatus().equalsIgnoreCase(Constant.ACTIVE))) {
					  logger.error("info:: AdminUserHandlerImpl:: status is not active:: addUpdateAdminUser method: ");
					  response.setResponseCode(PhfiErrorCodes.USER_NOT_ACTIVE);
					  response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
					  return response;
				  }
	    		  else {
	  					adminUserDetails = adminUserDao.findByAdminUserId(adminUserRequest.getAdminUserId());
	  				if (!adminUserDetails.getEmail().equalsIgnoreCase(adminUserRequest.getEmail())) {
	  					adminUserRequest.setPreviousEmailId(adminUserDetails.getEmail());
	  				}
	  				adminUserDetails.setEmail(adminUserRequest.getEmail().trim());
	  				adminUserDetails.setFirstName(adminUserRequest.getFirstName().trim());
	  				adminUserDetails.setPhone(adminUserRequest.getPhone());
	  				adminUserDetails.setLastName(adminUserRequest.getLastName().trim());
	  				adminUserDetails.setUpdatedBy(adminUserRequest.getUpdatedBy());
	  				adminUserDetails.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
	  				adminUserDetails.setCreatedBy(adminUserRequest.getCreatedBy());
	    		  }
	    	  }
	      //  Updating the Admin User Status and Sending the Mail to The User
	        if (adminUserRequest.getStatusChangeFlage() != null &&  adminUserRequest.getStatusChangeFlage().equalsIgnoreCase(Constant.Yes)) {
	        	logger.info("AdminUserHandlerImpl :: Before Sending Mail");
	      	  	 adminUserDetails = adminUserDao.findByAdminUserId(adminUserRequest.getAdminUserId());
	      	  	 adminUserDetails.setStatus(adminUserRequest.getStatus());
	      	  	 adminUserDetails.setFirstName(adminUserRequest.getFirstName());
	      	  	 adminUserDetails.setLastName(adminUserRequest.getLastName());
	      	  	 adminUserDetails.setEmail(adminUserRequest.getEmail());
	      	  	 adminUserDetails.setPhone(adminUserRequest.getPhone());
	      	  	 adminUserDetails.setUpdatedBy(adminUserRequest.getUpdatedBy());
	      	  	 if(!StringUtil.isNullAndEmpty(adminUserRequest.getReason())){
	      	  		adminUserDetails = adminUserDao.findByAdminUserId(adminUserRequest.getAdminUserId());
	      	 	    adminUserDetails.setStatus(adminUserRequest.getStatus());
	      	 	    adminUserDetails.setReason(adminUserRequest.getReason());
	      	  	 }
	        	 adminUserDetails.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
	       	  	String mailsubject = Properties.getProperty("phif.email.admin.status.subject");
	            IVelocityTemplateCreator iVelocityTemplateCreator = new VelocityTemplateCreatorImpl();
	            String toMail = adminUserDetails.getEmail();
	            String fromAddress = Properties.getProperty("phif.from.email.id");
	            Map<String,String> dataMap = new HashMap<String,String>();
	            dataMap.put("firstName",adminUserDetails.getFirstName());
	            dataMap.put("changedStatus", adminUserRequest.getStatus());
	            if (adminUserRequest.getStatus().equals(Status.Suspended.name())) {
	          	  dataMap.put("previousStatus", Status.Active.name());
	            } else{
	          	  dataMap.put("previousStatus", Status.Suspended.name());
	            }
	            String mailBodyString = iVelocityTemplateCreator.createEmailTemplate(dataMap, Constant.USER_SATATUS_CHANGE);
	             mailServiceManagementImpl.sendMailHtml(fromAddress, mailBodyString, toMail, mailsubject);
	        	}
	        	//String emailAction = "";
	        	String password = "";
	        	//Generating the PassWord
	        	if(StringUtil.isNull(adminUserRequest.getAdminUserId())) {
	        		adminUserDetails.setUserName(adminUserRequest.getUserName().trim());
	        		password = PasswordHandler.getSystemGeneratedPassword(8);
	        		adminUserDetails.setPassword(PasswordHandler.bCryptEncode(password));
	        		adminUserDetails.setPreviousPasswords(PasswordHandler.bCryptEncode(password));
	        		adminUserDao.saveOrUpdateAdminUser(adminUserDetails);
	        	//	emailAction = "New User Create";
	        	} else {
	        		adminUserDao.saveOrUpdateAdminUser(adminUserDetails);
	        	//	emailAction = "User Update";
	        	}
	        	//Sending the Mail to the Newly Created User
	        	if(!StringUtil.isNull(adminUserRequest.getPreviousEmailId())) {
	        		logger.info("Entering:: AdminUserHandlerImpl:: sent Mail method: ");
	        		String subject = Properties.getProperty("phif.email.admin.change.email.subject");
	      	
	        		IVelocityTemplateCreator iVelocityTemplateCreator = new VelocityTemplateCreatorImpl();
	        		Map<String,String> dataMap = new HashMap<String,String>();
	        		dataMap.put("firstName", adminUserRequest.getFirstName());
	        		dataMap.put("previousEmailId",adminUserRequest.getPreviousEmailId());
	        		dataMap.put("newEmailId", adminUserRequest.getEmail());
	        		String mailBodyString = iVelocityTemplateCreator.createEmailTemplate(dataMap, Constant.UPDATE_ADMIN_USER_TEMPLATE);
	        		String fromAddress = Properties.getProperty("phfi.from.email.id");
	        		mailServiceManagementImpl.sendMailHtml(fromAddress, mailBodyString, adminUserRequest.getPreviousEmailId(), subject);
	        		mailServiceManagementImpl.sendMailHtml(fromAddress, mailBodyString, adminUserRequest.getEmail(), subject);
	        	}
	        	if(!StringUtil.isNullEmpty(adminUserRequest.getEmailToken()) && StringUtil.isNull(adminUserRequest.getAdminUserId())) {
	        		logger.info("AdminUserHandlerImpl :: Before Sending Mail");
	        		String subject = Properties.getProperty("phif.email.user.create.subject");
	        		String url = null;
 	        		if((RoleLevel.SYSTEM.name().equals(adminUserRequest.getUserType()))) {
	        			url = Properties.getProperty("phif.admin.beacon.user.redirection.url");
	        		}
	        		/*else if((RoleLevel.HCE.name().equals(adminUserRequest.getUserType()))) {
	        			url = Properties.getProperty("phif.admin.user.redirection.url");
	        			subject = Properties.getProperty("phif.email.user.create.subject");
	        		}*/
	        		else {
	        			url = Properties.getProperty("phif.admin.beacon.user.redirection.url");
	        			subject = Properties.getProperty("phif.email.user.create.subject");
	        		}
	        		url = url + "?t=" + emailToken;
	        		//  Boolean isSuccess =  emailService.sendEMail(emailData);
	        		IVelocityTemplateCreator iVelocityTemplateCreator = new VelocityTemplateCreatorImpl();
	        		Map<String,String> dataMap = new HashMap<String,String>();
	  		
	        		//To get the role name for which the user is created
	        		UserRole roleRequest = userRoleDao.findByUserRoleId(adminUserRequest.getUserRoleId());
	  	    
	        		dataMap.put("roleName", roleRequest.getName());
	        		dataMap.put("firstName", adminUserRequest.getFirstName());
	        		dataMap.put("userName", adminUserRequest.getUserName());
	        		String usertype = null;
	        		if (adminUserRequest.getUserType().equalsIgnoreCase(RoleLevel.SYSTEM.name()))
	        			usertype = Constant.SYSTEM;
	        		/*else if (adminUserRequest.getUserType().equalsIgnoreCase(RoleLevel.HCE.name()))
	        			usertype = Constant.HCE;
	        		else if (adminUserRequest.getUserType().equalsIgnoreCase(RoleLevel.SPTSM.name()))
	        			usertype = Constant.SPTSM;
	        		else if (adminUserRequest.getUserType().equalsIgnoreCase(RoleLevel.SYSTEM.name()))
	        			usertype = Constant.SYSTEM;*/
	        		dataMap.put("usertype", usertype);
	        		dataMap.put("hLink", url);
	        		dataMap.put("tempPassword", password);
	        		String mailBodyString = iVelocityTemplateCreator.createEmailTemplate(dataMap, Constant.CREATE_ADMIN_USER_TEMPLATE);
	        		String fromAddress = Properties.getProperty("phfi.from.email.id");
	        		mailServiceManagementImpl.sendMailHtml(fromAddress, mailBodyString, adminUserRequest.getEmail(), subject);
	        	}
	        	response.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
				response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
	      	}
	      	catch(BeaconServiceException e) {
	      		logger.error("ERROR: AdminUserHandlerImpl:: addUpdateAdminUser method" + e.getMessage());
	      		response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
	      		response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
	      } catch(Exception e) {
	    	  logger.error("ERROR: UserManagementImpl:: addUpdateAdminUser method", e);
	    	  response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
	      	  response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
	      }
	      return response;
	    }
	    
	    @Override
	    public AdminUserResponse searchAdminUser(AdminUserRequest adminUserRequest) throws BeaconServiceException {
	  	  AdminUserResponse response = new AdminUserResponse();
	      try {
	      	logger.info("Entering:: AdminUserHandlerImpl:: searchAdminUser method: ");
	        	List<AdminUserRequest>  userRequestList = adminUserDao.searchAdminUser(adminUserRequest);
	        	response.setNoOfRecords(adminUserRequest.getNoOfRecords());
	        	response.setAdminUserList(userRequestList);
	        	response.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
				response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
	      }
	      catch(Exception e) {
	        logger.error("ERROR: UserManagementImpl:: searchAdminUser method", e);
	        response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
	      	response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
	      }
	      return response;
	    }
	    
	    @Override
	  		public AdminUserResponse findByAdminUserId(Long adminUserId) {
	  			logger.info("Entering :: AdminUserHandlerImpl :: findByAdminUserId method");
	  			AdminUserResponse response = new AdminUserResponse();
	  			List<AdminUserRequest> responseList = new ArrayList<AdminUserRequest>();
	  			try{
	  				AdminUser adminUser = adminUserDao.findByAdminUserId(adminUserId);
	  				if(adminUser == null) {
	  					response.setResponseCode(PhfiErrorCodes.USER_NOT_FOUND);
	  					response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
	  					return response;
	  				}
	  				adminUser.setLastPassWordChange(null);
	  				adminUser.setCreatedDate(null);
	  				adminUser.setUpdatedDate(null);
	  				AdminUserRequest adminUserRequest = CommonUtil.copyBeanProperties(adminUser, AdminUserRequest.class);
	  				responseList.add(adminUserRequest);
	  				response.setAdminUserList(responseList);
	  				response.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
	  				response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
	  			} catch (Exception e) {
	  				logger.error("Error :: AdminUserHandlerImpl :: findByAdminUserId method", e);
	  				response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
	  	      	    response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
	  			}
	  			logger.info("Exiting :: AdminUserHandlerImpl :: findByAdminUserId method");
	  			
	  			return response;
	  		}   
	    
	    @Override
		public Response updateUserProfile(AdminUserRequest adminUserRequest)  throws BeaconServiceException {
		  	  logger.info("Entering:: AdminProfileServiceImpl:: updateUserProfile method: ");
		  	  Response response = new Response();
		      try {
		    	 
	    		 List<AdminUser> adminUsersList = adminUserDao.findByUserEmailId(adminUserRequest.getEmail());
	    	      if(StringUtil.isListNotNullNEmpty(adminUsersList)) {
	    	        Boolean emailExists = Boolean.FALSE;
	    	        for(AdminUser adminUserData : adminUsersList) {
	    	          if(adminUserData.getAdminUserId().compareTo(adminUserRequest.getAdminUserId()) != 0) {
	    	            emailExists = Boolean.TRUE;
	    	            break;
	    	          }
	    	        }
	    	        if(emailExists) {
	    	          response.setResponseCode(PhfiErrorCodes.USER_EMAIL_ALRAEDY_EXIST);
	      	          response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
	    	          logger.error("info:: AdminUserHandlerImpl:: email already exist:: addUpdateAdminUser method: ");
	    	          return response;
	    	        }
	    	      }
	    		  
	    		  AdminUser adminUserFromDB = adminUserDao.findByAdminUserId(adminUserRequest.getAdminUserId());
		    	  adminUserFromDB.setFirstName(adminUserRequest.getFirstName());
		    	  adminUserFromDB.setLastName(adminUserRequest.getLastName());
		    	  adminUserFromDB.setPhone(adminUserRequest.getPhone());
		    	  adminUserFromDB.setEmail(adminUserRequest.getEmail());
		    	  adminUserFromDB.setUpdatedDate(DateUtil.getCurrentTimestamp());
		    	  adminUserFromDB.setSecurityQuestion(adminUserRequest.getSecurityQuestion());
		    	  adminUserFromDB.setSecurityAnswer(EncryptionUtil.encrypt(adminUserRequest.getSecurityAnswer()));
		    	  adminUserDao.saveOrUpdateAdminUser(adminUserFromDB);
		    	  response.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
				  response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
		      } catch(Exception e) {
		    	  logger.error("ERROR: AdminProfileServiceImpl:: updateUserProfile method", e);
		    	  response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
		      	  response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
		      }
		      return response;
		    }

		@Override
		public Response deleteUser(Long userId) throws BeaconServiceException {
			logger.info("Entering :: UserServiceImpl :: deleteUser method");
			Response response = new Response();
			try {
				AdminUser adminUser = adminUserDao.findByAdminUserId(userId);
				if (adminUser == null) {
					throw new BeaconServiceException(PhfiErrorCodes.INVALID_ACCESS, Properties.getProperty(PhfiErrorCodes.INVALID_ACCESS));
				}
				if (!Constant.ACTIVE.equals(adminUser.getStatus())) {
					throw new BeaconServiceException(PhfiErrorCodes.USER_NOT_ACTIVE, Properties.getProperty(PhfiErrorCodes.USER_NOT_ACTIVE));
				}
				adminUser.setStatus(Constant.DELETED);
				adminUser.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
				adminUserDao.saveOrUpdateAdminUser(adminUser);
				response.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
				response.setResponseMessage(Properties.getProperty(response.getResponseCode()));

			} catch (BeaconServiceException e) {
				logger.error("Error :: UserServiceImpl :: deleteUser method", e);
				response.setResponseCode(e.getErrorCode());
				response.setResponseMessage(e.getMessage());
			} catch (Exception e) {
				logger.error("Error :: UserServiceImpl :: deleteUser method", e);
				response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
		      	response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
			}
			logger.info("Exiting :: UserServiceImpl :: deleteUser method");
			return response;
		}
}