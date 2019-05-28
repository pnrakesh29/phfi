/**
 * 
 */
package com.smh.service;

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

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 3, 2016 11:24:42 PM
 * @version 1.0
 */
public interface RegistrationService {

	/**
	 * @param phfiRegistrationRequest
	 * @return
	 * @throws SmhAdminException 
	 */
	public Response createRegistration(PhfiRegistrationRequest phfiRegistrationRequest) throws SmhAdminException;

	/**
	 * @param phfiRegistrationRequest
	 * @return
	 * @throws SmhAdminException 
	 */
	public PhfiRegistrationResponse getRegistedWoman(PhfiRegistrationRequest phfiRegistrationRequest) throws SmhAdminException;

	/**
	 * @param phfiVisitRequest
	 * @return
	 * @throws SmhAdminException 
	 */
	public Response createPregnancyVisit(PhfiVisitRequest phfiVisitRequest) throws SmhAdminException;

	/**
	 * @param phfiPostPartumVisitRequest
	 * @return
	 * @throws SmhAdminException 
	 */
	public Response processPostpartumVisitCreate(PhfiPostPartumVisitRequest phfiPostPartumVisitRequest) throws SmhAdminException;

	/**
	 * @param phfiDeliveryFormRequest
	 * @return
	 * @throws SmhAdminException 
	 */
	public Response processDeliveryCreate(PhfiDeliveryFormRequest phfiDeliveryFormRequest) throws SmhAdminException;

	/**
	 * @param phfiDoctorFormRequest
	 * @return
	 */
	public Response processDoctorCreate(PhfiDoctorFormRequest phfiDoctorFormRequest) throws SmhAdminException;

	/**
	 * @return
	 */
	public AllWidResponse getAllWid() throws SmhAdminException;

	/**
	 * @return
	 */
	public AllWomenResponse getAllName() throws SmhAdminException;;

}
