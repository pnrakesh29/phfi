package com.smh.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.smh.exception.BeaconServiceException;
/**
*
* << Add Comments Here >>
*
* @author Shekhar Prasad
* @date 21-Dec-2015 10:46:11 AM
* @version 1.0
*/

public interface RolesServiceProviderMappingDao {
	
  public Long addRoleServiceProvider(Long roleId,Long serviceProviderId,  Long subServiceProviderId, String status, String createdBy) throws DataAccessException,BeaconServiceException;

  public List<String> getServiceProviderOnRoleId(Long roleId) throws DataAccessException;

  public Long getServiceProvider(Long roleId) throws DataAccessException;

  public List<String> getSubServiceProviderOnRoleId(Long roleId) throws DataAccessException;

  public void deleteServiceProvidermappingData(Long roleId) throws DataAccessException;

  public List<String> getServiceProviderNameOnRoleId(Long roleId) throws DataAccessException;

  public List<String> getSubServiceProviderNameOnRoleId(Long roleId) throws DataAccessException;

  public Long getServiceProviderHistory(Long roleId, String action) throws DataAccessException;

  public List<String> getServiceProviderOnRoleIdHistory(Long roleId, String action) throws DataAccessException;

  public List<String> getSubServiceProviderOnRoleIdHistory(Long roleId, String action) throws DataAccessException;

}
