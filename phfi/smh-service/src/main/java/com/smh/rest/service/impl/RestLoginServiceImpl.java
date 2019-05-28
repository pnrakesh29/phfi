package com.smh.rest.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smh.handler.LoginHandler;
import com.smh.model.LoginRequest;
import com.smh.model.LoginResponse;
import com.smh.model.LoginSessionDetailsRequest;
import com.smh.model.LoginSessionDetailsResponse;
import com.smh.model.Response;
import com.smh.rest.service.RestLoginService;

@RestController
@RequestMapping(value = "/loginService", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestLoginServiceImpl implements RestLoginService {

	private static Logger logger = Logger.getLogger(RestLoginServiceImpl.class);

	@Autowired
	private LoginHandler loginHandler;

	@Override
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public LoginResponse authenticate(HttpServletRequest request, HttpServletResponse response, HttpSession session, @RequestBody LoginRequest loginRequest) {
		logger.info("Entering :: RestController :: RestLoginServiceImpl :: authenticate method");
		LoginResponse loginResponse = null;
		loginResponse = loginHandler.authenticate(loginRequest);
		logger.info("Exiting :: RestController :: RestLoginServiceImpl :: authenticate method");
		return loginResponse;
	}
  
	@Override
	@RequestMapping(value = "/getLoginSessionDetails", method = RequestMethod.POST)
	public LoginSessionDetailsResponse getLoginSessionDetails(HttpServletRequest request, HttpServletResponse response, HttpSession session, @RequestBody LoginSessionDetailsRequest loginSessionDetailsRequest) {
		logger.info("Entering :: RestController :: RestLoginServiceImpl :: getLoginSessionDetails method");
		LoginSessionDetailsResponse loginSessionDetailsResponse = null;
		loginSessionDetailsResponse = loginHandler.getSessionDetailsById(loginSessionDetailsRequest);
		logger.info("Exiting :: RestController :: RestLoginServiceImpl :: getLoginSessionDetails method");
		return loginSessionDetailsResponse;
	}
  
	@Override
	@RequestMapping(value = "/saveLoginSessionDetails", method = RequestMethod.POST)
	public Response saveLoginSessionDetails(HttpServletRequest request, HttpServletResponse response, HttpSession session, @RequestBody LoginSessionDetailsRequest loginSessionDetailsRequest) {
		logger.info("Entering :: RestController :: RestLoginServiceImpl :: saveLoginSessionDetails method");
		Response loginSessionDetailsResponse = null;
		loginSessionDetailsResponse = loginHandler.saveLoginSessionDetails(loginSessionDetailsRequest);
		logger.info("Exiting :: RestController :: RestLoginServiceImpl :: saveLoginSessionDetails method");
		return loginSessionDetailsResponse;
	}

	@Override
	@RequestMapping(value = "/updateLoginSessionDetails", method = RequestMethod.POST)
	public Response updateLoginSessionDetails(HttpServletRequest request, HttpServletResponse response, HttpSession session, @RequestBody LoginSessionDetailsRequest loginSessionDetailsRequest) {
		logger.info("Entering :: RestController :: RestLoginServiceImpl :: updateLoginSessionDetails method");
		Response loginSessionDetailsResponse = loginHandler.updateLoginSessionDetails(loginSessionDetailsRequest);
		logger.info("Exiting :: RestController :: RestLoginServiceImpl :: updateLoginSessionDetails method");
		return loginSessionDetailsResponse;
	}

}
