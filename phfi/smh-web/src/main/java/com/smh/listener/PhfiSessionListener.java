package com.smh.listener;

import java.sql.Timestamp;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.smh.constants.PHFIWebConstant;
import com.smh.model.LoginSessionDetailsRequest;
import com.smh.model.LoginSessionDetailsResponse;
import com.smh.service.LoginSevice;
import com.smh.util.StringUtil;

public class PhfiSessionListener implements HttpSessionListener {

private static Logger logger = Logger.getLogger(PhfiSessionListener.class);
	
	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		logger.info("Entering:: ChatakSessionListener:: sessionDestroyed method");
		HttpSession session = sessionEvent.getSession();
		LoginSessionDetailsRequest loginSessionDetailsRequest = new LoginSessionDetailsRequest();
		loginSessionDetailsRequest.setSessionId(session.getId());
		loginSessionDetailsRequest.setPortalType(PHFIWebConstant.Admin);
		loginSessionDetailsRequest.setLoginStatus(PHFIWebConstant.Yes);
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
		LoginSevice loginSevice = (LoginSevice) ctx.getBean("loginSevice");
		try {
			LoginSessionDetailsResponse  loginSessionDetailsResponse = loginSevice.getLoginSessionDetails(loginSessionDetailsRequest);
			if(loginSessionDetailsResponse != null && StringUtil.isListNotNullNEmpty(loginSessionDetailsResponse.getLoginSessionDetailsRequest())){
				LoginSessionDetailsRequest  loginSessionRequestData  = loginSessionDetailsResponse.getLoginSessionDetailsRequest().get(0);
				loginSessionRequestData.setLogoutTime(new Timestamp(System.currentTimeMillis()));
				loginSessionRequestData.setLastActivityTime(new Timestamp(System.currentTimeMillis()));
				loginSessionRequestData.setLoginStatus(PHFIWebConstant.No);
				loginSevice.updateLoginSessionDetails(loginSessionRequestData);
				logger.info("Info:: ChatakSessionListener:: sessionDestroyed method :: Cleared the LoginSessionDetails for : " + session.getId());
			}
		} catch (Exception e) {
			logger.error("ERROR:: ChatakSessionListener:: sessionDestroyed method",e);
		}
		
		logger.error("info:: ChatakSessionListener:: sessionDestroyed method");
	}
}
