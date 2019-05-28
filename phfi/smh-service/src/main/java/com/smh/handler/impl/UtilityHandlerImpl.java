package com.smh.handler.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smh.constants.PhfiErrorCodes;
import com.smh.dao.CountryDao;
import com.smh.dao.model.State;
import com.smh.handler.UtilityHandler;
import com.smh.model.CountryRequest;
import com.smh.model.Option;
import com.smh.model.Response;
import com.smh.rest.service.impl.RestUtilityServiceImpl;
import com.smh.util.Properties;
import com.smh.util.StringUtil;

@Service("utilityHandler")
public class UtilityHandlerImpl implements UtilityHandler {

	private static Logger logger = Logger.getLogger(RestUtilityServiceImpl.class);
	
	@Autowired
	private CountryDao countryDao;
	
	@Override
	  public Response getStatesByCountry(String countryName) {
	    Response response = new Response();
	    logger.info("Entering :: UtilityHandlerImpl :: getStatesByCountry method");
	    try {
	      CountryRequest countryRequest = countryDao.getCountryByName(countryName);
	      if(countryRequest.getName() != null) {

	        List<State> states = countryDao.getStateByCountryId(countryRequest.getId());

	        List<Option> options = new ArrayList<Option>(states.size());
	        for(State state : states) {
	          Option option = new Option();
	          option.setLabel(state.getName());
	          option.setValue(state.getName());
	          options.add(option);
	        }
	        Collections.sort(options, ALPHABETICAL_ORDER);
	        response.setResponseList(options);
	        response.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
			response.setResponseMessage(Properties.getProperty(response.getResponseCode()));

	      }
	      else {
	    	  response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
	      	  response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
	      }
	    }
	    catch(Exception e) {
	      logger.error("Error :: UtilityHandlerImpl :: getStatesByCountry method", e);
	      response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
      	  response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
	    }
	    logger.info("Exiting :: UtilityHandlerImpl :: getStatesByCountry method");
	    return response;
	  }

	 @Override
	  public Response getCountries() {
	    Response response = new Response();
	    logger.info("Entering :: UtilityHandlerImpl :: getCountries method");
	    try {
	      List<CountryRequest> countryRequests = countryDao.findAllCountries();
	      if(StringUtil.isListNotNullNEmpty(countryRequests)) {
	        List<Option> options = new ArrayList<Option>();
	        if(countryRequests != null) {
	          for(CountryRequest countryRequest : countryRequests) {
	            Option option = new Option();
	            option.setLabel(countryRequest.getName());
	            option.setValue(countryRequest.getName());
	            options.add(option);
	          }
	        }
	        Collections.sort(options, ALPHABETICAL_ORDER);
	        response.setResponseList(options);
	        response.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
			response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
	      }
	      else {
	    	  response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
	      	  response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
	      }

	    }
	    catch(Exception e) {
	      logger.error("Error :: UtilityHandlerImpl :: getCountries method", e);
	      response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
      	  response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
	    }
	    logger.info("Exiting :: UtilityHandlerImpl :: getCountries method");
	    return response;
	  }

	  /**
	   * Comparator method for option class
	   */
	  private static Comparator<Option> ALPHABETICAL_ORDER = new Comparator<Option>() {
	    public int compare(Option str1, Option str2) {
	      int res = String.CASE_INSENSITIVE_ORDER.compare(str1.getValue(), str2.getValue());
	      if(res == 0) {
	        res = str1.getValue().compareTo(str2.getValue());
	      }
	      return res;
	    }
	  };
	  
}
