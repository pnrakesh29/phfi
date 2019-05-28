/**
 * 
 */
package com.smh.handler;

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

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 3, 2016 11:52:10 PM
 * @version 1.0
 */
public interface RegistrationHandler {

	/**
	 * @param phfiRegistrationRequest
	 * @return
	 */
	public Response createRegistration(PhfiRegistrationRequest phfiRegistrationRequest);

	/**
	 * @param phfiRegistrationRequest
	 * @return
	 */
	public PhfiRegistrationResponse getRegistredWoman(PhfiRegistrationRequest phfiRegistrationRequest);

	/**
	 * @param phfiVisitRequest
	 * @return
	 */
	public PhfiVisitResponse createPregnancyVisit(PhfiVisitRequest phfiVisitRequest);

	/**
	 * @param phfiPostPartumVisitRequest
	 * @return
	 */
	public PhfiPostPartumVisitResponse createPostpartumVisit(PhfiPostPartumVisitRequest phfiPostPartumVisitRequest);

	/**
	 * @param phfiDeliveryFormRequest
	 * @return
	 */
	public PhfiDeliveryFormResponse createDelivery(PhfiDeliveryFormRequest phfiDeliveryFormRequest);

	/**
	 * @param phfiDoctorFormRequest
	 * @return
	 */
	public Response createDoctorCreate(PhfiDoctorFormRequest phfiDoctorFormRequest);

	/**
	 * @return
	 */
	public Response getAllWid();

	/**
	 * @return
	 */
	public Response getAllWomanName();

}
