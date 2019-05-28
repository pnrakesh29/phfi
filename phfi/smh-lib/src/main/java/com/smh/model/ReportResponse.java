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
 * @date Jan 24, 2016 12:16:59 PM
 * @version 1.0
 */
public class ReportResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2437194397291647863L;

	List<ReportRequest> reportRequest;

	/**
	 * @return the reportRequest
	 */
	public List<ReportRequest> getReportRequest() {
		return reportRequest;
	}

	/**
	 * @param reportRequest the reportRequest to set
	 */
	public void setReportRequest(List<ReportRequest> reportRequest) {
		this.reportRequest = reportRequest;
	}
}
