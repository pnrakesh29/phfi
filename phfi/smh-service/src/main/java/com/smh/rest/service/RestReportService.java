/**
 * 
 */
package com.smh.rest.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smh.model.MedicalCaseSheetDTO;
import com.smh.model.PhfiDeliveryFormResponse;
import com.smh.model.PhfiPostPartumVisitResponse;
import com.smh.model.PhfiRegistrationResponse;
import com.smh.model.PhfiVisitResponse;
import com.smh.model.ReportRequest;
import com.smh.model.ReportResponse;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 24, 2016 12:24:29 PM
 * @version 1.0
 */
public interface RestReportService {
	public ReportResponse getMasterReport(HttpServletRequest request,
										  HttpServletResponse response,
										  HttpSession session,
										  ReportRequest reportRequest);
	
	public MedicalCaseSheetDTO getCaseSheetReport(HttpServletRequest request,
										  HttpServletResponse response,
										  HttpSession session,
										  ReportRequest reportRequest);
	
	
	public PhfiRegistrationResponse getMasterRawData(HttpServletRequest request,
												HttpServletResponse response,
												HttpSession session);
	public PhfiVisitResponse getPreganancyRawData(HttpServletRequest request,
													 HttpServletResponse response,
													 HttpSession session);
	public PhfiPostPartumVisitResponse getPostpartumRawData(HttpServletRequest request,
													 HttpServletResponse response,
													 HttpSession session);
	public PhfiDeliveryFormResponse getDeliveryRawData(HttpServletRequest request,
													 HttpServletResponse response,
													 HttpSession session);
}
