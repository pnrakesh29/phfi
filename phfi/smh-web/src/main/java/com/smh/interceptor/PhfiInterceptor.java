package com.smh.interceptor;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.smh.constants.PHFIWebConstant;
import com.smh.constants.URLMappingConstants;
import com.smh.enums.PathUrlEnum;
import com.smh.model.LoginRequest;
import com.smh.model.LoginSessionDetailsRequest;
import com.smh.model.LoginSessionDetailsResponse;
import com.smh.service.LoginSevice;
import com.smh.util.EncryptionUtil;
import com.smh.util.Properties;
import com.smh.util.StringUtil;

public class PhfiInterceptor extends HandlerInterceptorAdapter implements Serializable {

	@Autowired
	private SessionRegistryImpl sessionRegistry;

	@Autowired
	private LoginSevice loginSevice;

	/**
	 * 
	 */
	private static final long serialVersionUID = 4179489360588625613L;

	public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, java.lang.Object object) throws java.lang.Exception {
		boolean isDone = true;
		if (handleRefresh(request, object)) {
			response.sendRedirect(request.getContextPath() + PHFIWebConstant.URL_SPERATOR + URLMappingConstants.CHATAK_INVALID_ACCESS);
			return true;
		}
		if (null != request) {
			isDone = isValidRequest(request.getRequestURI(), request);
			if (isDone) {
				// DO nothing
			} else {
				final HttpSession session = request.getSession(false);
				if (null != session) {
					isDone = checkUserRegistry(request, response, session);
				}
				if (!isDone) {
					response.sendRedirect(request.getContextPath() + PHFIWebConstant.URL_SPERATOR + URLMappingConstants.CHATAK_INVALID_ACCESS);
				}
			}
		}
		return isDone;
	}

	private boolean isValidRequest(final String requestURI, javax.servlet.http.HttpServletRequest request) {
		boolean isDone = false;
		if (StringUtil.isNullAndEmpty(requestURI)) {
			isDone = true;
		} else if (requestURI.contains(URLMappingConstants.CHATAK_ADMIN_LOGIN)
				|| requestURI.contains(URLMappingConstants.CHATAK_INVALID_SESSION)
				|| requestURI.contains(URLMappingConstants.CHATAK_INVALID_ACCESS)
				|| requestURI.contains(URLMappingConstants.CHATAK_ADMIN_AUTHENTICATE)
				|| requestURI.contains(URLMappingConstants.CHATAK_ADMIN_LOG_OUT)
				|| requestURI.contains(URLMappingConstants.BEACON_FORGOT_PASSWORD)
				|| requestURI.contains(URLMappingConstants.PROCESS_BEACON_FORGOT_PASSWORD)
				|| requestURI.contains(URLMappingConstants.BEACON_SECURITY_QUESTION)
				|| requestURI.contains(URLMappingConstants.BEACON_CHANGE_PASSWORD)
				|| requestURI.contains(URLMappingConstants.PROCESS_BEACON_CHANGE_PASSWORD)) {
			isDone = true;
		}
		return isDone;
	}

	private boolean handleRefresh(HttpServletRequest request, Object object) {
		if (!StringUtil.isNullAndEmpty(request.getMethod()) && "GET".equalsIgnoreCase(request.getMethod())) {
			try {
				for (PathUrlEnum paths : PathUrlEnum.values()) {
					if (request.getPathInfo().equalsIgnoreCase(paths.getUrl())) {
						HttpSession session = request.getSession();
						LoginSessionDetailsRequest loginSessionDetailsRequest = new LoginSessionDetailsRequest();
						Long userId = (session.getAttribute(PHFIWebConstant.LOING_USER_ID) == null ? null : (Long) session.getAttribute(PHFIWebConstant.LOING_USER_ID));
						if (userId != null) {
							loginSessionDetailsRequest.setUserId(userId);
							loginSessionDetailsRequest.setLoginStatus(PHFIWebConstant.Yes);
							loginSessionDetailsRequest.setSessionId(session.getId());
							loginSessionDetailsRequest.setPortalType(PHFIWebConstant.Admin);
							LoginSessionDetailsResponse loginSessionDetailsResponse = loginSevice.getLoginSessionDetails(loginSessionDetailsRequest);
							if (loginSessionDetailsResponse != null && StringUtil.isListNotNullNEmpty(loginSessionDetailsResponse.getLoginSessionDetailsRequest())) {
								LoginSessionDetailsRequest loginSessionRequestData = loginSessionDetailsResponse.getLoginSessionDetailsRequest().get(0);
								loginSessionRequestData.setLastActivityTime(new Timestamp(System.currentTimeMillis()));
								loginSessionRequestData.setLogoutTime(new Timestamp(System.currentTimeMillis()));
								loginSessionRequestData.setLoginStatus(PHFIWebConstant.No);
								loginSevice.updateLoginSessionDetails(loginSessionRequestData);
							}
						}
						return true;
					}
				}
			} catch (Exception e) {

			}
		}
		return false;
	}

	private boolean checkUserRegistry(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, HttpSession session) throws Exception {

		String userName = (String) session.getAttribute(URLMappingConstants.CHATAK_ADMIN_USER_NAME);
		if (!StringUtil.isNullAndEmpty(userName)) {
			String userAgent = request.getHeader("user-agent");
			if (null != userAgent) {
				userAgent = userAgent.replaceAll("\\ ", "");
			}
			String encUName = EncryptionUtil.encrypt(userName);

			for (Object object : sessionRegistry.getAllPrincipals()) {
				LoginRequest loginResponseData = (LoginRequest) object;
				if (null != loginResponseData && loginResponseData.getSpUser().trim().equals(userName)) {

					Cookie[] cookies = request.getCookies();
					String cookieValue = "";
					for (Cookie cookie : cookies) {
						if (PHFIWebConstant.COOKIE_CHATAK_NAME.equalsIgnoreCase(cookie.getName())) {
							cookieValue = cookie.getValue();
							// Resetting Logged in user encrypted data into
							// Cookie
							cookie.setMaxAge(30 * 60);
							response.addCookie(cookie);
							break;
						}
					}
					SessionInformation sessionInformation = sessionRegistry.getSessionInformation(encUName);
					if (null == sessionInformation) {
						return false;
					} else {
						sessionInformation.refreshLastRequest();
						if (!loginResponseData.getjSession().equals(userAgent + cookieValue)) {
							Date lastSessionRequestDate = sessionInformation.getLastRequest();
							Date lastRequestDate = new Date(lastSessionRequestDate.getTime());
							lastRequestDate.setTime(lastRequestDate.getTime() + (Integer.parseInt(Properties.getProperty("chatak.admin.session.timeout")) * 60000));
							Date curDate = new Date();
							if (lastRequestDate.after(curDate)) {
								Cookie myCookie = new Cookie(PHFIWebConstant.COOKIE_CHATAK_NAME, null);
								myCookie.setMaxAge(0);
								response.addCookie(myCookie);
								sessionRegistry.removeSessionInformation(encUName);
								session.setAttribute(URLMappingConstants.CHATAK_ADMIN_USER_NAME, null);
								try {
									response.sendRedirect(request.getContextPath() + PHFIWebConstant.URL_SPERATOR + PHFIWebConstant.CHATAK_INVALID_SESSION);
								} catch (IOException e) {
								}
								return false;
							}
						}
						sessionInformation.refreshLastRequest();
					}
				}
			}
		} else {
			Cookie myCookie = new Cookie(PHFIWebConstant.COOKIE_CHATAK_NAME, null);
			myCookie.setMaxAge(0);
			response.addCookie(myCookie);
			return false;
		}
		return true;
	}

}
