package com.smh.service.impl;

import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import com.smh.exception.SmhAdminException;
import com.smh.model.LoginRequest;
import com.smh.model.LoginResponse;
import com.smh.model.LoginSessionDetailsRequest;
import com.smh.model.LoginSessionDetailsResponse;
import com.smh.model.Response;
import com.smh.service.LoginSevice;
import com.smh.util.JsonUtil;
import com.sun.jersey.api.client.ClientResponse;


@Service("loginSevice")
public class LoginServiceImpl implements LoginSevice {

  private ObjectMapper objectMapper = new ObjectMapper();

  private static Logger logger = Logger.getLogger(LoginServiceImpl.class);

  @Override
  public LoginResponse getUser(LoginRequest loginRequest) throws SmhAdminException {
    logger.info("Entering :: RestInvoction :: LoginServiceImpl:: getUser method");
    try {
      ClientResponse response = JsonUtil.postRequest(loginRequest, "/loginService/authenticate");
      if(response.getStatus() == HttpStatus.SC_OK) {

        String output = response.getEntity(String.class);
        LoginResponse loginResponse = objectMapper.readValue(output, LoginResponse.class);
        logger.info("Exiting :: RestInvoction :: LoginServiceImpl :: getUser method");
        return loginResponse;
      }
    }
    catch(Exception e) {
      logger.error("Error :: RestInvoction :: LoginServiceImpl:: getUser method", e);
      throw new SmhAdminException("Unable to process your request. Please try again");
    }
    logger.info("Exiting :: RestInvoction :: LoginServiceImpl :: getUser method");
    return null;

  }
  
  @Override
  public LoginSessionDetailsResponse getLoginSessionDetails(LoginSessionDetailsRequest loginSessionDetails) throws SmhAdminException {
    logger.info("Entering :: RestInvoction :: LoginServiceImpl:: getLoginSessionDetails method");
    try {
      ClientResponse response = JsonUtil.postRequest(loginSessionDetails, "/loginService/getLoginSessionDetails");
      if(response.getStatus() == HttpStatus.SC_OK) {

        String output = response.getEntity(String.class);
        LoginSessionDetailsResponse loginResponse = objectMapper.readValue(output, LoginSessionDetailsResponse.class);
        logger.info("Exiting :: RestInvoction :: LoginServiceImpl :: getLoginSessionDetails method");
        return loginResponse;
      }
    }
    catch(Exception e) {
      logger.error("Error :: RestInvoction :: LoginServiceImpl:: getLoginSessionDetails method", e);
      throw new SmhAdminException("Unable to process your request. Please try again");
    }
    logger.info("Exiting :: RestInvoction :: LoginServiceImpl :: getLoginSessionDetails method");
    return null;

  }
  
  @Override
  public Response saveLoginSessionDetails(LoginSessionDetailsRequest loginSessionDetails) throws SmhAdminException {
    logger.info("Entering :: RestInvoction :: LoginServiceImpl:: saveLoginSessionDetails method");
    try {
      ClientResponse response = JsonUtil.postRequest(loginSessionDetails, "/loginService/saveLoginSessionDetails");
      if(response.getStatus() == HttpStatus.SC_OK) {

        String output = response.getEntity(String.class);
        Response loginResponse = objectMapper.readValue(output, Response.class);
        logger.info("Exiting :: RestInvoction :: LoginServiceImpl :: saveLoginSessionDetails method");
        return loginResponse;
      }
    }
    catch(Exception e) {
      logger.error("Error :: RestInvoction :: LoginServiceImpl:: saveLoginSessionDetails method", e);
      throw new SmhAdminException("Unable to process your request. Please try again");
    }
    logger.info("Exiting :: RestInvoction :: LoginServiceImpl :: saveLoginSessionDetails method");
    return null;

  }

@Override
public Response updateLoginSessionDetails(LoginSessionDetailsRequest loginSessionDetails) throws SmhAdminException {
	logger.info("Entering :: RestInvoction :: LoginServiceImpl:: saveLoginSessionDetails method");
    try {
      ClientResponse response = JsonUtil.postRequest(loginSessionDetails, "/loginService/updateLoginSessionDetails");
      if(response.getStatus() == HttpStatus.SC_OK) {

        String output = response.getEntity(String.class);
        Response loginResponse = objectMapper.readValue(output, Response.class);
        logger.info("Exiting :: RestInvoction :: LoginServiceImpl :: updateLoginSessionDetails method");
        return loginResponse;
      }
    }
    catch(Exception e) {
      logger.error("Error :: RestInvoction :: LoginServiceImpl:: updateLoginSessionDetails method", e);
      throw new SmhAdminException("Unable to process your request. Please try again");
    }
    logger.info("Exiting :: RestInvoction :: LoginServiceImpl :: updateLoginSessionDetails method");
    return null;
}
  
}
