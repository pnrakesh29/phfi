package com.smh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.smh.dao.UserRoleFeatureMapDao;
import com.smh.dao.model.UserRoleFeatureMap;
import com.smh.dao.repository.UserRoleFeatureMapRepository;

/**
*
* << Add Comments Here >>
*
* @author Shekhar Prasad
* @date 21-Dec-2015 10:46:11 AM
* @version 1.0
*/

@Repository("UserRoleFeatureMapDao")
public class UserRoleFeatureMapDaoImpl implements UserRoleFeatureMapDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private UserRoleFeatureMapRepository userRoleFeatureMapRepository;
	
	
	@Override
	public UserRoleFeatureMap saveOrUpdateUserRoleFeatureMap(UserRoleFeatureMap featureMap) throws DataAccessException {
		return userRoleFeatureMapRepository.save(featureMap);
	}

	@Override
	public void deleteUserRoleFeatureMap(Long roleId)throws DataAccessException {
		
		List<UserRoleFeatureMap> featureMaps = userRoleFeatureMapRepository.findByRoleId(roleId);
	
		userRoleFeatureMapRepository.delete(featureMaps);
	}

}
