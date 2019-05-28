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
 * @date Jan 15, 2016 12:27:46 AM
 * @version 1.0
 */
public class PhfiVisitResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = -793705348906099564L;
	
	private List<PhfiVisitRequest> phfiVisitRequest;

	/**
	 * @return the phfiVisitRequest
	 */
	public List<PhfiVisitRequest> getPhfiVisitRequest() {
		return phfiVisitRequest;
	}

	/**
	 * @param phfiVisitRequest the phfiVisitRequest to set
	 */
	public void setPhfiVisitRequest(List<PhfiVisitRequest> phfiVisitRequest) {
		this.phfiVisitRequest = phfiVisitRequest;
	}

}
