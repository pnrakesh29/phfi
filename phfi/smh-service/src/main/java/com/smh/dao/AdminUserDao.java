package com.smh.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.smh.dao.model.AdminUser;
import com.smh.model.AdminUserRequest;


public interface AdminUserDao {

  /**
   * @param email
   * @param spPass
   * @return
   * @throws DataAccessException
   */
  public boolean authenticateChatakAdmin(String email, String spPass) throws DataAccessException;

  /**
   * @param email
   * @param spPass
   * @return
   * @throws DataAccessException
   */
  public AdminUser authenticateChatakAdminUser(String spUName) throws DataAccessException;
  
  public List<AdminUser> findByUserName(String userName) throws DataAccessException;
  
  public AdminUser saveOrUpdateAdminUser(AdminUser adminUserDetails)  throws DataAccessException;
  
  public AdminUser findByAdminUserId(Long adminUserId)throws DataAccessException;
  
  public List<AdminUser> findByUserEmailId(String email) throws DataAccessException;
  
  public List<AdminUser> findByAdminUserLoginNameOrEmail(String userName, String email) throws DataAccessException;

  public List<AdminUserRequest> searchAdminUser(AdminUserRequest adminUserRequestTemp) throws DataAccessException, Exception;
}
