package com.smh.controller;

import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.smh.constants.PhfiErrorCodes;
import com.smh.constants.PHFIWebConstant;
import com.smh.constants.Constant;
import com.smh.constants.URLMappingConstants;
import com.smh.exception.SmhAdminException;
import com.smh.model.LoginRequest;
import com.smh.model.LoginResponse;
import com.smh.model.LoginSessionDetailsRequest;
import com.smh.model.LoginSessionDetailsResponse;
import com.smh.service.LoginSevice;
import com.smh.util.EncryptionUtil;
import com.smh.util.Properties;
import com.smh.util.StringUtil;

@SuppressWarnings({ "unchecked", "rawtypes" })
@Controller
public class LoginController implements URLMappingConstants {

	@Autowired
	private LoginSevice loginSevice;

	@Autowired
	LoginValidator loginValidator;

	@Autowired
	private SessionRegistryImpl sessionRegistry;

	private static Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(value = CHATAK_ADMIN_LOGIN, method = RequestMethod.GET)
	public ModelAndView showLogin(Map model, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView(CHATAK_ADMIN_LOGIN);
		logger.info("Entering :: LoginController :: showLogin method");
		modelAndView.addObject(PHFIWebConstant.ERROR, null);
		modelAndView.addObject("login", new LoginRequest());
		logger.info("Exiting :: LoginController :: showLogin method");
		return modelAndView;
	}

	@RequestMapping(value = CHATAK_ADMIN_AUTHENTICATE, method = RequestMethod.POST)
	public ModelAndView authenticate(HttpServletRequest request,
			HttpServletResponse response, HttpSession httpSession,
			LoginRequest loginRequest, BindingResult bindingResult, Map model) {
		ModelAndView modelAndView = new ModelAndView(CHATAK_ADMIN_LOGIN);
		logger.info("Entering :: LoginController :: authenticate method");
		modelAndView.addObject(PHFIWebConstant.ERROR, null);
		modelAndView.addObject(PHFIWebConstant.SUCCESS, null);
		String userAgent = request.getHeader("user-agent");
		LoginResponse loginResponse = null;
		try {
			httpSession.setAttribute(PHFIWebConstant.ERROR, null);
			model.put("email", (!StringUtil.isNullEmpty(loginRequest.getSpUser())) ? loginRequest.getSpUser() : "");
			loginValidator.validate(loginRequest, bindingResult);

			if (bindingResult.hasErrors()) {
				getError(bindingResult, modelAndView);
				return modelAndView;
			}
			if (null != userAgent) {
				userAgent = userAgent.replaceAll("\\ ", "");
			}
			loginResponse = loginSevice.getUser(loginRequest);

			if (loginResponse == null)
				throw new SmhAdminException(Properties.getProperty("chatak.admin.login.error.message"));

			if (loginResponse.getResponseCode() != null) {
				if (loginResponse.getResponseCode().equals(PhfiErrorCodes.USR_REQUESTED_FOR_PWD_CHANGE)) {
					httpSession.setAttribute(URLMappingConstants.CHATAK_ADMIN_USER_NAME, loginRequest.getSpUser());
					modelAndView.setViewName(CHATAK_BEACON_CHANGE_PASSWORD);
					return modelAndView;
				}
				if (loginResponse.getResponseCode().equals(PhfiErrorCodes.RESET_PASSWORD)) {
					httpSession.setAttribute(URLMappingConstants.CHATAK_ADMIN_USER_NAME, loginRequest.getSpUser());
					modelAndView.setViewName(BEACON_ADMIN_RESET_PASSWORD);
					return modelAndView;
				}
			}

			httpSession.setAttribute("loginUser", loginResponse.getUserName());
			// Get the login session details based on user id, login status
			// (Yes) and portal type
			String SESSION_DETAILS = PHFIWebConstant.LOGIN_SESSION_VALIDATE_FLAG;
			if (Boolean.valueOf(SESSION_DETAILS) == true) {
				if (loginResponse != null && loginResponse.getUserId() != null) {
					LoginSessionDetailsRequest loginSessionDetailsRequest = new LoginSessionDetailsRequest();
					loginSessionDetailsRequest.setLoginStatus(PHFIWebConstant.Yes);
					loginSessionDetailsRequest.setPortalType(PHFIWebConstant.Admin);
					loginSessionDetailsRequest.setUserId(loginResponse.getUserId());
					LoginSessionDetailsResponse loginSessionDetailsResponse = loginSevice.getLoginSessionDetails(loginSessionDetailsRequest);
					if (loginSessionDetailsResponse.getLoginSessionDetailsRequest() != null && loginSessionDetailsResponse.getLoginSessionDetailsRequest().size() > 0) {
						modelAndView = new ModelAndView(INVALID_ACCESS_PAGE);
						return modelAndView;
					}
				}
			}
			if (loginResponse.getResponseCode().equals(PhfiErrorCodes.PHFI_SUCCESS)) {

				// Getting the Current Browser Name and saving it to DB
				// Log the user session details onto Login Session details table
				if (!StringUtil.isNull(loginResponse) && !StringUtil.isNull(loginResponse.getStatus()) && loginResponse.getStatus()) {
					String userAgentValue = userAgent;
					String agent = userAgentValue.toLowerCase();
					String browserName = null;
					if (agent.contains("msie")) {
						String substring = userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
						browserName = substring.split(" ")[0].replace("MSIE", "IE") + "-" + substring.split(" ")[0];
					} else if (agent.contains("safari") && agent.contains("version")) {
						browserName = (userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0] + "-" + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
					} else if (agent.contains("opr") || agent.contains("opera")) {
						if (agent.contains("opera"))
							browserName = (userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0] + "-" + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
						else if (agent.contains("opr"))
							browserName = ((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-")).replace("OPR", "Opera");
					} else if (agent.contains("chrome")) {
						browserName = (userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
					} else if ((agent.indexOf("mozilla/7.0") > -1)
							|| (agent.indexOf("netscape6") != -1)
							|| (agent.indexOf("mozilla/4.7") != -1)
							|| (agent.indexOf("mozilla/4.78") != -1)
							|| (agent.indexOf("mozilla/4.08") != -1)
							|| (agent.indexOf("mozilla/3") != -1)) {
						browserName = "Netscape-?";
					} else if (agent.contains("firefox")) {
						browserName = (userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
					} else if (agent.contains("rv")) {
						browserName = "IE";
					} else {
						browserName = "UnKnown, More-Info: " + userAgent;
					}
					String ipAddr = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRemoteAddr();
					LoginSessionDetailsRequest loginSessionDetailsRequest = new LoginSessionDetailsRequest();
					// /saving login user details in Database
					loginSessionDetailsRequest.setLoginStatus(PHFIWebConstant.Yes);
					loginSessionDetailsRequest.setLoginTime(new Timestamp(System.currentTimeMillis()));
					loginSessionDetailsRequest.setLastActivityTime(new Timestamp(System.currentTimeMillis()));
					loginSessionDetailsRequest.setPortalType(PHFIWebConstant.Admin);
					loginSessionDetailsRequest.setSessionId(httpSession.getId());
					loginSessionDetailsRequest.setUserName(loginResponse.getEmail());
					loginSessionDetailsRequest.setUserId(loginResponse.getUserId());
					loginSessionDetailsRequest.setIpAddress(ipAddr);
					loginSessionDetailsRequest.setBrowserType(browserName);
					loginSevice.saveLoginSessionDetails(loginSessionDetailsRequest);
				}
				// Widget page data loading
				modelAndView.setViewName(CHATAK_ADMIN_DASHBOARD);
				httpSession.setAttribute(PHFIWebConstant.LOING_USER_ID, loginResponse.getUserId());
				httpSession.setAttribute("loginResponse", loginResponse);
				httpSession.setAttribute(URLMappingConstants.CHATAK_ADMIN_USER_NAME, loginRequest.getSpUser());
				
				   
			       String existingFeatures = "";
			        for(Long feature : loginResponse.getExistingFeature()) {
			            existingFeatures += "|" + feature ;
			          }
			        existingFeatures+="|";
			        httpSession.setAttribute(Constant.EXISTING_FEATURES, existingFeatures);
			        httpSession.setAttribute(Constant.EXISTING_FEATURE_DATA, loginResponse.getExistingFeature());
				
				
				
				String encUName = EncryptionUtil.encrypt(loginRequest.getSpUser());
				Cookie myCookie = new Cookie(PHFIWebConstant.COOKIE_CHATAK_NAME, encUName + httpSession.getId());
				myCookie.setMaxAge(20 * 60);
				response.addCookie(myCookie);
				loginRequest.setjSession(userAgent + encUName + httpSession.getId());

				httpSession.setAttribute("loginResponse", loginResponse);
				model.put("loginresponse", loginResponse);
				modelAndView.setViewName(CHATAK_ADMIN_DASHBOARD);
			} else {
				modelAndView.addObject("login", new LoginRequest());
				modelAndView.addObject(PHFIWebConstant.ERROR, Properties.getProperty("login.user.not.found"));
			}
		} catch (Exception e) {
			logger.error("Error :: LoginController :: authenticate method", e);
			modelAndView.addObject(PHFIWebConstant.ERROR, Properties.getProperty("login.user.not.found"));
		}
		logger.info("Exiting :: LoginController :: authenticate method");
		return modelAndView;
	}

	@RequestMapping(value = CHATAK_ADMIN_LOG_OUT, method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session, Map model) {
		logger.info("Entering :: LoginController :: logout method");
		ModelAndView modelAndView = new ModelAndView(CHATAK_ADMIN_LOG_OUT);
		LoginRequest loginRequest = new LoginRequest();
		model.put("login", loginRequest);
		try {
			Long userId = (session.getAttribute(PHFIWebConstant.LOING_USER_ID) == null ? null : (Long) session.getAttribute(PHFIWebConstant.LOING_USER_ID));
			if (userId != null) {
				LoginSessionDetailsRequest loginSessionDetailsRequest = new LoginSessionDetailsRequest();
				loginSessionDetailsRequest.setLoginStatus(PHFIWebConstant.Yes);
				loginSessionDetailsRequest.setPortalType(PHFIWebConstant.Admin);
				loginSessionDetailsRequest.setSessionId(session.getId());
				loginSessionDetailsRequest.setUserId(userId);
				LoginSessionDetailsResponse loginSessionDetailsResponse = loginSevice.getLoginSessionDetails(loginSessionDetailsRequest);
				if (loginSessionDetailsResponse != null && StringUtil.isListNotNullNEmpty(loginSessionDetailsResponse.getLoginSessionDetailsRequest())) {
					LoginSessionDetailsRequest loginSessionRequestData = loginSessionDetailsResponse.getLoginSessionDetailsRequest().get(0);
					loginSessionRequestData.setLogoutTime(new Timestamp(System.currentTimeMillis()));
					loginSessionRequestData.setLastActivityTime(new Timestamp(System.currentTimeMillis()));
					loginSessionRequestData.setLoginStatus(PHFIWebConstant.No);
					loginSevice.updateLoginSessionDetails(loginSessionRequestData);
				}
			}
		} catch (Exception e) {
			logger.error("ERROR:: LoginController:: logOut method", e);
		}

		try {
			String userAgent = request.getHeader("user-agent");
			if (null != userAgent) {
				userAgent = userAgent.replaceAll("\\ ", "");
			}
			String encUName = EncryptionUtil.encrypt((String) session.getAttribute(PHFIWebConstant.Admin));
			sessionRegistry.removeSessionInformation(encUName);
			String cookieValue = StringUtil.getCookieValue(request);
			sessionRegistry.removeSessionInformation(cookieValue);
			Cookie myCookie = new Cookie(PHFIWebConstant.COOKIE_CHATAK_NAME, null);
			myCookie.setMaxAge(0);
			response.addCookie(myCookie);
		} catch (Exception e) {
			logger.error("ERROR:: LoginController:: logOut method", e);
		}
		logger.info("Exiting:: LoginController:: logOut method");
		return modelAndView;
	}

	@RequestMapping(value = CHATAK_ADMIN_DASHBOARD, method = RequestMethod.GET)
	public ModelAndView showDashBoard(HttpServletRequest request, HttpServletResponse response) {
		logger.info("Entering :: LoginController :: showDashboard method");
		ModelAndView modelAndView = new ModelAndView(CHATAK_ADMIN_DASHBOARD);
		modelAndView.addObject(PHFIWebConstant.ERROR, null);
		modelAndView.addObject(PHFIWebConstant.SUCCESS, null);
		logger.info("Exiting :: LoginController :: showDashboard method");
		return modelAndView;

	}

	@RequestMapping(value = CHATAK_INVALID_SESSION, method = RequestMethod.GET)
	public ModelAndView showInvalidSessionError(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		logger.info("Entering:: LoginController:: invalidSession method");
		ModelAndView modelAndView = new ModelAndView(CHATAK_INVALID_SESSION);
		modelAndView.addObject(PHFIWebConstant.ERROR, null);
		try {
			String cookieValue = StringUtil.getCookieValue(request);
			sessionRegistry.removeSessionInformation(cookieValue);
			Cookie myCookie = new Cookie(PHFIWebConstant.CHATAK_INVALID_SESSION, null);
			myCookie.setMaxAge(0);
			response.addCookie(myCookie);
			session.invalidate();
		} catch (Exception e) {
			logger.error("ERROR:: LoginController:: invalidSession method", e);
		}
		logger.info("Exiting:: LoginController:: invalidSession method");
		return modelAndView;
	}

	@RequestMapping(value = CHATAK_INVALID_ACCESS, method = RequestMethod.GET)
	public ModelAndView invalidAccess(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		logger.info("Entering:: LoginController:: invalidAccess method");
		ModelAndView modelAndView = new ModelAndView(CHATAK_INVALID_ACCESS);
		logger.info("Exiting:: LoginController:: invalidAccess method");
		return modelAndView;
	}

	private ModelAndView getError(BindingResult results, ModelAndView modelAndView) {
		logger.info("Entering:: LoginController:: getError method");
		if (results.hasErrors()) {
			for (Object object : results.getAllErrors()) {
				if (object instanceof FieldError) {
					FieldError fieldError = (FieldError) object;
					modelAndView.addObject(fieldError.getField() + "Value", fieldError.getCode());
				}
			}
		}
		logger.info("Exiting:: LoginController:: getError method");
		return modelAndView;
	}
}
