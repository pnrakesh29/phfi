/**
 * 
 */
package com.smh.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smh.constants.URLMappingConstants;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 8, 2016 10:12:06 PM
 * @version 1.0
 */
@Controller
@SuppressWarnings("rawtypes") 
public class RoutingController extends BaseController implements URLMappingConstants{
	
	  @RequestMapping(value = SHOW_INPUT_FIRST_LAYOUT, method = RequestMethod.GET)
	  public ModelAndView getInputLayout(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 HttpSession session,
			  						 Map model) {
	    ModelAndView modelAndView = new ModelAndView(INPUT_FIRST_LAYOUT);    
	    return modelAndView;
	  }
	  @RequestMapping(value = SHOW_REPORT_FIRST_LAYOUT, method = RequestMethod.GET)
	  public ModelAndView getReportLayout(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 HttpSession session,
			  						 Map model) {
	    ModelAndView modelAndView = new ModelAndView(REPORT_FIRST_LAYOUT);    
	    return modelAndView;
	  }
	  @RequestMapping(value = SHOW_ASHA_NEXT_LAYOUT, method = RequestMethod.GET)
	  public ModelAndView getAshaNextLayout(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 HttpSession session,
			  						 Map model) {
	    ModelAndView modelAndView = new ModelAndView(ASHA_NEXT_LAYOUT);    
	    return modelAndView;
	  }
	  @RequestMapping(value = SHOW_DOCTOR_NEXT_LAYOUT, method = RequestMethod.GET)
	  public ModelAndView getDoctorNextLayout(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 HttpSession session,
			  						 Map model) {
	    ModelAndView modelAndView = new ModelAndView(DOCTOR_NEXT_LAYOUT);    
	    return modelAndView;
	  }
	  @RequestMapping(value = SHOW_ADD_VISIT_NEXT_LAYOUT, method = RequestMethod.GET)
	  public ModelAndView getAddVisitNextLayout(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 HttpSession session,
			  						 Map model) {
	    ModelAndView modelAndView = new ModelAndView(ADD_VISIT_NEXT_LAYOUT);    
	    return modelAndView;
	  }
	  @RequestMapping(value = GET_MASTER_RAW_DATA_DASHBOARD, method = RequestMethod.GET)
	  public ModelAndView getRawDataMasterLayout(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 HttpSession session,
			  						 Map model) {
	    ModelAndView modelAndView = new ModelAndView(MASTER_RAW_DATA_DASHBOARD);    
	    return modelAndView;
	  }
	  
	  
	  
	  
}
