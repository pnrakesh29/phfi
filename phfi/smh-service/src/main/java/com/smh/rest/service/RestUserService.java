package com.smh.rest.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smh.exception.BeaconServiceException;
import com.smh.model.AdminUserRequest;
import com.smh.model.AdminUserResponse;
import com.smh.model.Response;

public interface RestUserService {
	
	 public Response createOrUpdateUser(HttpServletRequest request,
				HttpServletResponse response, HttpSession session,AdminUserRequest adminUserRequest) throws BeaconServiceException; 
	
	 public AdminUserResponse searchAdminUser(HttpServletRequest request,
				HttpServletResponse response, HttpSession session,AdminUserRequest userRequestTemp) throws BeaconServiceException;
	 
	 public Response deleteUser(HttpServletRequest request,
				HttpServletResponse response, HttpSession session,Long userId) throws BeaconServiceException;
	 
	 public Response updateUserProfile(HttpServletRequest request,
				HttpServletResponse response, HttpSession session,AdminUserRequest adminUserRequest) throws BeaconServiceException;
	 
	 public AdminUserResponse findByAdminUserId(HttpServletRequest request,
				HttpServletResponse response, HttpSession session,Long adminUserId)throws BeaconServiceException;
}
