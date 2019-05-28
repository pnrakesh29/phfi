/**
 * 
 */
package com.smh.rest.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
 * @date Jan 3, 2016 11:47:52 PM
 * @version 1.0
 */
public interface RestRegistrationService {
	
	public Response createRegistration(HttpServletRequest request,
								 HttpServletResponse response, HttpSession session,
								 PhfiRegistrationRequest phfiRegistrationRequest);
	
	public PhfiRegistrationResponse getRegistredWoman(HttpServletRequest request,
								 HttpServletResponse response, HttpSession session,
								 PhfiRegistrationRequest phfiRegistrationRequest);
	
	public Response createPregnancyVisit(HttpServletRequest request,
								 HttpServletResponse response, HttpSession session,
								 PhfiVisitRequest phfiVisitRequest);
	public Response createPostpartumVisit(HttpServletRequest request,
								 HttpServletResponse response, HttpSession session,
								 PhfiPostPartumVisitRequest phfiPostPartumVisitRequest);
	public Response createDelivery(HttpServletRequest request,
								 HttpServletResponse response, HttpSession session,
								 PhfiDeliveryFormRequest phfiDeliveryFormRequest);
	public Response createDoctorCreate(HttpServletRequest request,
								   	   HttpServletResponse response, HttpSession session,
								       PhfiDoctorFormRequest phfiDoctorFormRequest);
	
	public Response getAllWid(HttpServletRequest request,
							  HttpServletResponse response,
							  HttpSession session);
	
	public Response getAllWomanName(HttpServletRequest request,
			                        HttpServletResponse response,
			                        HttpSession session);
}
