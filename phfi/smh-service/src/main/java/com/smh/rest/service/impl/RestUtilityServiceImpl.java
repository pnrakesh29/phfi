package com.smh.rest.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smh.handler.UtilityHandler;
import com.smh.model.Request;
import com.smh.model.Response;
import com.smh.rest.service.RestUtilityService;

@RestController
@RequestMapping(value = "/utilityService", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestUtilityServiceImpl implements RestUtilityService {

	private static Logger logger = Logger.getLogger(RestUtilityServiceImpl.class);

	@Autowired
	private UtilityHandler utilityService;

	@Override
	@RequestMapping(value = "/getCountries", method = RequestMethod.POST)
	public Response getCountries(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		logger.info("Entering :: RestController :: RestUtilityServiceImpl :: getCountries method");
		Response countryResponse = utilityService.getCountries();
		logger.info("Exiting :: RestController :: RestUtilityServiceImpl :: getCountries method");
		return countryResponse;
	}

	@Override
	@RequestMapping(value = "/getState", method = RequestMethod.POST)
	public Response getStatesByCountry(HttpServletRequest request, HttpServletResponse response, HttpSession session, @RequestBody Request requestName) {
		logger.info("Entering :: RestController :: RestUtilityServiceImpl :: getStatesByCountry method");
		Response stateResponse = utilityService.getStatesByCountry(requestName.getName());
		logger.info("Exiting :: RestController :: RestUtilityServiceImpl :: getStatesByCountry method");
		return stateResponse;
	}
}
