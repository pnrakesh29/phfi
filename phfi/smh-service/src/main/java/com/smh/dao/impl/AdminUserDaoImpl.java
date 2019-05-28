package com.smh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mysema.query.Tuple;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.expr.BooleanExpression;
import com.smh.constants.Constant;
import com.smh.dao.AdminUserDao;
import com.smh.dao.model.AdminUser;
import com.smh.dao.model.QAdminUser;
import com.smh.dao.model.QUserRole;
import com.smh.dao.repository.AdminUserRepository;
import com.smh.model.AdminUserRequest;

/**
*
* << Add Comments Here >>
*
* @author Shekhar Prasad
* @date 21-Dec-2015 10:46:11 AM
* @version 1.0
*/
@Repository("adminUserDao")
public class AdminUserDaoImpl implements AdminUserDao {
  
  @Autowired
  private AdminUserRepository adminUserRepository;

  @PersistenceContext
  private EntityManager entityManager;
  
  @Override
  public AdminUser authenticateChatakAdminUser(String spUName) throws DataAccessException {
    try {
      List<AdminUser> adminUsers = adminUserRepository.findByUserName(spUName);
      if (null != adminUsers && !adminUsers.isEmpty()) {
          return adminUsers.get(0);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public boolean authenticateChatakAdmin(String email, String spPass) throws DataAccessException {
    return false;
  }
  
  @Override
 	public AdminUser saveOrUpdateAdminUser(AdminUser adminUserDetails) throws DataAccessException {
 		return adminUserRepository.save(adminUserDetails);
 	}
  
  @Override
	public List<AdminUser> findByUserName(String userName)	throws DataAccessException {
		return adminUserRepository.findByUserName(userName);
	}

  @Override
  public AdminUser findByAdminUserId(Long adminUserId)throws DataAccessException {
	return adminUserRepository.findOne(adminUserId);
  }
  
  @Override
	public List<AdminUser> findByUserEmailId(String email)	throws DataAccessException {
		return adminUserRepository.findByEmail(email);
	}
  
  @Override
	public List<AdminUser> findByAdminUserLoginNameOrEmail(String userName, String email) throws DataAccessException {
		return adminUserRepository.findByUserNameOrEmail(userName, email);
	}
  
  @Override
	public List<AdminUserRequest> searchAdminUser(AdminUserRequest userTo) throws Exception {
		Integer pageIndex = userTo.getPageIndex();
		Integer pageSize = userTo.getPageSize();
		Integer offset = 0;
		Integer limit = 0;
		Integer totalRecords = userTo.getNoOfRecords();
		List<AdminUserRequest> userRespList = new ArrayList<AdminUserRequest>();

		if (pageIndex == null || pageIndex == 1) {
			totalRecords = getTotalNumberOfRecords(userTo);
			userTo.setNoOfRecords(totalRecords);
		}

		if (pageIndex == null && pageSize == null) {
			offset = 0;
			limit = Constant.DEFAULT_PAGE_SIZE;
		} else {
			offset = (pageIndex - 1) * pageSize;
			limit = pageSize;
		}

		JPAQuery query = new JPAQuery(entityManager);
		QUserRole userRole = QUserRole.userRole;
		List<Tuple> dataList = query
				.from(QAdminUser.adminUser,userRole)
				.where(isAdminUserIdEq(userTo.getAdminUserId()),
						isLastNameEq(userTo.getLastName()),
						isFirstNameEq(userTo.getFirstName()),
						isUserTypeEq(userTo.getUserType()),
						isRoleIdEq(userTo.getUserRoleId()),
						isUserNameEq(userTo.getUserName()),
						isPhone(userTo.getPhone()),
						QAdminUser.adminUser.userRoleId.eq(userRole.userRoleId),
						isUserStatusEq(userTo.getStatus()),
						isEmailIdEq(userTo.getEmail()),
						isCreatedByEq(userTo.getCreatedBy()))
						//isStatusEq(userTo.getStatus()),
						//isRoleIdNot(userTo.getUserRoleId()))
						//isStatusNotEq(userTo.getStatus()),
//						QAdminUser.adminUser.userRoleId
//								.eq(QHostUserRoles.hostUserRoles.userRoleId))
				.offset(offset)
				.limit(limit)
				.orderBy(orderByUserIdAsc())
				.list(QAdminUser.adminUser.adminUserId,
						QAdminUser.adminUser.firstName,
						QAdminUser.adminUser.lastName,
						QAdminUser.adminUser.status,
						QAdminUser.adminUser.phone,
						QAdminUser.adminUser.userName,
						QAdminUser.adminUser.email,
						QAdminUser.adminUser.userType,
						userRole.name);
		AdminUserRequest adminUserDto = null;
		for (Tuple data : dataList) {
			adminUserDto = new AdminUserRequest();
			adminUserDto.setAdminUserId(data
					.get(QAdminUser.adminUser.adminUserId));
			adminUserDto.setPhone(data.get(QAdminUser.adminUser.phone));
			adminUserDto.setUserName(data.get(QAdminUser.adminUser.userName));
			adminUserDto.setEmail(data.get(QAdminUser.adminUser.email));
			adminUserDto.setUserType(data.get(QAdminUser.adminUser.userType));
			adminUserDto.setFirstName(data.get(QAdminUser.adminUser.firstName));
			adminUserDto.setLastName(data.get(QAdminUser.adminUser.lastName));
			adminUserDto.setStatus(data.get(QAdminUser.adminUser.status));
			adminUserDto.setRoleName(data.get(userRole.name));
			
			userRespList.add(adminUserDto);
		}
		return userRespList;
	}
	
	private BooleanExpression isAdminUserIdEq(Long userid) throws Exception {

		return (userid != null && !"".equals(userid)) ? QAdminUser.adminUser.adminUserId
				.eq(userid) : null;
	}

	private BooleanExpression isRoleIdEq(Long userRoleId) throws Exception {

		return (userRoleId != null) ?QAdminUser.adminUser.userRoleId
				.eq(userRoleId) : null;
	}

	private BooleanExpression isLastNameEq(String lastName) throws Exception {

		return (lastName != null && !"".equals(lastName)) ? QAdminUser.adminUser.lastName
				.toUpperCase().like(
						"%" + lastName.toUpperCase().replace("*", "") + "%")
				: null;
	}

	private BooleanExpression isFirstNameEq(String firstName) throws Exception {

		return (firstName != null && !"".equals(firstName)) ? QAdminUser.adminUser.firstName
				.toUpperCase().like(
						"%" + firstName.toUpperCase().replace("*", "") + "%")
				: null;
	}

	private BooleanExpression isUserTypeEq(String userType) throws Exception {

		return (userType != null && !"".equals(userType)) ? QAdminUser.adminUser.userType
				.equalsIgnoreCase(userType) : null;
	}

	private BooleanExpression isUserNameEq(String userName) throws Exception {

		return (userName != null && !"".equals(userName)) ? QAdminUser.adminUser.userName
				.toUpperCase().like(
						"%" + userName.toUpperCase().replace("*", "") + "%")
				: null;
	}

	private BooleanExpression isEmailIdEq(String emailId) throws Exception {
		return (emailId != null && !"".equals(emailId)) ? QAdminUser.adminUser.email
				.toUpperCase().like(
						"%" + emailId.toUpperCase().replace("*", "") + "%")
				: null;
	}

	private BooleanExpression isCreatedByEq(String createdBy) throws Exception {

		return (createdBy != null && !"".equals(createdBy)) ? QAdminUser.adminUser.createdBy
				.equalsIgnoreCase(createdBy) : null;
	}
	
	private BooleanExpression isUserStatusEq(String status) throws Exception {

		return (status != null && !"".equals(status)) ?QAdminUser.adminUser.status.eq(status)
				: null;
	}

	private BooleanExpression isPhone(String phone) throws Exception {
		return (phone != null && !"".equals(phone)) ? QAdminUser.adminUser.phone
				.toUpperCase().like(
						"%" + phone.toUpperCase().replace("*", "") + "%")
				: null;
	}

	private OrderSpecifier<Long> orderByUserIdAsc() {
		return QAdminUser.adminUser.adminUserId.desc();
	}

	private int getTotalNumberOfRecords(AdminUserRequest userTo) throws Exception {
		JPAQuery query = new JPAQuery(entityManager);
		List<AdminUser> adminuserList = query
				.from(QAdminUser.adminUser)
				.where(isAdminUserIdEq(userTo.getAdminUserId()),
						isLastNameEq(userTo.getLastName()),
						isFirstNameEq(userTo.getFirstName()),
						isUserTypeEq(userTo.getUserType()),
						isRoleIdEq(userTo.getUserRoleId()),
						isUserNameEq(userTo.getUserName()),
						isPhone(userTo.getPhone()),
						//isUserStatusEq(userTo.getStatus()),
						isEmailIdEq(userTo.getEmail()),
						isCreatedByEq(userTo.getCreatedBy()))
						//isStatusEq(userTo.getStatus()),
						//isRoleIdNot(userTo.getUserRoleId()))
						//isStatusNotEq(userTo.getStatus()),
//						QAdminUser.adminUser.userRoleId
//								.eq(QHostUserRoles.hostUserRoles.userRoleId))
				.orderBy(orderByUserIdAsc()).list(QAdminUser.adminUser);

		return (adminuserList != null && !adminuserList.isEmpty() ? adminuserList
				.size() : 0);
	}
  
  
}
