package com.smh.rest.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smh.model.LoginRequest;
import com.smh.model.LoginResponse;
import com.smh.model.LoginSessionDetailsRequest;
import com.smh.model.LoginSessionDetailsResponse;
import com.smh.model.Response;


public interface RestLoginService {

	public LoginResponse authenticate(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			LoginRequest loginRequest);

	public LoginSessionDetailsResponse getLoginSessionDetails(
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session,
			LoginSessionDetailsRequest loginSessionDetailsRequest);

	public Response saveLoginSessionDetails(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			LoginSessionDetailsRequest loginSessionDetailsRequest);

	public Response updateLoginSessionDetails(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			LoginSessionDetailsRequest loginSessionDetailsRequest);

}
