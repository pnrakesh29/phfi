package com.smh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.smh.constants.Constant;
import com.smh.dao.UserRoleDao;
import com.smh.dao.model.QUserRole;
import com.smh.dao.model.QUserRoleEntityMap;
import com.smh.dao.model.UserRole;
import com.smh.dao.model.UserRoleEntityMap;
import com.smh.dao.repository.UserRoleEntityMapRepository;
import com.smh.dao.repository.UserRoleRepository;
import com.smh.enums.RoleLevel;
import com.smh.exception.BeaconServiceException;
import com.smh.model.UserRoleRequest;
import com.smh.util.StringUtil;
import com.mysema.query.Tuple;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.expr.BooleanExpression;

/**
*
* << Add Comments Here >>
*
* @author Shekhar Prasad
* @date 21-Dec-2015 10:46:11 AM
* @version 1.0
*/

@Repository("userRoleDao")
public class UserRoleDaoImpl implements UserRoleDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	private UserRoleEntityMapRepository userRoleEntityMapRepository;
	
	@Override
	public UserRole saveOrUpdateUserRole(UserRole userRole) throws DataAccessException {
		return userRoleRepository.save(userRole);
	}
	
	@Override
	public UserRoleEntityMap saveOrUpdateUserRoleEntityMap(UserRoleEntityMap userRoleEntityMap) throws DataAccessException {
		return userRoleEntityMapRepository.save(userRoleEntityMap);
	}

	@Override
	public List<UserRoleRequest> searchRoles(UserRoleRequest roleRequest) throws Exception {
		List<UserRoleRequest> searchRoleRequestsList = new ArrayList<UserRoleRequest>();
		int offset = 0;
		int limit = 0;
		Integer totalRecords = roleRequest.getNoOfRecords();

		if (roleRequest.getPageIndex() == null
				|| roleRequest.getPageIndex() == 1) {
			totalRecords = getTotalNumberOfRecords(roleRequest);
			roleRequest.setNoOfRecords(totalRecords);
		}

		if (roleRequest.getPageIndex() == null && roleRequest.getPageSize() == null) {
			offset = 0;
			limit = Constant.DEFAULT_PAGE_SIZE;
		} else {
			offset = (roleRequest.getPageIndex() - 1) * roleRequest.getPageSize();
			limit = roleRequest.getPageSize();
		}
		JPAQuery query = new JPAQuery(entityManager);
		List<Tuple> tupleList = query
				.from(QUserRole.userRole,QUserRoleEntityMap.userRoleEntityMap)
				.where(isRoleNameLike(roleRequest.getRoleName()),
						isStatus(roleRequest.getStatus()),
						isEntityId(roleRequest.getEntityId(),roleRequest.getRoleType()),
						isRoleTypeList(roleRequest.getRoleTypeList()),
						QUserRole.userRole.userRoleId.eq(QUserRoleEntityMap.userRoleEntityMap.userRoleId))
						.offset(offset)
						.limit(limit)
                        .orderBy(orderByRoleIDDesc())
                        .list(QUserRole.userRole.userRoleId,
                        		QUserRole.userRole.name,
                        		QUserRole.userRole.status,
                        		QUserRole.userRole.role_type,
                        		QUserRole.userRole.maker_checker_req,
                        		QUserRole.userRole.updatedBy,
                        		QUserRole.userRole.createdBy,
                        		QUserRole.userRole.description,
                        		QUserRole.userRole.entityId
                        		);
		for (Tuple tuple : tupleList) {
            UserRoleRequest roleRUserRoleRequest  = new UserRoleRequest();
            roleRUserRoleRequest.setUserRoleId((tuple.get(QUserRole.userRole.userRoleId)));
            roleRUserRoleRequest.setRoleName(tuple.get(QUserRole.userRole.name));
            roleRUserRoleRequest.setStatus(tuple.get(QUserRole.userRole.status));
            roleRUserRoleRequest.setRoleType(RoleLevel.valueOf(tuple.get(QUserRole.userRole.role_type)));
            roleRUserRoleRequest.setMakerCheckerRequired(tuple.get(QUserRole.userRole.maker_checker_req));
            roleRUserRoleRequest.setUpdatedBy(tuple.get(QUserRole.userRole.updatedBy));
            roleRUserRoleRequest.setDescription(tuple.get(QUserRole.userRole.description));
            roleRUserRoleRequest.setCreatedBy(tuple.get(QUserRole.userRole.createdBy));
            roleRUserRoleRequest.setEntityId(tuple.get(QUserRole.userRole.entityId));
			searchRoleRequestsList.add(roleRUserRoleRequest);
		}
		return searchRoleRequestsList;
	}
	private int getTotalNumberOfRecords(UserRoleRequest roleRequest) throws Exception {
		JPAQuery query = new JPAQuery(entityManager);
		List<Long> list = query.from(QUserRole.userRole,QUserRoleEntityMap.userRoleEntityMap)
				.where(isRoleNameLike(roleRequest.getRoleName()),
						isStatus(roleRequest.getStatus()),
						isEntityId(roleRequest.getEntityId(),roleRequest.getRoleType()),
						isRoleTypeList(roleRequest.getRoleTypeList()),
						QUserRole.userRole.userRoleId.eq(QUserRoleEntityMap.userRoleEntityMap.userRoleId))
						.list(QUserRole.userRole.userRoleId);
		
		return (StringUtil.isListNotNullNEmpty(list) ? list.size() : 0);
	}
	
	@Override
	public UserRole findByUserRoleId(Long userRoleId) throws DataAccessException {
		UserRole role =  userRoleRepository.findOne(userRoleId);
		return role;
	}

	@Override
	public List<UserRole> findByRoleName(String name)  throws DataAccessException, Exception {
		List<UserRole> roleList =  userRoleRepository.findByName(name);
		return roleList;
	}

	@Override
	public List<UserRoleRequest> getUserRolesByRoleTypes(UserRoleRequest userRoleRequest) throws BeaconServiceException, InstantiationException, IllegalAccessException {
		List<UserRoleRequest> roleRequestsList = new ArrayList<UserRoleRequest>();
		
		JPAQuery query = new JPAQuery(entityManager);
		List<Tuple> tupleList = query.from(QUserRole.userRole,QUserRoleEntityMap.userRoleEntityMap)
				.where(isStatus(userRoleRequest.getStatus()),
						isRoleTypeList(userRoleRequest.getRoleTypeList()),
						isTokenIdEq((StringUtil.isNull(userRoleRequest.getUserRoleEntityMapRequest())  || StringUtil.isNull(userRoleRequest.getUserRoleEntityMapRequest().getTokenId()))  ? null : userRoleRequest.getUserRoleEntityMapRequest().getTokenId()),
						isHceIdEq((StringUtil.isNull(userRoleRequest.getUserRoleEntityMapRequest())  || StringUtil.isNull(userRoleRequest.getUserRoleEntityMapRequest().getHceId()))  ? null : userRoleRequest.getUserRoleEntityMapRequest().getHceId()),
						isSptsmIdEq((StringUtil.isNull(userRoleRequest.getUserRoleEntityMapRequest())  || StringUtil.isNull(userRoleRequest.getUserRoleEntityMapRequest().getSptsmId()))  ? null : userRoleRequest.getUserRoleEntityMapRequest().getSptsmId()),				
						QUserRole.userRole.userRoleId.eq(QUserRoleEntityMap.userRoleEntityMap.userRoleId))
						.orderBy(orderByRoleIDDesc())
						.list(QUserRole.userRole.userRoleId,
                        		QUserRole.userRole.name,
                        		QUserRole.userRole.status);
		for (Tuple tuple : tupleList) {
            UserRoleRequest roleRUserRoleRequest  = new UserRoleRequest();
            roleRUserRoleRequest.setUserRoleId(tuple.get(QUserRole.userRole.userRoleId));
            roleRUserRoleRequest.setRoleName(tuple.get(QUserRole.userRole.name));
            roleRUserRoleRequest.setStatus(tuple.get(QUserRole.userRole.status));
            roleRequestsList.add(roleRUserRoleRequest);
		}
		return roleRequestsList;
	}
	
	private BooleanExpression isStatus(String status){
	    return !StringUtil.isNullAndEmpty(status) ? QUserRole.userRole.status.eq(status) : null;        
	}
	
	private BooleanExpression isRoleTypeList(List<String> roleType) 
	{
		return StringUtil.isListNotNullNEmpty(roleType) ? QUserRole.userRole.role_type.in(roleType) : null;
	}
	
	private OrderSpecifier<Long> orderByRoleIDDesc() {
		return QUserRole.userRole.userRoleId.desc();
	}
	private BooleanExpression isRoleNameLike(String roleName) {
		return (roleName != null && !"".equals(roleName)) ?  QUserRole.userRole.name.toUpperCase().like("%"+roleName.replace("*", "").toUpperCase()+"%") : null;
	}
	
	private BooleanExpression isEntityId(Long entityId,RoleLevel roleCategory){
		/*if(!StringUtil.isNull(roleCategory) && RoleLevel.TOKEN.equals(roleCategory)){
			return entityId != null ? QUserRoleEntityMap.userRoleEntityMap.tokenId.eq(entityId) : null;
		}else if(!StringUtil.isNull(roleCategory) && RoleLevel.HCE.equals(roleCategory)){
			return entityId != null ? QUserRoleEntityMap.userRoleEntityMap.hceId.eq(entityId) : null;
		}else if(!StringUtil.isNull(roleCategory) && RoleLevel.SPTSM.equals(roleCategory)){
			return entityId != null ? QUserRoleEntityMap.userRoleEntityMap.sptsmId.eq(entityId) : null;
		}*/
		return null;
	}
	
	private BooleanExpression isTokenIdEq(Long pmId){
		return pmId != null ? QUserRoleEntityMap.userRoleEntityMap.tokenId.eq(pmId) : null;
	}
	
	private BooleanExpression isHceIdEq(Long partnerId){
		return partnerId != null ? QUserRoleEntityMap.userRoleEntityMap.hceId.eq(partnerId) : null;
	}
	
	private BooleanExpression isSptsmIdEq(Long salesAgentId){
		return salesAgentId != null ? QUserRoleEntityMap.userRoleEntityMap.sptsmId.eq(salesAgentId) : null;
	}

	/**
	 * @param roleRequest
	 * @return
	 * @throws DataAccessException
	 * @throws Exception
	 */
	@Override
	public List<UserRoleRequest> getActiveRole(UserRoleRequest roleRequest)	throws DataAccessException, Exception {
		List<UserRoleRequest> searchRoleRequestsList = new ArrayList<UserRoleRequest>();
		
		JPAQuery query = new JPAQuery(entityManager);
		List<Tuple> tupleList = query
				.from(QUserRole.userRole)
				.where(isRoleNameLike(roleRequest.getRoleName()),
						QUserRole.userRole.status.eq(Constant.ACTIVE))
                        .orderBy(orderByRoleIDDesc())
                        .list(QUserRole.userRole.userRoleId,
                        		QUserRole.userRole.name,
                        		QUserRole.userRole.status,
                        		QUserRole.userRole.role_type,
                        		QUserRole.userRole.description,
                        		QUserRole.userRole.entityId
                        		);
		for (Tuple tuple : tupleList) {
            UserRoleRequest roleRUserRoleRequest  = new UserRoleRequest();
            roleRUserRoleRequest.setUserRoleId((tuple.get(QUserRole.userRole.userRoleId)));
            roleRUserRoleRequest.setRoleName(tuple.get(QUserRole.userRole.name));
            roleRUserRoleRequest.setStatus(tuple.get(QUserRole.userRole.status));
            roleRUserRoleRequest.setUpdatedBy(tuple.get(QUserRole.userRole.role_type));
            roleRUserRoleRequest.setDescription(tuple.get(QUserRole.userRole.description));
            roleRUserRoleRequest.setEntityId(tuple.get(QUserRole.userRole.entityId));
			searchRoleRequestsList.add(roleRUserRoleRequest);
		}
		return searchRoleRequestsList;
	}
}
