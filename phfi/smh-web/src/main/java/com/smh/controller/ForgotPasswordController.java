package com.smh.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.smh.constants.PhfiErrorCodes;
import com.smh.constants.PHFIWebConstant;
import com.smh.constants.URLMappingConstants;
import com.smh.model.AdminForgotPasswordRequest;
import com.smh.model.ChangeAdminPasswordRequest;
import com.smh.model.Response;
import com.smh.model.SecurityQuestionRequest;
import com.smh.model.SecurityQuestionResponse;
import com.smh.service.ForgotPasswordService;
import com.smh.util.JsonUtil;
import com.smh.util.Properties;


@Controller
@SuppressWarnings({ "unchecked", "rawtypes" })
public class ForgotPasswordController implements URLMappingConstants {

	private static Logger logger = Logger.getLogger(ForgotPasswordController.class);

	@Autowired
	private ForgotPasswordService forgotPasswordService;

	@RequestMapping(value = BEACON_FORGOT_PASSWORD, method = RequestMethod.GET)
	public ModelAndView forgotPassword(HttpServletRequest request, HttpServletResponse response, Map model, HttpSession session) {
		logger.info("Entering:: ForgotPasswordController:: forgotPassword method");
		ModelAndView modelAndView = new ModelAndView(CHATAK_BEACON_FORGOT_PASSWORD);
		AdminForgotPasswordRequest adminForgotPasswordRequest = new AdminForgotPasswordRequest();
		model.put("adminForgotPasswordRequest", adminForgotPasswordRequest);
		return modelAndView;
	}

	@RequestMapping(value = PROCESS_BEACON_FORGOT_PASSWORD, method = RequestMethod.POST)
	public ModelAndView processForgotPassword(HttpServletRequest request, HttpServletResponse response, Map model, HttpSession session,
			AdminForgotPasswordRequest adminForgotPasswordRequest, BindingResult bindingResult) {
		logger.info("Entering:: ForgotPasswordController:: processForgotPassword method");
		ModelAndView modelAndView = new ModelAndView(CHATAK_BEACON_FORGOT_PASSWORD);
		try {
			model.put("adminForgotPasswordRequest", adminForgotPasswordRequest);
			Response forgotPassResponse = forgotPasswordService.forgotPassword(adminForgotPasswordRequest);
			if (forgotPassResponse.getResponseCode().equals(PhfiErrorCodes.SECURITY_QESTN_INVALD)) {
				modelAndView = new ModelAndView(CHATAK_BEACON_FORGOT_PASSWORD);
				modelAndView.addObject(PHFIWebConstant.ERROR, forgotPassResponse.getResponseMessage());
			} else if (forgotPassResponse.getResponseCode().equals(PhfiErrorCodes.INVALID_USER_NAME)) {
				modelAndView = new ModelAndView(CHATAK_BEACON_FORGOT_PASSWORD);
				modelAndView.addObject(PHFIWebConstant.ERROR, forgotPassResponse.getResponseMessage());
			} else {
				modelAndView = new ModelAndView(CHATAK_ADMIN_LOGIN);
				modelAndView.addObject(PHFIWebConstant.SUCCESS, Properties.getProperty("chatak.admin.user.forgot.password.message"));
			}
		} catch (Exception e) {
			logger.error("ERROR:: ForgotPasswordController:: processForgotPassword method", e);
		}
		logger.info("Exiting:: ForgotPasswordController:: processForgotPassword method");
		return modelAndView;
	}

	@RequestMapping(value = BEACON_SECURITY_QUESTION, method = RequestMethod.GET)
	public @ResponseBody
	String getSecurityQuestion(HttpServletRequest request, HttpServletResponse response, Map model, HttpSession session) {
		SecurityQuestionResponse securityQuestionResponse = null;
		SecurityQuestionRequest securityQuestionRequest = new SecurityQuestionRequest();
		securityQuestionRequest.setUserName(request.getParameter("userName"));
		String data = null;
		try {
			securityQuestionResponse = forgotPasswordService.getSecurityQuestion(securityQuestionRequest);
			data = JsonUtil.convertObjectToJSON(securityQuestionResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@RequestMapping(value = BEACON_CHANGE_PASSWORD, method = RequestMethod.GET)
	public ModelAndView changePassword(HttpServletRequest request, HttpServletResponse response, Map model, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView(CHATAK_BEACON_CHANGE_PASSWORD);
		ChangeAdminPasswordRequest changeAdminPasswordRequest = new ChangeAdminPasswordRequest();
		model.put("changeAdminPasswordRequest", changeAdminPasswordRequest);
		return modelAndView;
	}

	@RequestMapping(value = PROCESS_BEACON_CHANGE_PASSWORD, method = RequestMethod.POST)
	public ModelAndView processChangePassword(HttpServletRequest request, HttpServletResponse response, Map model, HttpSession session,
			ChangeAdminPasswordRequest changeAdminPasswordRequest, BindingResult bindingResult) {
		logger.info("Entering:: ForgotPasswordController:: submitChangePassword method");
		ModelAndView modelAndView = new ModelAndView(CHATAK_BEACON_CHANGE_PASSWORD);
		try {
			model.put("changeAdminPasswordRequest", changeAdminPasswordRequest);
			changeAdminPasswordRequest.setUserName((String) session.getAttribute(URLMappingConstants.CHATAK_ADMIN_USER_NAME));
			Response changePassResponse = forgotPasswordService.changePassword(changeAdminPasswordRequest);
			if (changePassResponse.getResponseCode().equals(PhfiErrorCodes.PWD_SHOULD_NOT_BE_SAME_AS_LAST_PWD)) {
				modelAndView = new ModelAndView(CHATAK_BEACON_CHANGE_PASSWORD);
				modelAndView.addObject(PHFIWebConstant.ERROR, changePassResponse.getResponseMessage());
			} else if (changePassResponse.getResponseCode().equals(PhfiErrorCodes.PASSWORD_SHOULD_NOT_BE_SAME)) {
				modelAndView = new ModelAndView(CHATAK_BEACON_CHANGE_PASSWORD);
				modelAndView.addObject(PHFIWebConstant.ERROR, changePassResponse.getResponseMessage());

			} else if (changePassResponse.getResponseCode().equals(PhfiErrorCodes.CURRENT_PWD_NOT_VALID)) {
				modelAndView = new ModelAndView(CHATAK_BEACON_CHANGE_PASSWORD);
				modelAndView.addObject(PHFIWebConstant.ERROR, changePassResponse.getResponseMessage());
			} else {
				modelAndView = new ModelAndView(CHATAK_ADMIN_LOGIN);
				modelAndView.addObject(PHFIWebConstant.SUCCESS, Properties.getProperty("chatak.admin.user.change.password.message"));
			}
		} catch (Exception e) {
			logger.error("ERROR:: ForgotPasswordController:: submitChangePassword method", e);
		}
		logger.info("Exiting:: ForgotPasswordController:: submitChangePassword method");
		return modelAndView;
	}
	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = ADMIN_RESET_PASSWORD, method = RequestMethod.GET)
	public ModelAndView resetPassword(HttpServletRequest request, HttpServletResponse response, Map model, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView(BEACON_ADMIN_RESET_PASSWORD);
		ChangeAdminPasswordRequest changeAdminPasswordRequest = new ChangeAdminPasswordRequest();
		model.put("changeAdminPasswordRequest", changeAdminPasswordRequest);
		return modelAndView;
	}
	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @param session
	 * @param changeAdminPasswordRequest
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = PROCESS_RESET_PASSWORD, method = RequestMethod.POST)
	public ModelAndView processResetPassword(HttpServletRequest request, HttpServletResponse response, Map model, HttpSession session, ChangeAdminPasswordRequest changeAdminPasswordRequest, BindingResult bindingResult) {
		logger.info("Entering:: AdminProfileController:: processResetPassword method");
		ModelAndView modelAndView=null;
		try {
			model.put("changeAdminPasswordRequest", changeAdminPasswordRequest);
			changeAdminPasswordRequest.setUserName((String)session.getAttribute(URLMappingConstants.CHATAK_ADMIN_USER_NAME));
			Response response2= forgotPasswordService.changePassword(changeAdminPasswordRequest);
			if(response2.getResponseCode().equals(PhfiErrorCodes.PWD_SHOULD_NOT_BE_SAME_AS_LAST_PWD)){
				modelAndView = new ModelAndView(BEACON_ADMIN_RESET_PASSWORD);
				modelAndView.addObject(PHFIWebConstant.ERROR, response2.getResponseMessage());
			} else if(response2.getResponseCode().equals(PhfiErrorCodes.PASSWORD_SHOULD_NOT_BE_SAME)){
				 modelAndView = new ModelAndView(BEACON_ADMIN_RESET_PASSWORD);
				modelAndView.addObject(PHFIWebConstant.ERROR, response2.getResponseMessage());
			}else if(response2.getResponseCode().equals(PhfiErrorCodes.CURRENT_PWD_NOT_VALID)){
				 modelAndView = new ModelAndView(BEACON_ADMIN_RESET_PASSWORD);
				modelAndView.addObject(PHFIWebConstant.ERROR, response2.getResponseMessage());
			} else {
				modelAndView = new ModelAndView(CHATAK_ADMIN_LOGIN);
				modelAndView.addObject(PHFIWebConstant.SUCCESS, Properties.getProperty("beacon.adminuser.change.password.message"));
			}
		} catch (Exception e) {
			logger.error( "ERROR:: AdminProfileController:: processResetPassword method", e);
		}
			logger.info("Exiting:: AdminProfileController:: processResetPassword method");
			return modelAndView;
	}
}
