package com.smh.service;

import com.smh.exception.SmhAdminException;
import com.smh.model.LoginRequest;
import com.smh.model.LoginResponse;
import com.smh.model.LoginSessionDetailsRequest;
import com.smh.model.LoginSessionDetailsResponse;
import com.smh.model.Response;

public interface LoginSevice {

	public LoginResponse getUser(LoginRequest loginRequest) throws SmhAdminException;

	public LoginSessionDetailsResponse getLoginSessionDetails(LoginSessionDetailsRequest loginSessionDetails) throws SmhAdminException;

	public Response saveLoginSessionDetails(LoginSessionDetailsRequest loginSessionDetails) throws SmhAdminException;

	public Response updateLoginSessionDetails(LoginSessionDetailsRequest loginSessionDetails) throws SmhAdminException;
	 
}
