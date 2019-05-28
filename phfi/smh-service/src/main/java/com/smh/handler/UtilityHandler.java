package com.smh.handler;

import com.smh.model.Response;

public interface UtilityHandler {

	public Response getStatesByCountry(String name);

	public Response getCountries();
}
