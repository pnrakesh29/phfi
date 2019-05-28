package com.smh.dao;

import org.springframework.dao.DataAccessException;

import com.smh.dao.model.UserRoleFeatureMap;

/**
*
* << Add Comments Here >>
*
* @author Shekhar Prasad
* @date 21-Dec-2015 10:46:11 AM
* @version 1.0
*/
public interface UserRoleFeatureMapDao {

	public UserRoleFeatureMap saveOrUpdateUserRoleFeatureMap(UserRoleFeatureMap featureMap)  throws DataAccessException;
	
	public void deleteUserRoleFeatureMap(Long roleId)  throws DataAccessException;
	
	
}
