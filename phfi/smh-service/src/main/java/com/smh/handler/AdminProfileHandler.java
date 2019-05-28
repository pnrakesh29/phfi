package com.smh.handler;

import com.smh.exception.BeaconServiceException;
import com.smh.model.AdminForgotPasswordRequest;
import com.smh.model.AdminUserRequest;
import com.smh.model.AdminUserResponse;
import com.smh.model.ChangeAdminPasswordRequest;
import com.smh.model.Response;
import com.smh.model.SecurityQuestionRequest;
import com.smh.model.SecurityQuestionResponse;

public interface AdminProfileHandler {

	public Response forgotPassword(AdminForgotPasswordRequest adminForgotPasswordRequest) throws BeaconServiceException;

	public Response changePassword(ChangeAdminPasswordRequest changePasswordRequest) throws BeaconServiceException;

	public SecurityQuestionResponse getSecurityQuestion(SecurityQuestionRequest securityQuestionRequest) throws BeaconServiceException;

	public Response updateUserProfile(AdminUserRequest adminUserRequest) throws BeaconServiceException;

	public AdminUserResponse findByAdminUserId(Long adminUserId) throws BeaconServiceException;

}
