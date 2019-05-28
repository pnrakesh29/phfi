package com.smh.util;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.smh.exception.SmhAdminException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JsonUtil {

	private static final Logger logger = Logger.getLogger(JsonUtil.class);

	public static String BASE_SERVICE_URL = Properties.getProperty("rest.beacon.service.baseUrl");

	public static ObjectWriter objectWriter = new ObjectMapper().writer();

	/**
	 * Method to convert Java object to JSON
	 * 
	 * @param object
	 * @return
	 * @throws PLMarketPlaceException
	 */
	public static String convertObjectToJSON(Object object) throws SmhAdminException {
		String input = "";
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			input = objectWriter.writeValueAsString(object);
			return input;
		} catch (JsonGenerationException e) {
			throw new SmhAdminException(e.getMessage());
		} catch (JsonMappingException e) {
			throw new SmhAdminException(e.getMessage());
		} catch (IOException e) {
			throw new SmhAdminException(e.getMessage());
		}

	}

	/**
	 * Method to convert JSON data to given class object
	 * 
	 * @param jsonData
	 * @param c
	 * @return
	 * @throws PLMarketPlaceException
	 */
	public static Object convertJSONToObject(String jsonData, Class<?> c) throws SmhAdminException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(jsonData, c);
		} catch (JsonParseException e) {
			throw new SmhAdminException(e.getMessage());
		} catch (JsonMappingException e) {
			throw new SmhAdminException(e.getMessage());
		} catch (IOException e) {
			throw new SmhAdminException(e.getMessage());
		}
	}

	/**
	 * Method to invoke REST service with Payload object
	 * 
	 * @param request
	 * @param serviceEndPoint
	 * @return
	 */
	public static ClientResponse postRequest(Object request, String serviceEndPoint) {
		logger.info("Inside::PostReqeust::Method");
		Client client = Client.create();
		WebResource webResource = client.resource(BASE_SERVICE_URL + serviceEndPoint);
		ObjectWriter objectPrettyWriter = objectWriter.withDefaultPrettyPrinter();
		String input = "";
		ClientResponse response = null;
		try {
			input = objectPrettyWriter.writeValueAsString(request);
			response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);
		} catch (Exception e) {
			logger.error("Error::PostReqeust::Method", e);
		}
		logger.info("Exiting::PostReqeust::Method");
		return response;

	}

	/**
	 * Method to invoke REST service object
	 * 
	 * @param serviceEndPoint
	 * @return
	 */
	public static ClientResponse postRequest(String serviceEndPoint) {
		Client client = Client.create();
		WebResource webResource = client.resource(BASE_SERVICE_URL + serviceEndPoint);

		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class);
		return response;
	}

	public static ClientResponse postRequestLogin(String serviceEndPoint) {
		Client client = Client.create();
		WebResource webResource = client.resource(BASE_SERVICE_URL + serviceEndPoint);
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class);
		return response;
	}
}
