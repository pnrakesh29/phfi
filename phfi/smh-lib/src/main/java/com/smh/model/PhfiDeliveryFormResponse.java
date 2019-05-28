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
 * @date Jan 21, 2016 11:27:49 PM
 * @version 1.0
 */
public class PhfiDeliveryFormResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3162986252458233750L;
	List<PhfiDeliveryFormRequest> phfiDeliveryFormRequest;
	/**
	 * @return the phfiDeliveryFormRequest
	 */
	public List<PhfiDeliveryFormRequest> getPhfiDeliveryFormRequest() {
		return phfiDeliveryFormRequest;
	}
	/**
	 * @param phfiDeliveryFormRequest the phfiDeliveryFormRequest to set
	 */
	public void setPhfiDeliveryFormRequest(
			List<PhfiDeliveryFormRequest> phfiDeliveryFormRequest) {
		this.phfiDeliveryFormRequest = phfiDeliveryFormRequest;
	}
}
