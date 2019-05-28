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
import org.springframework.web.servlet.ModelAndView;

import com.smh.constants.PhfiErrorCodes;
import com.smh.constants.PHFIWebConstant;
import com.smh.constants.URLMappingConstants;
import com.smh.model.AdminUserRequest;
import com.smh.model.AdminUserResponse;
import com.smh.model.ChangeAdminPasswordRequest;
import com.smh.model.Response;
import com.smh.service.AdminUserProfileService;
import com.smh.util.EncryptionUtil;
import com.smh.util.Properties;

@Controller
@SuppressWarnings({ "unchecked", "rawtypes" })
public class AdminUserProfileController implements URLMappingConstants {

	private static Logger logger = Logger.getLogger(AdminUserProfileController.class);

	@Autowired
	private AdminUserProfileService adminUserProfileService;

	@RequestMapping(value = CHATAK_ADMIN_USER_PROFILE, method = RequestMethod.GET)
	public ModelAndView showUserProfile(HttpServletRequest request, HttpServletResponse response, HttpSession session, Map model) {
		logger.info("Entering :: AdminUserController ::showEditAdminUser method ");
		ModelAndView modelAndView = new ModelAndView(CHATAK_ADMIN_USER_PROFILE);
		modelAndView.addObject(PHFIWebConstant.ERROR, null);
		modelAndView.addObject(PHFIWebConstant.SUCCESS, null);
		logger.info("Entering :: AdminUserController ::showUserProfile method ");
		AdminUserRequest adminUserRequest = new AdminUserRequest();
		AdminUserResponse adminUserResponse = null;
		Long adminUserId = (Long) session.getAttribute(PHFIWebConstant.LOING_USER_ID);
		try {
			adminUserResponse = (AdminUserResponse) adminUserProfileService.findByAdminUserId(adminUserId);
			if (adminUserResponse != null) {
				adminUserRequest = adminUserResponse.getAdminUserList().get(0);
				adminUserRequest.setSecurityAnswer((EncryptionUtil.decrypt(adminUserRequest.getSecurityAnswer())));
				modelAndView.addObject("adminUserRequest", adminUserRequest);
			}
			model.put("adminUserRequest", adminUserRequest);
		} catch (Exception e) {
			logger.error("Error ::AdminUserController:: showUserProfile method");
			modelAndView.setViewName(INVALID_PAGE);
		}
		logger.error("Exiting ::AdminUserController:: showUserProfile method");
		return modelAndView;
	}

	@RequestMapping(value = PROCESS_CHATAK_ADMIN_USER_PROFILE_EDIT, method = RequestMethod.POST)
	public ModelAndView updateUserProfile(HttpServletRequest request,
			HttpServletResponse response, AdminUserRequest adminUserRequest,
			BindingResult bindingResult, HttpSession session, Map model) {
		logger.info("Entering :: AdminUserController ::updateAdminUser method ");
		ModelAndView modelAndView = new ModelAndView(CHATAK_ADMIN_USER_PROFILE);
		modelAndView.addObject(PHFIWebConstant.ERROR, null);
		modelAndView.addObject(PHFIWebConstant.SUCCESS, null);
		try {
			adminUserRequest.setStatusChangeFlage(PHFIWebConstant.Yes);
			Response adminUserResponse = adminUserProfileService.updateUserProfile(adminUserRequest);
			if (adminUserResponse != null && adminUserResponse.getResponseCode().equals(PhfiErrorCodes.PHFI_SUCCESS)) {
				modelAndView.addObject(PHFIWebConstant.SUCCESS, Properties.getProperty("profile.edit.success"));
			} else {
				modelAndView = showUserProfile(request, response, session, model);
				modelAndView.addObject(PHFIWebConstant.ERROR, adminUserResponse.getResponseMessage());
			}
		} catch (Exception e) {
			logger.error("Error :: AdminUserController ::updateAdminUser method ", e);
			modelAndView.setViewName(INVALID_PAGE);
		}
		logger.info("Exiting :: AdminUserController ::updateAdminUser method ");
		return modelAndView;
	}

	@RequestMapping(value = CHATAK_ADMIN_USER_PROFILE_CHANGE_PASSWORD, method = RequestMethod.GET)
	public ModelAndView changePassword(HttpServletRequest request, HttpServletResponse response, Map model, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView(CHATAK_ADMIN_USER_PROFILE_CHANGE_PASSWORD);
		ChangeAdminPasswordRequest changeAdminPasswordRequest = new ChangeAdminPasswordRequest();
		AdminUserRequest adminUserRequest = new AdminUserRequest();
		session.setAttribute("userFlag", Boolean.TRUE);
		model.put("adminUserRequest", adminUserRequest);
		model.put("changeAdminPasswordRequest", changeAdminPasswordRequest);
		return modelAndView;
	}

	@RequestMapping(value = PROCESS_USER_PROFILE_CHANGE_PASSWORD, method = RequestMethod.POST)
	public ModelAndView processChangePassword(HttpServletRequest request, HttpServletResponse response, Map model, HttpSession session,
			ChangeAdminPasswordRequest changeAdminPasswordRequest, BindingResult bindingResult) {
		logger.info("Entering:: AdminProfileController:: submitChangePassword method");
		ModelAndView modelAndView = new ModelAndView(CHATAK_ADMIN_USER_PROFILE_CHANGE_PASSWORD);
		AdminUserRequest adminUserRequest = new AdminUserRequest();
		try {
			model.put("adminUserRequest", adminUserRequest);
			model.put("changeAdminPasswordRequest", changeAdminPasswordRequest);
			changeAdminPasswordRequest.setUserName((String) session.getAttribute(URLMappingConstants.CHATAK_ADMIN_USER_NAME));
			Response changePassResponse = adminUserProfileService.changePassword(changeAdminPasswordRequest);
			if (changePassResponse.getResponseCode().equals(PhfiErrorCodes.PWD_SHOULD_NOT_BE_SAME_AS_LAST_PWD)) {
				modelAndView.addObject(PHFIWebConstant.ERROR, changePassResponse.getResponseMessage());
			} else if (changePassResponse.getResponseCode().equals(PhfiErrorCodes.PASSWORD_SHOULD_NOT_BE_SAME)) {
				modelAndView.addObject(PHFIWebConstant.ERROR, changePassResponse.getResponseMessage());
			} else if (changePassResponse.getResponseCode().equals(PhfiErrorCodes.CURRENT_PWD_NOT_VALID)) {
				modelAndView.addObject(PHFIWebConstant.ERROR, changePassResponse.getResponseMessage());
			} else {
				modelAndView.addObject(PHFIWebConstant.SUCCESS, Properties.getProperty("chatak.adminuser.profile.change.password.message"));
			}
		} catch (Exception e) {
			logger.error("ERROR:: AdminProfileController:: submitChangePassword method", e);
		}
		logger.info("Exiting:: AdminProfileController:: submitChangePassword method");
		return modelAndView;
	}
}
