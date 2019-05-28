package com.smh.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.smh.dao.model.BeaconFeature;
import com.smh.model.PHFIFeatureRequest;


/**
*
* << Add Comments Here >>
*
* @author Shekhar Prasad
* @date 21-Dec-2015 10:46:11 AM
* @version 1.0
*/
public interface BeaconFeatureDao {

	public List<BeaconFeature> getFeatureList(String status) throws DataAccessException;
	
	public List<Long> getFeatureDataOnRoleIdData(Long roleId) throws DataAccessException;
	  
	public List<PHFIFeatureRequest> getFeatureOnRoleLevel(String roleLevel, String status) throws DataAccessException;
	
	

}
