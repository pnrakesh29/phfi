package com.smh.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.smh.dao.model.State;
import com.smh.model.CountryRequest;
import com.smh.model.StateRequest;

/**
*
* << Add Comments Here >>
*
* @author Shekhar Prasad
* @date 21-Dec-2015 10:46:11 AM
* @version 1.0
*/
public interface CountryDao {

	public List<CountryRequest> findAllCountries() throws DataAccessException;

	public List<StateRequest> findAllStates(String status) throws DataAccessException;

	public CountryRequest findCountryByID(Long countryId) throws DataAccessException;

	public StateRequest findStateByID(Long StateId) throws DataAccessException;

	public CountryRequest getCountryByName(String country) throws DataAccessException;

	public List<State> getStateByCountryId(Long id);

}
