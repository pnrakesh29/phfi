package com.smh.service;

import com.smh.exception.SmhAdminException;
import com.smh.model.AdminForgotPasswordRequest;
import com.smh.model.AdminUserRequest;
import com.smh.model.ChangeAdminPasswordRequest;
import com.smh.model.Response;
import com.smh.model.SecurityQuestionRequest;
import com.smh.model.SecurityQuestionResponse;

public interface AdminUserProfileService {
	
	 public Response forgotPassword(AdminForgotPasswordRequest adminForgotPasswordRequest) throws SmhAdminException;
	 
	 public Response changePassword(ChangeAdminPasswordRequest changePasswordRequest) throws SmhAdminException;
	 
	 public SecurityQuestionResponse getSecurityQuestion(SecurityQuestionRequest securityQuestionRequest) throws SmhAdminException;

	 public Response updateUserProfile(AdminUserRequest adminUserRequest) throws SmhAdminException;
	 
	 public Response findByAdminUserId(Long adminUserId)throws SmhAdminException;
}
