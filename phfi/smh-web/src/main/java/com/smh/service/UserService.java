package com.smh.service;

import com.smh.exception.SmhAdminException;
import com.smh.model.AdminUserRequest;
import com.smh.model.AdminUserResponse;
import com.smh.model.Response;

public interface UserService {
	
	 public Response createOrUpdateUser(AdminUserRequest adminUserRequest) throws SmhAdminException; 
	
	 public AdminUserResponse searchAdminUser(AdminUserRequest userRequestTemp) throws SmhAdminException;
	 
	 public Response deleteUser(Long userId) throws SmhAdminException;
	 
	 public Response updateUserProfile(AdminUserRequest adminUserRequest) throws SmhAdminException;
	 
	 public AdminUserResponse findByAdminUserId(Long adminUserId)throws SmhAdminException;
}
