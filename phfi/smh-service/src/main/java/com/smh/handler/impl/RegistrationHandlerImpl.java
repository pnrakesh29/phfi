/**
 * 
 */
package com.smh.handler.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smh.constants.PhfiErrorCodes;
import com.smh.constants.Constant;
import com.smh.dao.RegistrationDao;
import com.smh.dao.model.Delivery;
import com.smh.dao.model.Doctor;
import com.smh.dao.model.PostpartumVisit;
import com.smh.dao.model.PregnancyVisit;
import com.smh.dao.model.Registration;
import com.smh.handler.RegistrationHandler;
import com.smh.model.AllWidResponse;
import com.smh.model.AllWomenResponse;
import com.smh.model.PhfiDeliveryFormRequest;
import com.smh.model.PhfiDeliveryFormResponse;
import com.smh.model.PhfiDoctorFormRequest;
import com.smh.model.PhfiPostPartumVisitRequest;
import com.smh.model.PhfiPostPartumVisitResponse;
import com.smh.model.PhfiRegistrationRequest;
import com.smh.model.PhfiRegistrationResponse;
import com.smh.model.PhfiVisitRequest;
import com.smh.model.PhfiVisitResponse;
import com.smh.model.Response;
import com.smh.util.CommonUtil;
import com.smh.util.DateUtil;
import com.smh.util.Properties;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 3, 2016 11:52:47 PM
 * @version 1.0
 */
@Service("registrationHandler")
public class RegistrationHandlerImpl implements RegistrationHandler{

	private static Logger logger = Logger.getLogger(RegistrationHandlerImpl.class);
	
	@Autowired
	private RegistrationDao registrationDao;
	
	/**
	 * @param phfiRegistrationRequest
	 * @return
	 */
	@Override
	public Response createRegistration(PhfiRegistrationRequest phfiRegistrationRequest) {
		logger.info("Entering :: RegistrationHandlerImpl :: createRegistration method");
	Response response = new Response();
	try {
		Registration registration = registrationDao.findByUid(phfiRegistrationRequest.getUid());
		if(registration != null){
			response.setResponseCode(PhfiErrorCodes.ALREADY_EXIST);
			response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
			return response;
		}
		
		Registration registrationData = CommonUtil.copyBeanProperties(phfiRegistrationRequest, Registration.class);
		registrationData.setCreatedBy(Constant.CREATED_BY);
		registrationData.setCreatedDate(DateUtil.getCurrentTimestamp().toString());
		registrationData.setUpdatedBy(Constant.CREATED_BY);
		registrationData.setUpdatedDate(DateUtil.getCurrentTimestamp().toString());
		registrationDao.createRegistration(registrationData);
		response.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
		response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
	} catch (Exception e) {
		logger.error("Error :: RegistrationHandlerImpl :: createRegistration method", e);
		response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
		response.setResponseMessage(Properties.getProperty(PhfiErrorCodes.SYSTEM_ERROR));
	}
	logger.info("Exiting :: RegistrationHandlerImpl :: createRegistration method");

	return response;
	}

	/**
	 * @param phfiRegistrationRequest
	 * @return
	 */
	@Override
	public PhfiRegistrationResponse getRegistredWoman(PhfiRegistrationRequest phfiRegistrationRequest) {
		logger.info("Entering :: BeaconHandlerImpl :: searchBeaconProfiles method");
		PhfiRegistrationResponse response = new PhfiRegistrationResponse();

		try {
			List<PhfiRegistrationRequest> phfiRegistrationList = registrationDao.getRegistredWoman(phfiRegistrationRequest);
			response.setPhfiRegistrationRequest(phfiRegistrationList);
			response.setNoOfRecords(phfiRegistrationRequest.getNoOfRecords());
			response.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
			response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
		} catch (Exception e) {
			response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
			response.setResponseMessage(Properties.getProperty(PhfiErrorCodes.SYSTEM_ERROR));
		}
		logger.info("Exiting :: BeaconHandlerImpl :: searchBeaconProfiles method");

		return response;
	}

	/**
	 * @param phfiVisitRequest
	 * @return
	 */
	@Override
	public PhfiVisitResponse createPregnancyVisit(PhfiVisitRequest phfiVisitRequest) {
		logger.info("Entering :: RegistrationHandlerImpl :: createPregnancyVisit method");
		PhfiVisitResponse response = new PhfiVisitResponse();
		try {
			/*PregnancyVisit registration = registrationDao.findByWid(phfiVisitRequest.getWid());
			if(registration != null){
				response.setResponseCode(PhfiErrorCodes.ALREADY_EXIST);
				response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
				return response;
			}*/
			
			PregnancyVisit pregnancyVisitData = CommonUtil.copyBeanProperties(phfiVisitRequest, PregnancyVisit.class);
			pregnancyVisitData.setCreatedBy(Constant.CREATED_BY);
			pregnancyVisitData.setCreatedDate(DateUtil.getCurrentTimestamp().toString());
			pregnancyVisitData.setUpdatedBy(Constant.CREATED_BY);
			pregnancyVisitData.setUpdatedDate(DateUtil.getCurrentTimestamp().toString());
			registrationDao.createPregnancyVisit(pregnancyVisitData);
			response.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
			response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
		} catch (Exception e) {
			logger.error("Error :: RegistrationHandlerImpl :: createRegistration method", e);
			response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
			response.setResponseMessage(Properties.getProperty(PhfiErrorCodes.SYSTEM_ERROR));
		}
		logger.info("Exiting :: RegistrationHandlerImpl :: createRegistration method");

		return response;
	}

	/**
	 * @param phfiPostPartumVisitRequest
	 * @return
	 */
	@Override
	public PhfiPostPartumVisitResponse createPostpartumVisit(PhfiPostPartumVisitRequest phfiPostPartumVisitRequest) {
		logger.info("Entering :: RegistrationHandlerImpl :: createPostpartumVisit method");
		PhfiPostPartumVisitResponse response = new PhfiPostPartumVisitResponse();
		try {
				PostpartumVisit postpartumVisitData = CommonUtil.copyBeanProperties(phfiPostPartumVisitRequest, PostpartumVisit.class);
				postpartumVisitData.setCreatedBy(Constant.CREATED_BY);
				postpartumVisitData.setCreatedDate(DateUtil.getCurrentTimestamp().toString());
				postpartumVisitData.setUpdatedBy(Constant.CREATED_BY);
				postpartumVisitData.setUpdatedDate(DateUtil.getCurrentTimestamp().toString());
				registrationDao.createPostpartumVisit(postpartumVisitData);
				response.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
				response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
			} catch (Exception e) {
				logger.error("Error :: RegistrationHandlerImpl :: createRegistration method", e);
				response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
				response.setResponseMessage(Properties.getProperty(PhfiErrorCodes.SYSTEM_ERROR));
			}
			logger.info("Exiting :: RegistrationHandlerImpl :: createRegistration method");

			return response;
	}

	/**
	 * @param phfiDeliveryFormRequest
	 * @return
	 */
	@Override
	public PhfiDeliveryFormResponse createDelivery(PhfiDeliveryFormRequest phfiDeliveryFormRequest) {
		logger.info("Entering :: RegistrationHandlerImpl :: createDelivery method");
		PhfiDeliveryFormResponse response = new PhfiDeliveryFormResponse();
		try {
				Delivery deliveryData = CommonUtil.copyBeanProperties(phfiDeliveryFormRequest, Delivery.class);
				registrationDao.createDelivery(deliveryData);
				response.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
				response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
			} catch (Exception e) {
				logger.error("Error :: RegistrationHandlerImpl :: createDelivery method", e);
				response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
				response.setResponseMessage(Properties.getProperty(PhfiErrorCodes.SYSTEM_ERROR));
			}
			logger.info("Exiting :: RegistrationHandlerImpl :: createDelivery method");

			return response;
	}

	/**
	 * @param phfiDoctorFormRequest
	 * @return
	 */
	@Override
	public Response createDoctorCreate(PhfiDoctorFormRequest phfiDoctorFormRequest) {
		logger.info("Entering :: RegistrationHandlerImpl :: createDoctorCreate method");
		Response response = new Response();
		try {
				Doctor doctorData = CommonUtil.copyBeanProperties(phfiDoctorFormRequest, Doctor.class);
				registrationDao.createDoctorCreate(doctorData);
				response.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
				response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
			} catch (Exception e) {
				logger.error("Error :: RegistrationHandlerImpl :: createDoctorCreate method", e);
				response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
				response.setResponseMessage(Properties.getProperty(PhfiErrorCodes.SYSTEM_ERROR));
			}
			logger.info("Exiting :: RegistrationHandlerImpl :: createDoctorCreate method");

			return response;
	}

	/**
	 * @return
	 */
	@Override
	public Response getAllWid() {
		logger.info("Entering :: RegistrationHandlerImpl :: createDoctorCreate method");
		AllWidResponse response = new AllWidResponse();
		try {
				List<Integer> widList = registrationDao.getAllWid();
				response.setWid(widList);
				response.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
				response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
			} catch (Exception e) {
				logger.error("Error :: RegistrationHandlerImpl :: createDoctorCreate method", e);
				response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
				response.setResponseMessage(Properties.getProperty(PhfiErrorCodes.SYSTEM_ERROR));
			}
			logger.info("Exiting :: RegistrationHandlerImpl :: createDoctorCreate method");

			return response;
	}

	/**
	 * @return
	 */
	@Override
	public Response getAllWomanName() {
		logger.info("Entering :: RegistrationHandlerImpl :: getAllWomanName method");
		AllWomenResponse response = new AllWomenResponse();
		try {
				List<String> nameList = registrationDao.getAllWomanName();
				response.setWomanName(nameList);
				response.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
				response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
			} catch (Exception e) {
				logger.error("Error :: RegistrationHandlerImpl :: getAllWomanName method", e);
				response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
				response.setResponseMessage(Properties.getProperty(PhfiErrorCodes.SYSTEM_ERROR));
			}
			logger.info("Exiting :: RegistrationHandlerImpl :: getAllWomanName method");

			return response;
	}

}
