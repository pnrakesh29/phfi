/**
 * 
 */
package com.smh.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.smh.constants.Constant;
import com.smh.exception.SmhAdminException;
import com.smh.util.EncryptionUtil;
import com.smh.util.StringUtil;


@ControllerAdvice
public class BaseController {
	
	 @Autowired
	  private SessionRegistryImpl sessionRegistry;
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	protected ModelAndView handleHttpRequestMethodNotSupported(
            HttpServletRequest request,HttpSession session,
            HttpServletResponse response,Exception e
            )
     throws Exception{
		ModelAndView modelAndView = new ModelAndView(com.smh.constants.URLMappingConstants.CHATAK_INVALID_ACCESS);
		 String encUName = EncryptionUtil.encrypt((String) session.getAttribute(com.smh.constants.URLMappingConstants.CHATAK_ADMIN_USER_NAME));
	        sessionRegistry.removeSessionInformation(encUName);
	        String cookieValue = StringUtil.getCookieValue(request);
	        sessionRegistry.removeSessionInformation(cookieValue);
	        Cookie myCookie = new Cookie(Constant.COOKIE_BEACON_NAME, null);
	        myCookie.setMaxAge(0);
	        response.addCookie(myCookie);
		   session.invalidate();
		return modelAndView;
		
	}

	public void checkInvalidRequest(HttpServletRequest request,
			HttpSession session, HttpServletResponse respone,
			ModelAndView modelAndView) throws SmhAdminException  {

		if (request.getHeader("referer") == null) {
			session.invalidate();
			throw new SmhAdminException("invalid-access");
		}
	}

}
