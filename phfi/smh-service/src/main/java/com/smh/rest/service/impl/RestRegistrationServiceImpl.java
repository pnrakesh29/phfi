/**
 * 
 */
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

import com.smh.handler.RegistrationHandler;
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
import com.smh.rest.service.RestRegistrationService;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 3, 2016 11:48:20 PM
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/registrationService", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestRegistrationServiceImpl implements RestRegistrationService{
	public static Logger logger = Logger.getLogger(RestRegistrationServiceImpl.class);
	
	@Autowired
	private RegistrationHandler registrationHandler;
	/**
	 * @param request
	 * @param response
	 * @param session
	 * @param phfiRegistrationRequest
	 * @return
	 */
	@Override
	@RequestMapping(value = "/createRegistration", method = RequestMethod.POST)
	public Response createRegistration(HttpServletRequest request,
								 HttpServletResponse response, HttpSession session,
								 @RequestBody
								 PhfiRegistrationRequest phfiRegistrationRequest) {
		logger.info("Entering :: RestController :: RestRegistrationServiceImpl :: createRegistration method");
		Response regResponse = registrationHandler.createRegistration(phfiRegistrationRequest);
		logger.info("Exiting :: RestController :: RestRegistrationServiceImpl :: createRegistration method");
		return regResponse;
	}
	/**
	 * @param request
	 * @param response
	 * @param session
	 * @param phfiRegistrationRequest
	 * @return
	 */
	@Override
	@RequestMapping(value = "/getRegistedWoman", method = RequestMethod.POST)
	public PhfiRegistrationResponse getRegistredWoman(HttpServletRequest request,
													  HttpServletResponse response,
													  HttpSession session,
													  @RequestBody
													  PhfiRegistrationRequest phfiRegistrationRequest) {
		logger.info("Entering :: RestController :: RestRegistrationServiceImpl :: createRegistration method");
		PhfiRegistrationResponse regWomanResponse = registrationHandler.getRegistredWoman(phfiRegistrationRequest);
		logger.info("Exiting :: RestController :: RestRegistrationServiceImpl :: createRegistration method");
		return regWomanResponse;
	}
	/**
	 * @param request
	 * @param response
	 * @param session
	 * @param phfiRegistrationRequest
	 * @return
	 */
	@Override
	@RequestMapping(value = "/createPregnancyVisit", method = RequestMethod.POST)
	public Response createPregnancyVisit(HttpServletRequest request,
										 HttpServletResponse response,
										 HttpSession session,
										 @RequestBody
										 PhfiVisitRequest phfiVisitRequest) {
		logger.info("Entering :: RestController :: RestRegistrationServiceImpl :: createPregnancyVisit method");
		PhfiVisitResponse pregnancyVisitResponse = registrationHandler.createPregnancyVisit(phfiVisitRequest);
		logger.info("Exiting :: RestController :: RestRegistrationServiceImpl :: createPregnancyVisit method");
		return pregnancyVisitResponse;
	}
	/**
	 * @param request
	 * @param response
	 * @param session
	 * @param phfiPostPartumVisitRequest
	 * @return
	 */
	@Override
	@RequestMapping(value = "/createPostpartumVisit", method = RequestMethod.POST)
	public Response createPostpartumVisit(HttpServletRequest request,
										  HttpServletResponse response,
										  HttpSession session,
										  @RequestBody
										  PhfiPostPartumVisitRequest phfiPostPartumVisitRequest) {
		logger.info("Entering :: RestController :: RestRegistrationServiceImpl :: createPostpartumVisit method");
		PhfiPostPartumVisitResponse postPartumVisitResponse = registrationHandler.createPostpartumVisit(phfiPostPartumVisitRequest);
		logger.info("Exiting :: RestController :: RestRegistrationServiceImpl :: createPostpartumVisit method");
		return postPartumVisitResponse;
	}
	/**
	 * @param request
	 * @param response
	 * @param session
	 * @param phfiDeliveryFormRequest
	 * @return
	 */
	@Override
	@RequestMapping(value = "/processDeliveryCreate", method = RequestMethod.POST)
	public Response createDelivery(HttpServletRequest request,
								   HttpServletResponse response,
								   HttpSession session,
								   @RequestBody
								   PhfiDeliveryFormRequest phfiDeliveryFormRequest) {
		logger.info("Entering :: RestController :: RestRegistrationServiceImpl :: createDelivery method");
		PhfiDeliveryFormResponse phfiDeliveryFormResponse = registrationHandler.createDelivery(phfiDeliveryFormRequest);
		logger.info("Exiting :: RestController :: RestRegistrationServiceImpl :: createDelivery method");
		return phfiDeliveryFormResponse;
	}
	/**
	 * @param request
	 * @param response
	 * @param session
	 * @param phfiDoctorFormRequest
	 * @return
	 */
	@Override
	@RequestMapping(value = "/processDoctorCreate", method = RequestMethod.POST)
	public Response createDoctorCreate(HttpServletRequest request,
									   HttpServletResponse response, 
									   HttpSession session,
									   @RequestBody
									   PhfiDoctorFormRequest phfiDoctorFormRequest) {
		logger.info("Entering :: RestController :: RestRegistrationServiceImpl :: createDoctorCreate method");
		Response responseData = registrationHandler.createDoctorCreate(phfiDoctorFormRequest);
		logger.info("Exiting :: RestController :: RestRegistrationServiceImpl :: createDoctorCreate method");
		return responseData;
	}
	/**
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@Override
	@RequestMapping(value = "/allWid", method = RequestMethod.POST)
	public Response getAllWid(HttpServletRequest request,
							  HttpServletResponse response,
							  HttpSession session) {
		logger.info("Entering :: RestController :: RestRegistrationServiceImpl :: getAllWid method");
		Response responseData = registrationHandler.getAllWid();
		logger.info("Exiting :: RestController :: RestRegistrationServiceImpl :: getAllWid method");
		return responseData;
	}
	/**
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@Override
	@RequestMapping(value = "/allWomanName", method = RequestMethod.POST)
	public Response getAllWomanName(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		logger.info("Entering :: RestController :: RestRegistrationServiceImpl :: getAllWomanName method");
		Response responseData = registrationHandler.getAllWomanName();
		logger.info("Exiting :: RestController :: RestRegistrationServiceImpl :: getAllWomanName method");
		return responseData;
	}

}
