package com.smh.dao.impl;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mysema.query.Tuple;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.expr.BooleanExpression;
import com.smh.dao.BeaconFeatureDao;
import com.smh.dao.model.BeaconFeature;
import com.smh.dao.model.QBeaconFeature;
import com.smh.dao.model.QUserRoleFeatureMap;
import com.smh.model.PHFIFeatureRequest;

/**
*
* << Add Comments Here >>
*
* @author Shekhar Prasad
* @date 21-Dec-2015 10:46:11 AM
* @version 1.0
*/

@Repository("beaconFeatureDao")
public class BeaconFeatureDaoImpl implements BeaconFeatureDao {

	@PersistenceContext
	  private EntityManager entityManager;
	
	
	@Override
	public List<BeaconFeature> getFeatureList(String status)throws DataAccessException {
		JPAQuery query = new JPAQuery(entityManager);
		QBeaconFeature qbeaconFeature = QBeaconFeature.beaconFeature;
		List<BeaconFeature> userList = query.from(qbeaconFeature)
										.where(isStatus(status))
										.orderBy(orderByFeatureLevelDesc())
										.list(qbeaconFeature);
		return (userList);
	}

	private BooleanExpression isStatus(String status) {
		return (status != null && !"".equals(status))?  QBeaconFeature.beaconFeature.status.eq(status)	: null;
	}
	
	
	@Override
	public List<Long> getFeatureDataOnRoleIdData(Long roleId)
			throws DataAccessException {
		JPAQuery query = new JPAQuery(entityManager);
		QBeaconFeature qbeaconFeature = QBeaconFeature.beaconFeature;
		QUserRoleFeatureMap qUserRoleFeatureMap = QUserRoleFeatureMap.userRoleFeatureMap;
		List<Long> userList = query.from(qUserRoleFeatureMap,qbeaconFeature)
									.where(isRoleId(roleId),
									QBeaconFeature.beaconFeature.featureId.eq(QUserRoleFeatureMap.userRoleFeatureMap.featureId))
									.list(qUserRoleFeatureMap.featureId);
		return userList;
	}

	private BooleanExpression isRoleId(Long roleId){
		return roleId != null ? QUserRoleFeatureMap.userRoleFeatureMap.roleId.eq(roleId) : null;
	}
	
	@Override
	public List<PHFIFeatureRequest> getFeatureOnRoleLevel(String roleLevel,String status) throws DataAccessException {
		JPAQuery query = new JPAQuery(entityManager);
		List<PHFIFeatureRequest> featureList = new ArrayList<PHFIFeatureRequest>();
		List<Tuple> dataList = query.from(QBeaconFeature.beaconFeature)
											.where(isStatus(status),
											 isRoleLevel(roleLevel))
											.orderBy(orderByFeatureIDDesc())
											.list(QBeaconFeature.beaconFeature.featureId,
													QBeaconFeature.beaconFeature.featureLevel,
													QBeaconFeature.beaconFeature.name,
													QBeaconFeature.beaconFeature.refFeatureId,
													QBeaconFeature.beaconFeature.roleType,
													QBeaconFeature.beaconFeature.status);
		PHFIFeatureRequest beaconFeatureDto = null;
		for (Tuple data : dataList) {
			beaconFeatureDto = new PHFIFeatureRequest();
			beaconFeatureDto.setFeatureId(data.get(QBeaconFeature.beaconFeature.featureId));
			beaconFeatureDto.setFeatureLevel(data.get(QBeaconFeature.beaconFeature.featureLevel));
			beaconFeatureDto.setName(data.get(QBeaconFeature.beaconFeature.name));
			beaconFeatureDto.setRefFeatureId(data.get(QBeaconFeature.beaconFeature.refFeatureId));
			beaconFeatureDto.setStatus(data.get(QBeaconFeature.beaconFeature.status));
			
			
			featureList.add(beaconFeatureDto);
		}
		return featureList;
	}
	
	private OrderSpecifier<Long> orderByFeatureIDDesc() {
		return QBeaconFeature.beaconFeature.featureId.asc();
	}
	
	private OrderSpecifier<Long> orderByFeatureLevelDesc() {
		return QBeaconFeature.beaconFeature.featureLevel.asc();
	}
	
	private BooleanExpression isRoleLevel(String roleLevel) {
		return (roleLevel != null && !"".equals(roleLevel))? QBeaconFeature.beaconFeature.roleType.eq(roleLevel)	: null;
	}

}
