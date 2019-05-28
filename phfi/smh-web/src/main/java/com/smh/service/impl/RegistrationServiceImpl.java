/**
 * 
 */
package com.smh.service.impl;

import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import com.smh.exception.SmhAdminException;
import com.smh.model.AllWidResponse;
import com.smh.model.AllWomenResponse;
import com.smh.model.PhfiDeliveryFormRequest;
import com.smh.model.PhfiDoctorFormRequest;
import com.smh.model.PhfiPostPartumVisitRequest;
import com.smh.model.PhfiRegistrationRequest;
import com.smh.model.PhfiRegistrationResponse;
import com.smh.model.PhfiVisitRequest;
import com.smh.model.Response;
import com.smh.service.RegistrationService;
import com.smh.util.JsonUtil;
import com.sun.jersey.api.client.ClientResponse;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 3, 2016 11:25:00 PM
 * @version 1.0
 */
@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService{

	public static Logger logger = Logger.getLogger(RegistrationServiceImpl.class);

	private ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * @param phfiRegistrationRequest
	 * @return
	 * @throws SmhAdminException 
	 */
	@Override
	public Response createRegistration(PhfiRegistrationRequest phfiRegistrationRequest) throws SmhAdminException {
		logger.info("Entering :: RegistrationServiceImpl:: createRegistration method");
		try {
			ClientResponse response = JsonUtil.postRequest(phfiRegistrationRequest, "/registrationService/createRegistration");
			if (response.getStatus() != HttpStatus.SC_OK) {
				logger.error("Error ::RegistrationServiceImpl:: createRegistration method");
				throw new SmhAdminException("Unable to process your request. Please try again");
			} else {
				String output = response.getEntity(String.class);
				Response phfiResponse = mapper.readValue(output,Response.class);
				return phfiResponse;
			}
		} catch (Exception e) {
			logger.error("Error ::RegistrationServiceImpl:: createRegistration method");
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

	/**
	 * @param phfiRegistrationRequest
	 * @return
	 * @throws SmhAdminException 
	 */
	@Override
	public PhfiRegistrationResponse getRegistedWoman(PhfiRegistrationRequest phfiRegistrationRequest) throws SmhAdminException {

		logger.info("Entering :: RegistrationServiceImpl:: getRegistedWoman method");
		try {
			ClientResponse response = JsonUtil.postRequest(phfiRegistrationRequest,"/registrationService/getRegistedWoman");
			if (response.getStatus() != HttpStatus.SC_OK) {
				throw new SmhAdminException("Unable to process your request. Please try again");
			} else {
				String output = response.getEntity(String.class);
				PhfiRegistrationResponse beaconResponse = mapper.readValue(output, PhfiRegistrationResponse.class);
				return beaconResponse;
			}
		} catch (Exception e) {
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

	/**
	 * @param phfiVisitRequest
	 * @return
	 * @throws SmhAdminException 
	 */
	@Override
	public Response createPregnancyVisit(PhfiVisitRequest phfiVisitRequest) throws SmhAdminException {
		logger.info("Entering :: RegistrationServiceImpl:: createRegistration method");

		try {
			ClientResponse response = JsonUtil.postRequest(phfiVisitRequest,"/registrationService/createPregnancyVisit");
			if (response.getStatus() != HttpStatus.SC_OK) {
				logger.error("Error ::RegistrationServiceImpl:: createPregnancyVisit method");
				throw new SmhAdminException("Unable to process your request. Please try again");
			} else {
				String output = response.getEntity(String.class);
				Response phfiResponse = mapper.readValue(output, Response.class);
				return phfiResponse;
			}
		} catch (Exception e) {
			logger.error("Error ::RegistrationServiceImpl:: createPregnancyVisit method");
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

	/**
	 * @param phfiPostPartumVisitRequest
	 * @return
	 * @throws SmhAdminException 
	 */
	@Override
	public Response processPostpartumVisitCreate(PhfiPostPartumVisitRequest phfiPostPartumVisitRequest) throws SmhAdminException {logger.info("Entering :: RegistrationServiceImpl:: createRegistration method");
		logger.info("Entering :: RegistrationServiceImpl:: processPostpartumVisitCreate method");
		try {
			ClientResponse response = JsonUtil.postRequest(phfiPostPartumVisitRequest,"/registrationService/createPostpartumVisit");
			if (response.getStatus() != HttpStatus.SC_OK) {
				logger.error("Error ::RegistrationServiceImpl:: createPregnancyVisit method");
				throw new SmhAdminException("Unable to process your request. Please try again");
			} else {
				String output = response.getEntity(String.class);
				Response phfiResponse = mapper.readValue(output, Response.class);
				return phfiResponse;
			}
		} catch (Exception e) {
			logger.error("Error ::RegistrationServiceImpl:: createPregnancyVisit method");
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

	/**
	 * @param phfiDeliveryFormRequest
	 * @return
	 * @throws SmhAdminException 
	 */
	@Override
	public Response processDeliveryCreate(PhfiDeliveryFormRequest phfiDeliveryFormRequest) throws SmhAdminException {
		logger.info("Entering :: RegistrationServiceImpl:: processPostpartumVisitCreate method");
		try {
			ClientResponse response = JsonUtil.postRequest(phfiDeliveryFormRequest,"/registrationService/processDeliveryCreate");
			if (response.getStatus() != HttpStatus.SC_OK) {
				logger.error("Error ::RegistrationServiceImpl:: createPregnancyVisit method");
				throw new SmhAdminException("Unable to process your request. Please try again");
			} else {
				String output = response.getEntity(String.class);
				Response phfiResponse = mapper.readValue(output, Response.class);
				return phfiResponse;
			}
		} catch (Exception e) {
			logger.error("Error ::RegistrationServiceImpl:: createPregnancyVisit method");
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

	/**
	 * @param phfiDoctorFormRequest
	 * @return
	 * @throws SmhAdminException
	 */
	@Override
	public Response processDoctorCreate(PhfiDoctorFormRequest phfiDoctorFormRequest)throws SmhAdminException {
		logger.info("Entering :: RegistrationServiceImpl:: processDoctorCreate method");
		try {
			ClientResponse response = JsonUtil.postRequest(phfiDoctorFormRequest,"/registrationService/processDoctorCreate");
			if (response.getStatus() != HttpStatus.SC_OK) {
				logger.error("Error ::RegistrationServiceImpl:: processDoctorCreate method");
				throw new SmhAdminException("Unable to process your request. Please try again");
			} else {
				String output = response.getEntity(String.class);
				Response phfiResponse = mapper.readValue(output, Response.class);
				return phfiResponse;
			}
		} catch (Exception e) {
			logger.error("Error ::RegistrationServiceImpl:: processDoctorCreate method");
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

	/**
	 * @return
	 * @throws SmhAdminException
	 */
	@Override
	public AllWidResponse getAllWid() throws SmhAdminException {
		logger.info("Entering :: RegistrationServiceImpl:: processDoctorCreate method");
		try {
			ClientResponse response = JsonUtil.postRequest("/registrationService/allWid");
			if (response.getStatus() != HttpStatus.SC_OK) {
				logger.error("Error ::RegistrationServiceImpl:: processDoctorCreate method");
				throw new SmhAdminException("Unable to process your request. Please try again");
			} else {
				String output = response.getEntity(String.class);
				AllWidResponse phfiResponse = mapper.readValue(output, AllWidResponse.class);
				return phfiResponse;
			}
		} catch (Exception e) {
			logger.error("Error ::RegistrationServiceImpl:: processDoctorCreate method");
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}

	/**
	 * @return
	 * @throws SmhAdminException
	 */
	@Override
	public AllWomenResponse getAllName() throws SmhAdminException {
		logger.info("Entering :: RegistrationServiceImpl:: processDoctorCreate method");
		try {
			ClientResponse response = JsonUtil.postRequest("/registrationService/allWomanName");
			if (response.getStatus() != HttpStatus.SC_OK) {
				logger.error("Error ::RegistrationServiceImpl:: processDoctorCreate method");
				throw new SmhAdminException("Unable to process your request. Please try again");
			} else {
				String output = response.getEntity(String.class);
				AllWomenResponse phfiResponse = mapper.readValue(output, AllWomenResponse.class);
				return phfiResponse;
			}
		} catch (Exception e) {
			logger.error("Error ::RegistrationServiceImpl:: processDoctorCreate method");
			throw new SmhAdminException("Unable to process your request. Please try again");
		}
	}
}
