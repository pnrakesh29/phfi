package com.smh.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smh.constants.Constant;
import com.smh.constants.PHFIWebConstant;
import com.smh.constants.URLMappingConstants;
import com.smh.exception.SmhAdminException;
import com.smh.model.AllWidResponse;
import com.smh.model.AllWomenResponse;
import com.smh.model.PhfiDeliveryFormRequest;
import com.smh.model.PhfiDoctorFormRequest;
import com.smh.model.PhfiPostPartumVisitRequest;
import com.smh.model.PhfiRegistrationRequest;
import com.smh.model.PhfiRegistrationResponse;
import com.smh.model.PhfiVisitRequest;
import com.smh.model.Response;
import com.smh.service.RegistrationService;
import com.smh.util.PaginationUtil;
import com.smh.util.Properties;
import com.smh.util.StringUtil;

@Controller
@SuppressWarnings({"rawtypes","unchecked"})
public class RegistrationController extends BaseController implements URLMappingConstants{
	
	private static Logger logger = Logger.getLogger(RegistrationController.class);
	
	@Autowired
	private RegistrationService registrationService;
	
	@RequestMapping(value = SHOW_PHFI_REG, method = RequestMethod.GET)
	  public ModelAndView showRegistration(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 PhfiRegistrationRequest phfiRegistrationRequest,
			  						 BindingResult bindingResult,
			  						 HttpSession session,
			  						  Map model) {
	    ModelAndView modelAndView = new ModelAndView(PHFI_REG);    
	    modelAndView.addObject("phfiRegistrationRequest", phfiRegistrationRequest);
	    try {
			AllWidResponse widResponse = registrationService.getAllWid();
			AllWomenResponse nameResponse = registrationService.getAllName();
			if (StringUtil.isListNotNullNEmpty(widResponse.getWid())) {
				modelAndView.addObject("allWidList", widResponse.getWid());
			}
			if (StringUtil.isListNotNullNEmpty(widResponse.getWid())) {
				modelAndView.addObject("allWomenNameList",nameResponse.getWomanName());
			}
		} catch (SmhAdminException e) {
			logger.error("Error ::RegistrationController:: showDoctorForm method");
			e.printStackTrace();
		}
	    return modelAndView;
	  }
	  @RequestMapping(value = PROCESS_PHFI_REG, method = RequestMethod.POST)
	  public ModelAndView processRegistrationCreate(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 PhfiRegistrationRequest phfiRegistrationRequest,
			  						 BindingResult bindingResult,
			  						 HttpSession session,
			  						  Map model) {
	    ModelAndView modelAndView = new ModelAndView(ASHA_NEXT_LAYOUT); 
	    logger.info("Entering :: RegistrationController ::processRegistrationCreate method ");
		try {
			Response phfiResponse = registrationService.createRegistration(phfiRegistrationRequest);
			if (phfiResponse.getResponseMessage().equalsIgnoreCase(Constant.SUCESS)) {
				modelAndView.addObject(PHFIWebConstant.SUCCESS, Properties.getProperty("phfi_registration_success"));
			} else {
				modelAndView.addObject("phfiRegistrationRequest", phfiRegistrationRequest);
				modelAndView.addObject(PHFIWebConstant.ERROR,phfiResponse.getResponseMessage());
				modelAndView.setViewName(PHFI_REG);
			}
		} catch (Exception e) {
			logger.error("Error ::RegistrationController:: processRegistrationCreate method");
			modelAndView.setViewName(INVALID_PAGE);
		}
		logger.error("Exiting ::RegistrationController:: processRegistrationCreate method");
	    return modelAndView;
	  }
	
	@RequestMapping(value = SHOW_PHFI_REG_SEARCH, method = RequestMethod.GET)
	  public ModelAndView showRegistrationSearch(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 HttpSession session,
			  						  Map model) {
	    ModelAndView modelAndView = new ModelAndView(PHFI_REG_SEARCH);    
	    PhfiRegistrationRequest phfiRegistrationRequest = new PhfiRegistrationRequest();
		try {
			model.put("phfiRegistrationRequest", new PhfiRegistrationRequest());
			phfiRegistrationRequest.setPageIndex(Constant.ONE);
			phfiRegistrationRequest.setPageSize(Constant.MAX_ENTITIES_PAGINATION_DISPLAY_SIZE);
			PhfiRegistrationResponse registrationResponse = registrationService.getRegistedWoman(phfiRegistrationRequest);
			if (registrationResponse != null) {
				List<PhfiRegistrationRequest> womanData = registrationResponse.getPhfiRegistrationRequest();
				model.put("totalCount", registrationResponse.getNoOfRecords());
				modelAndView.addObject("resultflag", true);
				modelAndView = PaginationUtil.getPagenationModel(modelAndView, registrationResponse.getNoOfRecords());
				model.put("womanList", womanData);
			} else {
				modelAndView = showRegistrationSearch(request, response, session, model);
			}
		} catch (Exception e) {
			logger.error("Error:: BeconController:: procesBeconLocationMapSearch method",e);
			modelAndView.setViewName(INVALID_PAGE);
		}

		logger.info("Exiting:: BeconController:: procesBeconLocationMapSearch method");
		return modelAndView;
	  }
	
	
	@RequestMapping(value = PROCESS_PHFI_REG_SEARCH, method = RequestMethod.POST)
	 public ModelAndView processRegistrationSearch(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 PhfiRegistrationRequest phfiRegistrationRequest,
			  						 BindingResult bindingResult,
			  						 HttpSession session,
			  						  Map model) {
	    ModelAndView modelAndView = new ModelAndView(PHFI_REG_SEARCH);    
	    logger.info("Entering:: BeconController:: procesBeconLocationMapSearch method");
		session.setAttribute(Constant.PHFI_REQUEST, phfiRegistrationRequest);
		
		try {
			model.put("phfiRegistrationRequest", new PhfiRegistrationRequest());
			phfiRegistrationRequest.setPageIndex(Constant.ONE);
			phfiRegistrationRequest.setPageSize(Constant.MAX_ENTITIES_PAGINATION_DISPLAY_SIZE);
			PhfiRegistrationResponse registrationResponse = registrationService.getRegistedWoman(phfiRegistrationRequest);
			if (registrationResponse != null) {
				List<PhfiRegistrationRequest> womanData = registrationResponse.getPhfiRegistrationRequest();
				model.put("totalCount", registrationResponse.getNoOfRecords());
				modelAndView.addObject("resultflag", true);
				modelAndView = PaginationUtil.getPagenationModel(modelAndView, registrationResponse.getNoOfRecords());
				model.put("womanList", womanData);
			} else {
				modelAndView = showRegistrationSearch(request, response, session, model);
			}
		} catch (Exception e) {
			logger.error("Error:: BeconController:: procesBeconLocationMapSearch method",e);
			modelAndView.setViewName(INVALID_PAGE);
		}

		logger.info("Exiting:: BeconController:: procesBeconLocationMapSearch method");
		return modelAndView;
	  }
	
	
	
	
	  @RequestMapping(value = SHOW_PHFI_VISI_FORM, method = RequestMethod.GET)
	  public ModelAndView showVisitForm(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 PhfiVisitRequest phfiVisitRequest,
			  						 BindingResult bindingResult,
			  						 HttpSession session,
			  						  Map model) {
	    ModelAndView modelAndView = new ModelAndView(PHFI_VISI_FORM);    
	    modelAndView.addObject("phfiVisitRequest", phfiVisitRequest);
	    try {
			AllWidResponse widResponse = registrationService.getAllWid();
			AllWomenResponse nameResponse = registrationService.getAllName();
			if (StringUtil.isListNotNullNEmpty(widResponse.getWid())) {
				modelAndView.addObject("allWidList", widResponse.getWid());
			}
			if (StringUtil.isListNotNullNEmpty(widResponse.getWid())) {
				modelAndView.addObject("allWomenNameList",nameResponse.getWomanName());
			}
		} catch (SmhAdminException e) {
			logger.error("Error ::RegistrationController:: showDoctorForm method");
			e.printStackTrace();
		}
	    return modelAndView;
	  }
	  
	  
	  @RequestMapping(value = PROCESS_PREGNANCY_VISIT, method = RequestMethod.POST)
	  public ModelAndView processPregnancyVisitCreate(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 PhfiVisitRequest phfiVisitRequest,
			  						 BindingResult bindingResult,
			  						 HttpSession session,
			  						  Map model) {
	    ModelAndView modelAndView = new ModelAndView(ASHA_NEXT_LAYOUT); 
	    logger.info("Entering :: RegistrationController ::processRegistrationCreate method ");
		try {
			Response phfiResponse = registrationService.createPregnancyVisit(phfiVisitRequest);
			if (phfiResponse.getResponseMessage().equalsIgnoreCase(Constant.SUCESS)) {
				modelAndView.addObject(PHFIWebConstant.SUCCESS, Properties.getProperty("phfi_registration_success"));
			} else {
				modelAndView.addObject("phfiVisitRequest", phfiVisitRequest);
				modelAndView.addObject(PHFIWebConstant.ERROR,phfiResponse.getResponseMessage());
				modelAndView.setViewName(PHFI_VISI_FORM);
			}
		} catch (Exception e) {
			logger.error("Error ::RegistrationController:: processRegistrationCreate method");
			modelAndView.setViewName(INVALID_PAGE);
		}
		logger.error("Exiting ::RegistrationController:: processRegistrationCreate method");
	    return modelAndView;
	  }
	
	@RequestMapping(value = SHOW_PHFI_POSTPARTUM_VISI_FORM, method = RequestMethod.GET)
	  public ModelAndView showPostpartumVisitForm(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 PhfiPostPartumVisitRequest phfiPostPartumVisitRequest,
			  						 BindingResult bindingResult,
			  						 HttpSession session,
			  						  Map model) {
	    ModelAndView modelAndView = new ModelAndView(PHFI_POSTPARTUM_VISI_FORM);    
	    modelAndView.addObject("phfiPostPartumVisitRequest", phfiPostPartumVisitRequest);
	    try {
			AllWidResponse widResponse = registrationService.getAllWid();
			AllWomenResponse nameResponse = registrationService.getAllName();
			if (StringUtil.isListNotNullNEmpty(widResponse.getWid())) {
				modelAndView.addObject("allWidList", widResponse.getWid());
			}
			if (StringUtil.isListNotNullNEmpty(widResponse.getWid())) {
				modelAndView.addObject("allWomenNameList",nameResponse.getWomanName());
			}
		} catch (SmhAdminException e) {
			logger.error("Error ::RegistrationController:: showDoctorForm method");
			e.printStackTrace();
		}
	    return modelAndView;
	  }
	
	 @RequestMapping(value = PROCESS_POSTPARTUM_VISIT, method = RequestMethod.POST)
	  public ModelAndView processPostpartumVisitCreate(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 PhfiPostPartumVisitRequest phfiPostPartumVisitRequest,
			  						 BindingResult bindingResult,
			  						 HttpSession session,
			  						  Map model) {
	    ModelAndView modelAndView = new ModelAndView(ASHA_NEXT_LAYOUT); 
	    logger.info("Entering :: RegistrationController ::processRegistrationCreate method ");
		try {
			Response phfiResponse = registrationService.processPostpartumVisitCreate(phfiPostPartumVisitRequest);
			if (phfiResponse.getResponseMessage().equalsIgnoreCase(Constant.SUCESS)) {
				modelAndView.addObject(PHFIWebConstant.SUCCESS, Properties.getProperty("phfi_registration_success"));
			} else {
				modelAndView.setViewName(PHFI_VISI_FORM);
				modelAndView.addObject("phfiPostPartumVisitRequest", phfiPostPartumVisitRequest);
				modelAndView.addObject(PHFIWebConstant.ERROR,phfiResponse.getResponseMessage());
			}
		} catch (Exception e) {
			logger.error("Error ::RegistrationController:: processRegistrationCreate method");
			modelAndView.setViewName(INVALID_PAGE);
		}
		logger.error("Exiting ::RegistrationController:: processRegistrationCreate method");
	    return modelAndView;
	  }
	
	
	
	
	
	@RequestMapping(value = SHOW_PHFI_DELIVERY_VISI_FORM, method = RequestMethod.GET)
	  public ModelAndView showDeliveryVisitForm(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 PhfiDeliveryFormRequest phfiDeliveryFormRequest,
			  						 BindingResult bindingResult,
			  						 HttpSession session,
			  						  Map model) {
	    ModelAndView modelAndView = new ModelAndView(PHFI_DELIVERY_VISI_FORM);    
	    modelAndView.addObject("phfiDeliveryFormRequest", phfiDeliveryFormRequest);
	    try {
			AllWidResponse widResponse = registrationService.getAllWid();
			AllWomenResponse nameResponse = registrationService.getAllName();
			if (StringUtil.isListNotNullNEmpty(widResponse.getWid())) {
				modelAndView.addObject("allWidList", widResponse.getWid());
			}
			if (StringUtil.isListNotNullNEmpty(widResponse.getWid())) {
				modelAndView.addObject("allWomenNameList",nameResponse.getWomanName());
			}
		} catch (SmhAdminException e) {
			logger.error("Error ::RegistrationController:: showDoctorForm method");
			e.printStackTrace();
		}
	    return modelAndView;
	  }
	
	
	@RequestMapping(value = PROCESS_DELIVERY_VISIT, method = RequestMethod.POST)
	  public ModelAndView processDeliveryVisitForm(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 PhfiDeliveryFormRequest phfiDeliveryFormRequest,
			  						 BindingResult bindingResult,
			  						 HttpSession session,
			  						  Map model) {
		logger.info("Entering :: RegistrationController ::processRegistrationCreate method ");
		 ModelAndView modelAndView = new ModelAndView(ASHA_NEXT_LAYOUT); 
		try {
			Response phfiResponse = registrationService.processDeliveryCreate(phfiDeliveryFormRequest);
			if (phfiResponse.getResponseMessage().equalsIgnoreCase(Constant.SUCESS)) {
				modelAndView.addObject(PHFIWebConstant.SUCCESS, Properties.getProperty("phfi_registration_success"));
			} else {
				modelAndView.setViewName(PHFI_DELIVERY_VISI_FORM);
				modelAndView.addObject("phfiDeliveryFormRequest", phfiDeliveryFormRequest);
				modelAndView.addObject(PHFIWebConstant.ERROR,phfiResponse.getResponseMessage());
			}
		} catch (Exception e) {
			logger.error("Error ::RegistrationController:: processRegistrationCreate method");
			modelAndView.setViewName(INVALID_PAGE);
		}
		logger.error("Exiting ::RegistrationController:: processRegistrationCreate method");
	    return modelAndView;
	    
	}
	
	
	@RequestMapping(value = SHOW_PHFI_DOCTOR_FORM, method = RequestMethod.GET)
	  public ModelAndView showDoctorForm(HttpServletRequest request,
			  						 HttpServletResponse response,
			  						 PhfiDoctorFormRequest phfiDoctorFormRequest,
			  						 BindingResult bindingResult,
			  						 HttpSession session,
			  						  Map model) {
	    ModelAndView modelAndView = new ModelAndView(PHFI_DOCTOR_FORM);   
	    logger.info("Entering :: RegistrationController ::showDoctorForm method ");
		try {
			AllWidResponse widResponse = registrationService.getAllWid();
			AllWomenResponse nameResponse = registrationService.getAllName();
			if (StringUtil.isListNotNullNEmpty(widResponse.getWid())) {
				modelAndView.addObject("allWidList", widResponse.getWid());
			}
			if (StringUtil.isListNotNullNEmpty(widResponse.getWid())) {
				modelAndView.addObject("allWomenNameList",nameResponse.getWomanName());
			}
		} catch (SmhAdminException e) {
			logger.error("Error ::RegistrationController:: showDoctorForm method");
			e.printStackTrace();
		}
	    modelAndView.addObject("phfiDoctorForm", phfiDoctorFormRequest);
		logger.error("Exiting ::RegistrationController:: showDoctorForm method");
	    return modelAndView;
	  }

	@RequestMapping(value = PROCESS_DOCTOR_VISIT_FORM, method = RequestMethod.POST)
	  public ModelAndView processDoctorForm(HttpServletRequest request,
					  						HttpServletResponse response,
					  						PhfiDoctorFormRequest phfiDoctorFormRequest,
					  						BindingResult bindingResult,
					  						HttpSession session,
			  						  Map model) {
		logger.info("Entering :: RegistrationController ::processRegistrationCreate method ");
		 ModelAndView modelAndView = new ModelAndView(SHOW_DOCTOR_NEXT_LAYOUT); 
		try {
			Response phfiResponse = registrationService.processDoctorCreate(phfiDoctorFormRequest);
			if (phfiResponse.getResponseMessage().equalsIgnoreCase(Constant.SUCESS)) {
				modelAndView.addObject(PHFIWebConstant.SUCCESS, Properties.getProperty("phfi_registration_success"));
			} else {
				modelAndView.setViewName(PHFI_DOCTOR_FORM);
				modelAndView.addObject("phfiDoctorFormRequest", phfiDoctorFormRequest);
				modelAndView.addObject(PHFIWebConstant.ERROR,phfiResponse.getResponseMessage());
			}
		} catch (Exception e) {
			logger.error("Error ::RegistrationController:: processRegistrationCreate method");
			modelAndView.setViewName(INVALID_PAGE);
		}
		logger.error("Exiting ::RegistrationController:: processRegistrationCreate method");
	    return modelAndView;
	    
	}
	
	
}
