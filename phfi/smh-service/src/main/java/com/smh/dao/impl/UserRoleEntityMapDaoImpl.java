package com.smh.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.smh.dao.UserRoleEntityMapDao;
import com.smh.dao.model.UserRoleEntityMap;
import com.smh.dao.repository.UserRoleEntityMapRepository;

/**
*
* << Add Comments Here >>
*
* @author Shekhar Prasad
* @date 21-Dec-2015 10:46:11 AM
* @version 1.0
*/

@Repository("userRoleEntityMapDao")
public class UserRoleEntityMapDaoImpl implements UserRoleEntityMapDao{
	
	@Autowired
	private UserRoleEntityMapRepository userRoleEntityMapRepository;
	
	@Override
	public UserRoleEntityMap findByUserRoleId(Long userRoleId) throws DataAccessException,Exception{
		 return userRoleEntityMapRepository.findByUserRoleId(userRoleId);
	}

}
