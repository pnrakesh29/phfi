package com.smh.rest.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smh.model.Request;
import com.smh.model.Response;

public interface RestUtilityService {

	public Response getStatesByCountry(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			Request requestName);

	public Response getCountries(HttpServletRequest request,
			HttpServletResponse response, HttpSession session);
}
