/**
 * 
 */
package com.smh.handler;

import com.smh.model.LoginRequest;
import com.smh.model.LoginResponse;
import com.smh.model.LoginSessionDetailsRequest;
import com.smh.model.LoginSessionDetailsResponse;
import com.smh.model.Response;

public interface LoginHandler {

	public LoginResponse authenticate(LoginRequest loginDetails);

	public Response saveLoginSessionDetails(LoginSessionDetailsRequest loginSessionDetails);

	public LoginSessionDetailsResponse getSessionDetailsById(LoginSessionDetailsRequest addLoginSessionDetails);

	public Response updateLoginSessionDetails(LoginSessionDetailsRequest loginSessionDetailsRequest);

}
