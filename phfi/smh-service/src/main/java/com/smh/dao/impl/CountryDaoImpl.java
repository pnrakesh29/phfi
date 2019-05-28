package com.smh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.smh.dao.CountryDao;
import com.smh.dao.model.Country;
import com.smh.dao.model.State;
import com.smh.dao.repository.CountryRepository;
import com.smh.dao.repository.StateRepository;
import com.smh.model.CountryRequest;
import com.smh.model.StateRequest;
import com.smh.util.CommonUtil;
/**
*
* << Add Comments Here >>
*
* @author Shekhar Prasad
* @date 21-Dec-2015 10:46:11 AM
* @version 1.0
*/
@Repository("countryDao")
public class CountryDaoImpl implements CountryDao {

  private static Logger logger = Logger.getLogger(CountryDaoImpl.class);

  @Autowired
  private CountryRepository countryRepository;

  @Autowired
  private StateRepository stateRepository;

  /**
   * @return
   * @throws DataAccessException
   */
  @Override
  public List<CountryRequest> findAllCountries() throws DataAccessException {
    List<CountryRequest> list = new ArrayList<CountryRequest>();
    try {
      List<Country> countryList = countryRepository.findAll();
      list = CommonUtil.copyListBeanProperty(countryList, CountryRequest.class);
    }
    catch(Exception e) {
      logger.error("Error in retrieving the list of countries", e);
    }

    return list;
  }

  /**
   * @param status
   * @return
   * @throws DataAccessException
   */
  @Override
  public List<StateRequest> findAllStates(String status) throws DataAccessException {
    List<StateRequest> list = new ArrayList<StateRequest>();
    try {
      List<State> stateList = stateRepository.findByStatus(status);
      list = CommonUtil.copyListBeanProperty(stateList, StateRequest.class);
    }
    catch(Exception e) {
      logger.error("Error in retrieving the list of states for country id ", e);
    }

    return list;
  }

  /**
   * @param countryId
   * @return
   * @throws DataAccessException
   */
  @Override
  public CountryRequest findCountryByID(Long countryId) throws DataAccessException {
    CountryRequest countryRequest = null;
    try {
      List<Country> countryList = countryRepository.findById(countryId);
      if(countryList != null && !countryList.isEmpty()) {
        countryRequest = CommonUtil.copyBeanProperties(countryList.get(0), CountryRequest.class);
      }
    }
    catch(Exception e) {
      logger.error("Error in retrieving the country for country id " + countryId, e);
    }

    return countryRequest;
  }

  /**
   * @param stateId
   * @return
   * @throws DataAccessException
   */
  @Override
  public StateRequest findStateByID(Long stateId) throws DataAccessException {
    StateRequest stateRequest = null;
    try {
      List<State> stateList = stateRepository.findById(stateId);
      if(stateList != null && !stateList.isEmpty()) {
        stateRequest = CommonUtil.copyBeanProperties(stateList.get(0), StateRequest.class);
      }
    }
    catch(Exception e) {
      logger.error("Error in retrieving the state for state id " + stateId, e);
    }

    return stateRequest;
  }

  /**
   * @param country
   * @return
   * @throws DataAccessException
   */
  @Override
  public CountryRequest getCountryByName(String country) throws DataAccessException {
    Country country2 = countryRepository.findByName(country);
    CountryRequest countryRequest = new CountryRequest();
    if(country2 != null) {
      countryRequest.setId(country2.getId());
      countryRequest.setName(country2.getName());
    }
    return countryRequest;
  }

  /**
   * @param countryId
   * @return
   */
  @Override
  public List<State> getStateByCountryId(Long countryId) {
    return stateRepository.findByCountryId(countryId);
  }

}
