package com.smh.service.impl;

import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import com.smh.exception.SmhAdminException;
import com.smh.model.AdminUserRequest;
import com.smh.model.AdminUserResponse;
import com.smh.model.Response;
import com.smh.service.UserService;
import com.smh.util.JsonUtil;
import com.sun.jersey.api.client.ClientResponse;

@Service("userService")
public class UserServiceImpl implements UserService {

	public static Logger logger = Logger.getLogger(UserServiceImpl.class);

	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public Response updateUserProfile(AdminUserRequest adminUserRequest) throws SmhAdminException {
		try {
			ClientResponse response = JsonUtil.postRequest(adminUserRequest, "/userService/updateUserProfile");
			if (response.getStatus() != HttpStatus.SC_OK) {
				throw new SmhAdminException("Unable to process your request. Please try again");
			} else {
				String output = response.getEntity(String.class);
				Response adminUserProfileResponse = mapper.readValue(output, Response.class);
				return adminUserProfileResponse;
			}
		} catch (Exception e) {
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

	@Override
	public AdminUserResponse findByAdminUserId(Long adminUserId) throws SmhAdminException {
		try {
			ClientResponse response = JsonUtil.postRequest(adminUserId, "/userService/findByAdminUserId");
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

	@Override
	public Response createOrUpdateUser(AdminUserRequest adminUserRequest)
			throws SmhAdminException {
		try {
			ClientResponse response = JsonUtil.postRequest(adminUserRequest, "/userService/createOrUpdateUser");
			if (response.getStatus() != HttpStatus.SC_OK) {
				throw new SmhAdminException("Unable to process your request. Please try again");
			} else {
				String output = response.getEntity(String.class);
				Response adminUserResponse = mapper.readValue(output, Response.class);
				return adminUserResponse;
			}
		} catch (Exception e) {
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

	@Override
	public AdminUserResponse searchAdminUser(AdminUserRequest userRequestTemp)
			throws SmhAdminException {
		try {
			ClientResponse response = JsonUtil.postRequest(userRequestTemp, "/userService/searchAdminUser");
			if (response.getStatus() != HttpStatus.SC_OK) {
				throw new SmhAdminException("Unable to process your request. Please try again");
			} else {
				String output = response.getEntity(String.class);
				AdminUserResponse aminUserResponse = mapper.readValue(output, AdminUserResponse.class);
				return aminUserResponse;
			}
		} catch (Exception e) {
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

	@Override
	public Response deleteUser(Long userId) throws SmhAdminException {
		try {
			ClientResponse response = JsonUtil.postRequest(userId, "/userService/deleteUser");
			if (response.getStatus() != HttpStatus.SC_OK) {
				throw new SmhAdminException("Unable to process your request. Please try again");
			} else {
				String output = response.getEntity(String.class);
				Response adminUserResponse = mapper.readValue(output, Response.class);
				return adminUserResponse;
			}
		} catch (Exception e) {
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}
}