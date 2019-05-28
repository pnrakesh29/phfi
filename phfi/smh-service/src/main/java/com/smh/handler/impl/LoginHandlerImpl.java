/**
 * 
 */
package com.smh.handler.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.smh.constants.PhfiErrorCodes;
import com.smh.constants.Constant;
import com.smh.dao.AdminUserDao;
import com.smh.dao.BeaconFeatureDao;
import com.smh.dao.LoginSessionDetailsDao;
import com.smh.dao.model.AdminUser;
import com.smh.dao.model.LoginSessionDetails;
import com.smh.enums.UserPasswordStatus;
import com.smh.handler.LoginHandler;
import com.smh.model.LoginRequest;
import com.smh.model.LoginResponse;
import com.smh.model.LoginSessionDetailsRequest;
import com.smh.model.LoginSessionDetailsResponse;
import com.smh.model.Response;
import com.smh.util.CommonUtil;
import com.smh.util.PasswordHandler;
import com.smh.util.Properties;
import com.smh.util.StringUtil;

@Service
public class LoginHandlerImpl implements LoginHandler {

  private static Logger logger = Logger.getLogger(LoginHandlerImpl.class);

  @Autowired
  private AdminUserDao adminUserDao;
  
  @Autowired
  private LoginSessionDetailsDao loginSessionDetailsDao;
  @Autowired
  private BeaconFeatureDao beaconFeatureDao;

  /**
   * Service method to authenticate the user
   * 
   * @param loginDetails
   * @return
   */
  public LoginResponse authenticate(LoginRequest loginRequest) {

    logger.info("Entering ::LoginHandlerImpl :: authenticate method");
    LoginResponse loginResponse = new LoginResponse();
    try {
    	   AdminUser adminUser = adminUserDao.authenticateChatakAdminUser(loginRequest.getSpUser());
    	      if(!StringUtil.isNull(adminUser)) {
    				if(null == adminUser.getPassRetryCount() || adminUser.getPassRetryCount().intValue() < Constant.PASS_RETRY_COUNT) {
    					if(adminUser.getStatus().equals(Constant.ACTIVE)) {
    						if(adminUser != null && PasswordHandler.isValidPassword(loginRequest.getSpPass(), adminUser.getPassword()))  {
    							adminUser.setPassRetryCount(Constant.ZERO);	
    							logger.info("info::LoginHandlerImpl ::before saveOrUpdate:: method  :::: login");
    							adminUserDao.saveOrUpdateAdminUser(adminUser);
    							if(adminUser.getLoginMode() != null) {
    								if(null != adminUser.getLastPassWordChange()){
    									Timestamp lastPasswordChangeDate = adminUser.getLastPassWordChange();
    									Calendar cal = Calendar.getInstance();
    									cal.setTime(lastPasswordChangeDate);
    									cal.add(Calendar.DATE, Constant.PASS_EXPIRE_DAYS);
    									Date expiryDate = cal.getTime();

    									Timestamp currentTime = new Timestamp(System.currentTimeMillis());
    									Calendar currentCal = Calendar.getInstance();
    									currentCal.setTime(currentTime);
    									Date currentdate = currentCal.getTime();

    									// password expired   
    								if(expiryDate.compareTo(currentdate) == Constant.ZERO || expiryDate.compareTo(currentdate) < Constant.ZERO ) {
    									adminUser.setLoginMode(Long.valueOf(UserPasswordStatus.EXPIRED.ordinal()));	
    									logger.info("info::LoginHandlerImpl ::before saveOrUpdate UserPasswordStatus EXPIRED:: method  :::: login");
    									adminUserDao.saveOrUpdateAdminUser(adminUser);
    									loginResponse.setResponseCode(PhfiErrorCodes.PWD_EXPIRED);
    									loginResponse.setResponseMessage(Properties.getProperty(loginResponse.getResponseCode()));
    									loginResponse.setStatus(true);
    									return loginResponse;
    								}
    								}
    								//login mode 0
    								if(adminUser.getLoginMode().toString().equals(Integer.toString(UserPasswordStatus.FIRSTTIMELOGIN.ordinal()))) {
    									loginResponse.setResponseCode(PhfiErrorCodes.RESET_PASSWORD);
    									loginResponse.setResponseMessage(Properties.getProperty(loginResponse.getResponseCode()));
    									loginResponse.setStatus(true);
    									logger.info("info::LoginHandlerImpl ::before login mode 0:: method  :::: login");
    									return loginResponse;
    								}       
    								//login mode 2 
    								if(adminUser.getLoginMode().toString().equals(Integer.toString(UserPasswordStatus.RESETPASWORD.ordinal()))) {
    									loginResponse.setResponseCode(PhfiErrorCodes.USR_REQUESTED_FOR_PWD_CHANGE);
    									loginResponse.setResponseMessage(Properties.getProperty(loginResponse.getResponseCode()));
    									loginResponse.setStatus(true);
    									logger.info("info::LoginHandlerImpl ::before login mode 2:: method  :::: login");
    									return loginResponse;
    								}
    								//login mode 3
    								if(adminUser.getLoginMode().toString().equals(Integer.toString(UserPasswordStatus.RESETPASWORD.ordinal()))) {
    									loginResponse.setResponseCode(PhfiErrorCodes.PWD_EXPIRED);
    									loginResponse.setResponseMessage(Properties.getProperty(loginResponse.getResponseCode()));
    									loginResponse.setStatus(true);
    									logger.info("info::LoginHandlerImpl ::before login mode 3:: method  :::: login");
    									return loginResponse;
    								}
    								//login mode > 3
    								if((adminUser.getLoginMode()>Long.valueOf(UserPasswordStatus.EXPIRED.ordinal()))) {
    									loginResponse.setResponseCode(PhfiErrorCodes.USER_NOT_ACTIVE);
    									loginResponse.setResponseMessage(Properties.getProperty(loginResponse.getResponseCode()));
    									loginResponse.setStatus(false);
    									logger.info("info::LoginHandlerImpl ::before login mode >3:: method  :::: login");
    									return loginResponse;
    								}
    							}
    							if((adminUser.getStatus().equals(Constant.ACTIVE))){
    								loginResponse.setUserName(adminUser.getUserName());
    								loginResponse.setEmail(adminUser.getEmail());
    								loginResponse.setFirstName(adminUser.getFirstName());
    								loginResponse.setLastName(adminUser.getLastName());
    								loginResponse.setLoginMode(adminUser.getLoginMode());
    								loginResponse.setUserId(adminUser.getAdminUserId());
    								loginResponse.setUserType(adminUser.getUserType());
    								loginResponse.setExistingFeature(beaconFeatureDao.getFeatureDataOnRoleIdData(adminUser.getUserRoleId()));
    								loginResponse.setStatus(true);
    								loginResponse.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
    								loginResponse.setResponseMessage(Properties.getProperty(loginResponse.getResponseCode()));
    							} else {
    								loginResponse.setStatus(false);
    								loginResponse.setResponseCode(PhfiErrorCodes.USER_NOT_ACTIVE);
									loginResponse.setResponseMessage(Properties.getProperty(loginResponse.getResponseCode()));
    							}
    						} else {
    							int count;
    							if(adminUser.getPassRetryCount() != null){
    								count = adminUser.getPassRetryCount().intValue();
    							} else{
    								count=0;
    							}
    							if(count!=Constant.PASS_RETRY_COUNT){
    								int passsCount = adminUser.getPassRetryCount();
    								adminUser.setPassRetryCount(passsCount+1);
    								logger.info("info::LoginHandlerImpl ::before saveOrUpdate:: method  :::: login");
    								adminUserDao.saveOrUpdateAdminUser(adminUser);
    								loginResponse.setStatus(false);
    								loginResponse.setResponseCode(PhfiErrorCodes.UN_PWD_INCORRECT);
    								loginResponse.setResponseMessage(Properties.getProperty(loginResponse.getResponseCode()));
    								if(count+1 == Constant.PASS_RETRY_COUNT) {
    									adminUser.setPassRetryCount(0);
    									adminUser.setStatus(Constant.SUSPEND);
    									adminUserDao.saveOrUpdateAdminUser(adminUser);
    									loginResponse.setResponseCode(PhfiErrorCodes.ACCOUNT_BLOCKED);
    									loginResponse.setResponseMessage(Properties.getProperty(loginResponse.getResponseCode()));
    								}

    							}
    						}
    					} else {
    						loginResponse.setStatus(false);
    						 loginResponse.setResponseCode(PhfiErrorCodes.ACCOUNT_SUSPENDED);
    						 loginResponse.setResponseMessage(Properties.getProperty(loginResponse.getResponseCode()));
    					}
    				} else {
    					loginResponse.setStatus(false);
    					loginResponse.setResponseCode(PhfiErrorCodes.ACCOUNT_BLOCKED);
						loginResponse.setResponseMessage(Properties.getProperty(loginResponse.getResponseCode()));
    				}

    			} else  {    
    				if(loginRequest.getSpUser() != null)
    				  loginResponse.setStatus(false);
    				  loginResponse.setResponseCode(PhfiErrorCodes.UN_PWD_INCORRECT);
					  loginResponse.setResponseMessage(Properties.getProperty(loginResponse.getResponseCode()));

    			}
    	    }
    	    catch(DataAccessException e) {
    	      logger.error("Error :: LoginHandlerImpl :: authenticate method", e);
    	      loginResponse.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
    	      loginResponse.setResponseMessage(Properties.getProperty(loginResponse.getResponseCode()));
    	    }
    	    catch(Exception e) {
    	      logger.error("Error :: LoginHandlerImpl :: authenticate method", e);
    	      loginResponse.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
    	      loginResponse.setResponseMessage(Properties.getProperty(loginResponse.getResponseCode()));
    	    }
    	    logger.info("Exiting :: LoginHandlerImpl :: authenticate method");
    	    return loginResponse;
    	  }
  
  @Override
	public Response  saveLoginSessionDetails(LoginSessionDetailsRequest loginSessionDetailsRequest)  {
		logger.info("prepaidservice :: LoginHandlerImpl :: saveSessionDetails Entering");
		Response response = new Response();
		try {
			LoginSessionDetails sessionDetails = CommonUtil.copyBeanProperties(loginSessionDetailsRequest, LoginSessionDetails.class);
			loginSessionDetailsDao.saveOrUpdateSessionDetails(sessionDetails);
			response.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
			response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
		} catch (Exception e) {
			logger.error("Error :: LoginHandlerImpl :: saveSessionDetails method", e);
			response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
  	        response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
		}
		logger.info("Exiting :: LoginHandlerImpl :: saveSessionDetails method");
		return response;
	}
	
	    @Override
		public LoginSessionDetailsResponse getSessionDetailsById(LoginSessionDetailsRequest loginSessionDetailsRequest) {
			logger.info("prepaidservice :: LoginHandlerImpl :: getSessionDetailsById Entering");
			LoginSessionDetailsResponse sessionDetailsResponse = new LoginSessionDetailsResponse();
			try {
				List<LoginSessionDetailsRequest> loginSessionDetails = loginSessionDetailsDao.searchLoginSessionDetails(loginSessionDetailsRequest);
				if (CommonUtil.isListNotNullAndEmpty(loginSessionDetails)) {
					sessionDetailsResponse.setLoginSessionDetailsRequest(loginSessionDetails);
				}
				sessionDetailsResponse.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
				sessionDetailsResponse.setResponseMessage(Properties.getProperty(sessionDetailsResponse.getResponseCode()));
				return sessionDetailsResponse;
			} catch (Exception e) {
				logger.error("Error :: LoginHandlerImpl :: getSessionDetailsById method", e);
				sessionDetailsResponse.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
				sessionDetailsResponse.setResponseMessage(Properties.getProperty(sessionDetailsResponse.getResponseCode()));
			}
			logger.info("Exiting :: LoginHandlerImpl :: getSessionDetailsById method");
			return sessionDetailsResponse;
		}
	    
	    @Override
		public Response  updateLoginSessionDetails(LoginSessionDetailsRequest loginSessionDetailsRequest) {
			logger.info("prepaidservice :: LoginHandlerImpl :: updateLoginSessionDetails Entering");
			Response response = new Response();
			try {
				LoginSessionDetails sessionDetails = CommonUtil.copyBeanProperties(loginSessionDetailsRequest, LoginSessionDetails.class);
				if(sessionDetails.getId() != null){
					logger.info("LoginHandlerImpl :: Before saveOrUpdateSessionDetails");
					loginSessionDetailsDao.saveOrUpdateSessionDetails(sessionDetails);
				}
				response.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
				response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
			} catch (Exception e) {
				logger.error("Error :: LoginHandlerImpl :: updateLoginSessionDetails method", e);
				response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
				response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
			}
			logger.info("Exiting :: LoginHandlerImpl :: updateLoginSessionDetails method");
			return response;
	    }

}