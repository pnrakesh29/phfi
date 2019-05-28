/**
 * 
 */
package com.smh.handler;

import com.smh.exception.BeaconServiceException;
import com.smh.model.AdminUserRequest;
import com.smh.model.AdminUserResponse;
import com.smh.model.Response;

public interface UserHandler {

	/**
	 * @param adminUserRequest
	 * @return
	 * @throws StyloPayAdminException
	 */
	public Response createOrUpdateUser(AdminUserRequest adminUserRequest) throws BeaconServiceException;

	/**
	 * @param userRequestTemp
	 * @return
	 * @throws StyloPayAdminException
	 */
	public AdminUserResponse searchAdminUser(AdminUserRequest userRequestTemp) throws BeaconServiceException;

	/**
	 * 
	 * @param adminUserId
	 * @return
	 * @throws StyloPayAdminException
	 */
	public AdminUserResponse findByAdminUserId(Long adminUserId) throws BeaconServiceException;

	/**
	 * 
	 * @param adminUserRequest
	 * @return
	 * @throws StyloPayAdminException
	 */
	public Response updateUserProfile(AdminUserRequest adminUserRequest) throws BeaconServiceException;

	/**
	 * Service to delete User
	 * 
	 * @param userId
	 * @return
	 * @throws StyloPayAdminException
	 */
	public Response deleteUser(Long userId) throws BeaconServiceException;

}
