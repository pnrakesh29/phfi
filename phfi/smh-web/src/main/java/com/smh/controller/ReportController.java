/**
 * 
 */
package com.smh.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smh.constants.Constant;
import com.smh.constants.URLMappingConstants;
import com.smh.model.MedicalCaseSheetDTO;
import com.smh.model.PhfiDeliveryFormResponse;
import com.smh.model.PhfiPostPartumVisitResponse;
import com.smh.model.PhfiRegistrationResponse;
import com.smh.model.PhfiVisitResponse;
import com.smh.model.ReportRequest;
import com.smh.model.ReportResponse;
import com.smh.service.ReportService;
import com.smh.util.DeliveryMasterRawDataUtil;
import com.smh.util.PaginationUtil;
import com.smh.util.PostpartumMasterRawDataUtil;
import com.smh.util.PreganancyMasterRawDataUtil;
import com.smh.util.RegistrationMasterRawDataUtil;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 24, 2016 11:53:04 AM
 * @version 1.0
 */

@Controller
@SuppressWarnings({"rawtypes","unchecked"})
public class ReportController extends BaseController implements URLMappingConstants{
	private static Logger logger = Logger.getLogger(ReportController.class);
	
	@Autowired
	private ReportService reportService;
	
	@RequestMapping(value = GET_MASTER_REPORT, method = RequestMethod.GET)
	 public ModelAndView processMasterReportSearch(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 ReportRequest reportRequest,
			  						 BindingResult bindingResult,
			  						 HttpSession session,
			  						  Map model) {
	    ModelAndView modelAndView = new ModelAndView(SHOW_MASTER_REPORT);    
	    logger.info("Entering:: ReportController:: processMasterReportSearch method");
		session.setAttribute(Constant.PHFI_REQUEST, reportRequest);
		
		try {
			model.put("reportRequest",reportRequest);
			reportRequest.setPageIndex(Constant.ONE);
			reportRequest.setPageSize(Constant.MAX_ENTITIES_PAGINATION_DISPLAY_SIZE);
			ReportResponse reportResponse = reportService.getMasterReport(reportRequest);
			if (Constant.SUCCESS.equalsIgnoreCase(reportResponse.getResponseMessage())) {
				List<ReportRequest> masterReport = reportResponse.getReportRequest();
				model.put("totalCount", reportResponse.getNoOfRecords());
				modelAndView.addObject("resultflag", true);
				modelAndView = PaginationUtil.getPagenationModel(modelAndView, reportResponse.getNoOfRecords());
				model.put("masterReportList", masterReport);
			} else {
				modelAndView.addObject("resultflag", true);
				model.put("masterReportList", new ArrayList());
			}
		} catch (Exception e) {
			logger.error("Error:: ReportController:: processMasterReportSearch method",e);
			modelAndView.setViewName(INVALID_PAGE);
		}

		logger.info("Exiting:: ReportController:: processMasterReportSearch method");
		return modelAndView;
	  }
	
	

	@RequestMapping(value = GET_DOCTOR_RATIFIED_REPORT, method = RequestMethod.GET)
	 public ModelAndView processDoctorRatifiedReportSearch(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 ReportRequest reportRequest,
			  						 BindingResult bindingResult,
			  						 HttpSession session,
			  						  Map model) {
	    ModelAndView modelAndView = new ModelAndView(SHOW_DOCTOR_RATIFIED_REPORT);    
	    logger.info("Entering:: ReportController:: processDoctorRatifiedReportSearch method");
		session.setAttribute(Constant.PHFI_REQUEST, reportRequest);
		
		try {
			reportRequest.setMaternityStatus(request.getParameter("maternityStatus"));
			model.put("reportRequest", new ReportRequest());
			reportRequest.setPageIndex(Constant.ONE);
			reportRequest.setPageSize(Constant.MAX_ENTITIES_PAGINATION_DISPLAY_SIZE);
			ReportResponse reportResponse = reportService.getMasterReport(reportRequest);
			if (Constant.SUCCESS.equalsIgnoreCase(reportResponse.getResponseMessage())) {
				List<ReportRequest> masterReport = reportResponse.getReportRequest();
				model.put("totalCount", reportResponse.getNoOfRecords());
				modelAndView.addObject("resultflag", true);
				modelAndView = PaginationUtil.getPagenationModel(modelAndView, reportResponse.getNoOfRecords());
				model.put("masterReportList", masterReport);
			} else {
				modelAndView.addObject("resultflag", true);
				model.put("masterReportList", new ArrayList());
			}
		} catch (Exception e) {
			logger.error("Error:: ReportController:: processDoctorRatifiedReportSearch method",e);
			modelAndView.setViewName(INVALID_PAGE);
		}

		logger.info("Exiting:: ReportController:: processDoctorRatifiedReportSearch method");
		return modelAndView;
	  }

	
	@RequestMapping(value = GET_ASHA_FEEDBACK_REPORT, method = RequestMethod.GET)
	 public ModelAndView processAshaFeedbackReportSearch(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 ReportRequest reportRequest,
			  						 BindingResult bindingResult,
			  						 HttpSession session,
			  						  Map model) {
	    ModelAndView modelAndView = new ModelAndView(SHOW_ASHA_FEEDBACK_REPORT);    
	    logger.info("Entering:: ReportController:: processAshaFeedbackReportSearch method");
		session.setAttribute(Constant.PHFI_REQUEST, reportRequest);
		
		try {
			reportRequest.setMaternityStatus(request.getParameter("maternityStatus"));
			model.put("reportRequest", new ReportRequest());
			reportRequest.setPageIndex(Constant.ONE);
			reportRequest.setPageSize(Constant.MAX_ENTITIES_PAGINATION_DISPLAY_SIZE);
			ReportResponse reportResponse = reportService.getMasterReport(reportRequest);
			if (Constant.SUCCESS.equalsIgnoreCase(reportResponse.getResponseMessage())) {
				List<ReportRequest> masterReport = reportResponse.getReportRequest();
				model.put("totalCount", reportResponse.getNoOfRecords());
				modelAndView.addObject("resultflag", true);
				modelAndView = PaginationUtil.getPagenationModel(modelAndView, reportResponse.getNoOfRecords());
				model.put("masterReportList", masterReport);
			} else {
				modelAndView.addObject("resultflag", true);
				model.put("masterReportList", new ArrayList());
			}
		} catch (Exception e) {
			logger.error("Error:: ReportController:: processAshaFeedbackReportSearch method",e);
			modelAndView.setViewName(INVALID_PAGE);
		}

		logger.info("Exiting:: ReportController:: processAshaFeedbackReportSearch method");
		return modelAndView;
	  }
	
	 @RequestMapping(value = SHOW_MEDICAL_CASE_SHEET, method = RequestMethod.GET)
	  public ModelAndView getInputLayout(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 HttpSession session,
			  						 Map model) {
	    ModelAndView modelAndView = new ModelAndView(MEDICAL_CASE_SHEET); 
	    logger.info("Entering :: ReportController:: getMasterRawRawData method");
	    ReportRequest reportRequest = new ReportRequest();
	    String uuid = request.getParameter("uuid");
	    reportRequest.setWid(Integer.parseInt(uuid));
		try {
			reportRequest.setPageIndex(Constant.ONE);
			reportRequest.setPageSize(Constant.MAX_ENTITIES_PAGINATION_DISPLAY_SIZE);
			MedicalCaseSheetDTO reportResponse = reportService.getCaseSheetReport(reportRequest);
			if (Constant.SUCCESS.equalsIgnoreCase(reportResponse.getResponseMessage())) {
				/*List<ReportRequest> masterReport = reportResponse.getReportRequest();*/
				model.put("totalCount", reportResponse.getNoOfRecords());
				modelAndView.addObject("resultflag", true);
				modelAndView = PaginationUtil.getPagenationModel(modelAndView, reportResponse.getNoOfRecords());
				model.put("medicalCaseSheet", reportResponse);
			} else {
				modelAndView.addObject("resultflag", true);
				model.put("medicalCaseSheet", new MedicalCaseSheetDTO());
			}
		} catch (Exception e) {
			logger.error("Error:: ReportController:: processAshaFeedbackReportSearch method",e);
			modelAndView.setViewName(INVALID_PAGE);
		}
	    return modelAndView;
	  }
	
	 @RequestMapping(value = GET_REGISTRATION_MASTER_RAW_DATA, method = RequestMethod.GET)
	  public ModelAndView getMasterRawRawData(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 HttpSession session,
			  						 Map model) {
	    ModelAndView modelAndView = new ModelAndView(MEDICAL_CASE_SHEET); 
	    logger.info("Entering :: ReportController:: getMasterRawRawData method");
		try {
			PhfiRegistrationResponse rawDataresponse = reportService.getRawMaterData();
			if (Constant.SUCCESS.equalsIgnoreCase(rawDataresponse.getResponseMessage())) {
				if (rawDataresponse != null && !CollectionUtils.isEmpty(rawDataresponse.getPhfiRegistrationRequest())) {
					RegistrationMasterRawDataUtil.downloadPhfiParameterXl(rawDataresponse.getPhfiRegistrationRequest(), response);
				}
			} 
			 logger.info("Exiting :: ReportController:: getMasterRawRawData method");
		} catch (Exception e) {
			logger.error("Error:: ReportController:: getMasterRawRawData method",e);
			modelAndView.setViewName(INVALID_PAGE);
		}
	    return null;
	  }
	 
	 @RequestMapping(value = GET_PREGANANCY_MASTER_RAW_DATA, method = RequestMethod.GET)
	  public ModelAndView getPreganancyMasterRawData(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 HttpSession session,
			  						 Map model) {
	    ModelAndView modelAndView = new ModelAndView(MEDICAL_CASE_SHEET); 
	    logger.info("Entering :: ReportController:: getMasterRawRawData method");
		try {
			PhfiVisitResponse rawDataresponse = reportService.getVisitRawMaterData();
			if (Constant.SUCCESS.equalsIgnoreCase(rawDataresponse.getResponseMessage())) {
				if (rawDataresponse != null && !CollectionUtils.isEmpty(rawDataresponse.getPhfiVisitRequest())) {
					PreganancyMasterRawDataUtil.downloadPhfiParameterXl(rawDataresponse.getPhfiVisitRequest(), response);
				}
			} 
			 logger.info("Exiting :: ReportController:: getMasterRawRawData method");
		} catch (Exception e) {
			logger.error("Error:: ReportController:: getMasterRawRawData method",e);
			modelAndView.setViewName(INVALID_PAGE);
		}
	    return null;
	  }
	 
	 @RequestMapping(value = GET_POSTPARTUM_MASTER_RAW_DATA, method = RequestMethod.GET)
	  public ModelAndView getPostpartumMasterRawData(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 HttpSession session,
			  						 Map model) {
	    ModelAndView modelAndView = new ModelAndView(MEDICAL_CASE_SHEET); 
	    logger.info("Entering :: ReportController:: getMasterRawRawData method");
		try {
			PhfiPostPartumVisitResponse rawDataresponse = reportService.getPostpartumRawMaterData();
			if (Constant.SUCCESS.equalsIgnoreCase(rawDataresponse.getResponseMessage())) {
				if (rawDataresponse != null && !CollectionUtils.isEmpty(rawDataresponse.getPhfiPostPartumVisitRequest())) {
					PostpartumMasterRawDataUtil.downloadPhfiParameterXl(rawDataresponse.getPhfiPostPartumVisitRequest(), response);
				}
			} 
			 logger.info("Exiting :: ReportController:: getMasterRawRawData method");
		} catch (Exception e) {
			logger.error("Error:: ReportController:: getMasterRawRawData method",e);
			modelAndView.setViewName(INVALID_PAGE);
		}
	    return null;
	  }
	 
	 @RequestMapping(value = GET_DELIVERY_MASTER_RAW_DATA, method = RequestMethod.GET)
	  public ModelAndView getDeliveryMasterRawData(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 HttpSession session,
			  						 Map model) {
	    ModelAndView modelAndView = new ModelAndView(MEDICAL_CASE_SHEET); 
	    logger.info("Entering :: ReportController:: getMasterRawRawData method");
		try {
			PhfiDeliveryFormResponse rawDataresponse = reportService.getDeliveryRawMaterData();
			if (Constant.SUCCESS.equalsIgnoreCase(rawDataresponse.getResponseMessage())) {
				if (rawDataresponse != null && !CollectionUtils.isEmpty(rawDataresponse.getPhfiDeliveryFormRequest())) {
					DeliveryMasterRawDataUtil.downloadPhfiParameterXl(rawDataresponse.getPhfiDeliveryFormRequest(), response);
				}
			} 
			 logger.info("Exiting :: ReportController:: getMasterRawRawData method");
		} catch (Exception e) {
			logger.error("Error:: ReportController:: getMasterRawRawData method",e);
			modelAndView.setViewName(INVALID_PAGE);
		}
	    return null;
	  }
	
}
