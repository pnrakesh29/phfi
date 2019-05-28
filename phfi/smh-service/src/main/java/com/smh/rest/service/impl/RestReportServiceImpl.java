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

import com.smh.handler.ReportHandler;
import com.smh.model.MedicalCaseSheetDTO;
import com.smh.model.PhfiDeliveryFormResponse;
import com.smh.model.PhfiPostPartumVisitResponse;
import com.smh.model.PhfiRegistrationResponse;
import com.smh.model.PhfiVisitResponse;
import com.smh.model.ReportRequest;
import com.smh.model.ReportResponse;
import com.smh.rest.service.RestReportService;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 24, 2016 12:25:56 PM
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/reportService", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestReportServiceImpl implements RestReportService{

	public static Logger logger = Logger.getLogger(RestReportServiceImpl.class);
	
	@Autowired
	private ReportHandler reportHandler;
	/**
	 * @param request
	 * @param response
	 * @param session
	 * @param reportRequest
	 * @return
	 */
	@Override
	@RequestMapping(value = "/getMasterReport", method = RequestMethod.POST)
	public ReportResponse getMasterReport(HttpServletRequest request,
										  HttpServletResponse response,
										  HttpSession session,
										  @RequestBody
										  ReportRequest reportRequest) {
		logger.info("Entering :: RestController :: RestReportServiceImpl :: getMasterReport method");
		ReportResponse reportResponse = reportHandler.getMasterReport(reportRequest);
		logger.info("Exiting :: RestController ::  RestReportServiceImpl :: getMasterReport method");
		return reportResponse;
	}
	/**
	 * @param request
	 * @param response
	 * @param session
	 * @param reportRequest
	 * @return
	 */
	@Override
	@RequestMapping(value = "/getCaseSheetReport", method = RequestMethod.POST)
	public MedicalCaseSheetDTO getCaseSheetReport(HttpServletRequest request,
												  HttpServletResponse response,
												  HttpSession session,
												  @RequestBody
												  ReportRequest reportRequest) {
		logger.info("Entering :: RestController :: RestReportServiceImpl :: getMasterReport method");
		MedicalCaseSheetDTO reportResponse = reportHandler.getCaseSheetReport(reportRequest);
		logger.info("Exiting :: RestController ::  RestReportServiceImpl :: getMasterReport method");
		return reportResponse;
	}
	/**
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@Override
	@RequestMapping(value = "/getMasterRawData", method = RequestMethod.POST)
	public PhfiRegistrationResponse getMasterRawData(HttpServletRequest request,
													 HttpServletResponse response,
													 HttpSession session) {
		logger.info("Entering :: RestController :: RestReportServiceImpl :: getMasterRawData method");
		PhfiRegistrationResponse rawDataResponse = reportHandler.getMasterRawData();
		logger.info("Exiting :: RestController ::  RestReportServiceImpl :: getMasterRawData method");
		return rawDataResponse;
	}
	/**
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@Override
	@RequestMapping(value = "/getVisitRawData", method = RequestMethod.POST)
	public PhfiVisitResponse getPreganancyRawData(HttpServletRequest request,
												  HttpServletResponse response,
												  HttpSession session) {
		logger.info("Entering :: RestController :: RestReportServiceImpl :: getPreganancyRawData method");
		PhfiVisitResponse rawDataResponse = reportHandler.getPregnancyRawData();
		logger.info("Exiting :: RestController ::  RestReportServiceImpl :: getPreganancyRawData method");
		return rawDataResponse;
	}
	/**
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@Override
	@RequestMapping(value = "/getPostpartumRawData", method = RequestMethod.POST)
	public PhfiPostPartumVisitResponse getPostpartumRawData(HttpServletRequest request, 
															HttpServletResponse response,
															HttpSession session) {
		logger.info("Entering :: RestController :: RestReportServiceImpl :: getPostpartumRawData method");
		PhfiPostPartumVisitResponse rawDataResponse = reportHandler.getPostpartumRawData();
		logger.info("Exiting :: RestController ::  RestReportServiceImpl :: getPostpartumRawData method");
		return rawDataResponse;
	}
	/**
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@Override
	@RequestMapping(value = "/getDeliveryRawData", method = RequestMethod.POST)
	public PhfiDeliveryFormResponse getDeliveryRawData(HttpServletRequest request,
													   HttpServletResponse response,
													   HttpSession session) {
		logger.info("Entering :: RestController :: RestReportServiceImpl :: getDeliveryRawData method");
		PhfiDeliveryFormResponse rawDataResponse = reportHandler.getDeliveryRawData();
		logger.info("Exiting :: RestController ::  RestReportServiceImpl :: getDeliveryRawData method");
		return rawDataResponse;
	}
	

}
