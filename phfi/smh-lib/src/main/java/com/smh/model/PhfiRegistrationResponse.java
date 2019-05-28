/**
 * 
 */
package com.smh.model;

import java.util.List;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 5, 2016 10:01:57 PM
 * @version 1.0
 */
public class PhfiRegistrationResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = -387542690390084234L;
	
	List<PhfiRegistrationRequest> phfiRegistrationRequest;

	/**
	 * @return the phfiRegistrationRequest
	 */
	public List<PhfiRegistrationRequest> getPhfiRegistrationRequest() {
		return phfiRegistrationRequest;
	}

	/**
	 * @param phfiRegistrationRequest the phfiRegistrationRequest to set
	 */
	public void setPhfiRegistrationRequest(
			List<PhfiRegistrationRequest> phfiRegistrationRequest) {
		this.phfiRegistrationRequest = phfiRegistrationRequest;
	}

}
