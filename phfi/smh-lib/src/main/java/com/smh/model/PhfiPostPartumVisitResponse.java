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
 * @date Jan 17, 2016 12:09:45 AM
 * @version 1.0
 */
public class PhfiPostPartumVisitResponse extends Response {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4604890843463548761L;
	private List<PhfiPostPartumVisitRequest> phfiPostPartumVisitRequest;
	/**
	 * @return the phfiPostPartumVisitRequest
	 */
	public List<PhfiPostPartumVisitRequest> getPhfiPostPartumVisitRequest() {
		return phfiPostPartumVisitRequest;
	}
	/**
	 * @param phfiPostPartumVisitRequest the phfiPostPartumVisitRequest to set
	 */
	public void setPhfiPostPartumVisitRequest(
			List<PhfiPostPartumVisitRequest> phfiPostPartumVisitRequest) {
		this.phfiPostPartumVisitRequest = phfiPostPartumVisitRequest;
	}

}
