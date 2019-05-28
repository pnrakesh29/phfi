package com.smh.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.smh.dao.model.UserRole;
import com.smh.dao.model.UserRoleEntityMap;
import com.smh.model.UserRoleRequest;



/**
*
* << Add Comments Here >>
*
* @author Shekhar Prasad
* @date 21-Dec-2015 10:46:11 AM
* @version 1.0
*/

public interface UserRoleDao {
	
	public UserRole saveOrUpdateUserRole(UserRole userRole)  throws DataAccessException;
	
	public UserRoleEntityMap saveOrUpdateUserRoleEntityMap(UserRoleEntityMap userRoleEntityMap) throws DataAccessException;
	
	public List<UserRoleRequest> searchRoles(UserRoleRequest roleRequest) throws DataAccessException, Exception;
	
	public List<UserRoleRequest> getUserRolesByRoleTypes(UserRoleRequest userRoleRequest) throws DataAccessException, Exception;
	
    public UserRole findByUserRoleId(Long userRoleId) throws DataAccessException,Exception;
	
	public List<UserRole> findByRoleName(String name)throws DataAccessException,Exception; 
	
	public List<UserRoleRequest> getActiveRole(UserRoleRequest roleRequest)throws DataAccessException,Exception;
	
	
}
