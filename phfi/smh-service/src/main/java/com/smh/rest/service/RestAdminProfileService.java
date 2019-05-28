package com.smh.rest.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smh.exception.BeaconServiceException;
import com.smh.model.AdminForgotPasswordRequest;
import com.smh.model.AdminUserRequest;
import com.smh.model.AdminUserResponse;
import com.smh.model.ChangeAdminPasswordRequest;
import com.smh.model.Response;
import com.smh.model.SecurityQuestionRequest;
import com.smh.model.SecurityQuestionResponse;


public interface RestAdminProfileService {

	public Response forgotPassword(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			AdminForgotPasswordRequest adminForgotPasswordRequest)
			throws BeaconServiceException;

	public Response changePassword(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			ChangeAdminPasswordRequest changePasswordRequest)
			throws BeaconServiceException;

	public SecurityQuestionResponse getSecurityQuestion(
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session, SecurityQuestionRequest securityQuestionRequest)
			throws BeaconServiceException;

	public Response updateUserProfile(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			AdminUserRequest adminUserRequest) throws BeaconServiceException;

	public AdminUserResponse findByAdminUserId(HttpServletRequest request,
			HttpServletResponse response, HttpSession session, Long adminUserId)
			throws BeaconServiceException;
}
