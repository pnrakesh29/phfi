package com.smh.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smh.constants.URLMappingConstants;
import com.smh.model.Response;
import com.smh.service.UtilityService;
import com.smh.util.JsonUtil;

@Controller
@SuppressWarnings("rawtypes")
public class UtilityController implements URLMappingConstants {

	@Autowired
	private UtilityService utilityService;

	@RequestMapping(value = CHATAK_ADMIN_GET_STATES_BY_COUNTRY, method = RequestMethod.GET)
	public @ResponseBody
	String getStatesById(Map model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		String country = request.getParameter("country");
		try {
			Response stateResponse = utilityService.getStatesByCountry(country);
			if (stateResponse != null) {
				return JsonUtil.convertObjectToJSON(stateResponse);
			}
		} catch (Exception e) {
		}
		return null;
	}
}
