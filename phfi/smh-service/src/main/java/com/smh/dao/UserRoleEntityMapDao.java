package com.smh.dao;

import org.springframework.dao.DataAccessException;

import com.smh.dao.model.UserRoleEntityMap;

/**
*
* << Add Comments Here >>
*
* @author Shekhar Prasad
* @date 21-Dec-2015 10:46:11 AM
* @version 1.0
*/
public interface UserRoleEntityMapDao {
	
	 public UserRoleEntityMap findByUserRoleId(Long userRoleId) throws DataAccessException,Exception;

}
