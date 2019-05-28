package com.smh.service.impl;

import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import com.smh.exception.SmhAdminException;
import com.smh.model.AdminForgotPasswordRequest;
import com.smh.model.AdminUserRequest;
import com.smh.model.AdminUserResponse;
import com.smh.model.ChangeAdminPasswordRequest;
import com.smh.model.Response;
import com.smh.model.SecurityQuestionRequest;
import com.smh.model.SecurityQuestionResponse;
import com.smh.service.AdminUserProfileService;
import com.smh.util.JsonUtil;
import com.sun.jersey.api.client.ClientResponse;

@Service("adminUserProfileService")
public class AdminProfileServiceImpl implements AdminUserProfileService {

	public static Logger logger = Logger.getLogger(AdminProfileServiceImpl.class);

	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public Response forgotPassword(AdminForgotPasswordRequest adminForgotPasswordRequest) throws SmhAdminException {
		try {
			ClientResponse response = JsonUtil.postRequest(adminForgotPasswordRequest, "/adminProfileService/forgotPassword");
			if (response.getStatus() != HttpStatus.SC_OK) {
				throw new SmhAdminException("Unable to process your request. Please try again");
			} else {
				String output = response.getEntity(String.class);
				Response tokenresponse = mapper.readValue(output, Response.class);
				return tokenresponse;
			}
		} catch (Exception e) {
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

	@Override
	public Response changePassword(ChangeAdminPasswordRequest changePasswordRequest)
			throws SmhAdminException {
		try {
			ClientResponse response = JsonUtil.postRequest(changePasswordRequest, "/adminProfileService/changePassword");
			if (response.getStatus() != HttpStatus.SC_OK) {
				throw new SmhAdminException("Unable to process your request. Please try again");
			} else {
				String output = response.getEntity(String.class);
				Response tokenresponse = mapper.readValue(output, Response.class);
				return tokenresponse;
			}
		} catch (Exception e) {
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

	@Override
	public SecurityQuestionResponse getSecurityQuestion(SecurityQuestionRequest securityQuestionRequest)
			throws SmhAdminException {
		try {
			ClientResponse response = JsonUtil.postRequest(securityQuestionRequest, "/adminProfileService/getSecurityQuestion");
			if (response.getStatus() != HttpStatus.SC_OK) {
				throw new SmhAdminException("Unable to process your request. Please try again");
			} else {
				String output = response.getEntity(String.class);
				SecurityQuestionResponse securityQuestionResponse = mapper.readValue(output, SecurityQuestionResponse.class);
				return securityQuestionResponse;
			}
		} catch (Exception e) {
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

	@Override
	public Response updateUserProfile(AdminUserRequest adminUserRequest) throws SmhAdminException {
		try {
			ClientResponse response = JsonUtil.postRequest(adminUserRequest, "/adminProfileService/updateUserProfile");
			if (response.getStatus() != HttpStatus.SC_OK) {
				throw new SmhAdminException("Unable to process your request. Please try again");
			} else {
				String output = response.getEntity(String.class);
				Response profileResponse = mapper.readValue(output, Response.class);
				return profileResponse;
			}
		} catch (Exception e) {
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

	@Override
	public Response findByAdminUserId(Long adminUserId) throws SmhAdminException {
		try {
			ClientResponse response = JsonUtil.postRequest(adminUserId, "/adminProfileService/findByAdminUserId");
			if (response.getStatus() != HttpStatus.SC_OK) {
				throw new SmhAdminException("Unable to process your request. Please try again");
			} else {
				String output = response.getEntity(String.class);
				AdminUserResponse adminUserResponse = mapper.readValue(output, AdminUserResponse.class);
				return adminUserResponse;
			}
		} catch (Exception e) {
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}
}