package com.smh.service.impl;

import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import com.smh.exception.SmhAdminException;
import com.smh.model.Request;
import com.smh.model.Response;
import com.smh.service.UtilityService;
import com.smh.util.JsonUtil;
import com.sun.jersey.api.client.ClientResponse;

@Service("utilityService")
public class UtilityServiceImpl implements UtilityService {

	public static Logger logger = Logger.getLogger(UtilityServiceImpl.class);

	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public Response getStatesByCountry(String country) throws SmhAdminException {
		logger.info("Entering :: UtilityServiceImpl :: getStatesByCountry method");
		try {
			Request request = new Request();
			request.setName(country);
			ClientResponse response = JsonUtil.postRequest(request, "/utilityService/getState");
			if (response.getStatus() != HttpStatus.SC_OK) {
				logger.error("Error :: UtilityServiceImpl :: getStatesByCountry method " + response.getStatus());
				throw new SmhAdminException("Unable to process your request. Please try again");
			}
			String output = response.getEntity(String.class);
			Response response2 = mapper.readValue(output, Response.class);
			logger.info("Exiting :: UtilityServiceImpl :: getStatesByCountry method");
			return response2;
		} catch (Exception e) {
			logger.error("Error :: UtilityServiceImpl :: getStatesByCountry method", e);
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

	@Override
	public Response getCountries() throws SmhAdminException {
		logger.info("Entering :: UtilityServiceImpl :: getCountries method");
		try {
			ClientResponse response = JsonUtil.postRequest("/utilityService/getCountries");
			if (response.getStatus() != HttpStatus.SC_OK) {
				logger.error("Error :: UtilityServiceImpl :: getCountries method " + response.getStatus());
				throw new SmhAdminException("Unable to process your request. Please try again");
			}
			String output = response.getEntity(String.class);
			Response countryResponse = mapper.readValue(output, Response.class);
			logger.info("Exiting :: UtilityServiceImpl :: getCountries method");
			return countryResponse;
		} catch (Exception e) {
			logger.error("Error :: UtilityServiceImpl :: getCountries method", e);
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

}
