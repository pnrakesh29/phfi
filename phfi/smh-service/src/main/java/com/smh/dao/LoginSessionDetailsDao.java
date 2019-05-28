package com.smh.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.smh.dao.model.LoginSessionDetails;
import com.smh.model.LoginSessionDetailsRequest;

/**
*
* << Add Comments Here >>
*
* @author Shekhar Prasad
* @date 21-Dec-2015 10:46:11 AM
* @version 1.0
*/
public interface LoginSessionDetailsDao {

	public LoginSessionDetails saveOrUpdateSessionDetails(LoginSessionDetails sessionDetails)  throws DataAccessException;
	
	public List<LoginSessionDetailsRequest> searchLoginSessionDetails(LoginSessionDetailsRequest loginSessionDetails) throws InstantiationException, IllegalAccessException;
	
	public Boolean updateLoginSessionDetails() throws DataAccessException;
	
	public void loginSessionDetailsExpiry(Long expiryMinutes) throws DataAccessException;
	
	public String getSessionId(LoginSessionDetailsRequest loginSessionDetails) throws DataAccessException, Exception;
}
