package com.smh.service;

import com.smh.exception.SmhAdminException;
import com.smh.model.Response;

public interface UtilityService {

	public Response getCountries() throws SmhAdminException;

	public Response getStatesByCountry(String country) throws SmhAdminException;
}
