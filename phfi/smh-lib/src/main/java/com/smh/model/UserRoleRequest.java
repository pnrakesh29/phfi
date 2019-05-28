package com.smh.model;

import java.util.List;

import com.smh.enums.RoleLevel;

public class UserRoleRequest extends SearchRequest
{
	private static final long serialVersionUID = -4970591669777076388L;
	
	private String roleName;
    
	private String roleId;
	
	private String description;
	
	private RoleLevel roleType;
	
	private String makerChecker;
	
	private String feature[];
	
	 private String roleLevel;
	
	private String featurData[];
	
	private String roleCategory;
	
	private String status;
	
	private String reason;

	private String makerCheckerRequired;

	private String serviceProvider;

	private String[] serviceProviderList;

	private String[] subServiceProvierList;
	
	private String userId;
	  
	private String serviceProviderId;
	  
	private String subServiceProviderId;
	  
	private List<String> roleTypeList;
	
	private String updateCheckFlage;
	
	private Long entityId;
	
	private String createOrUpdateFlag;
	
	private UserRoleEntityMapRequest userRoleEntityMapRequest;
	
	private Integer recordPerPage;
	
	 private Long userRoleId;
	 
	 private String permission;
	 
	
	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Integer getRecordPerPage() {
		return recordPerPage;
	}

	public void setRecordPerPage(Integer recordPerPage) {
		this.recordPerPage = recordPerPage;
	}

	/**
	 * @return the createOrUpdateFlag
	 */
	public String getCreateOrUpdateFlag() {
		return createOrUpdateFlag;
	}

	/**
	 * @param createOrUpdateFlag the createOrUpdateFlag to set
	 */
	public void setCreateOrUpdateFlag(String createOrUpdateFlag) {
		this.createOrUpdateFlag = createOrUpdateFlag;
	}

	/**
	 * @return the entityId
	 */
	public Long getEntityId() {
		return entityId;
	}

	/**
	 * @param entityId the entityId to set
	 */
	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	/**
	 * @return the roleLevel
	 */
	public String getRoleLevel() {
		return roleLevel;
	}

	/**
	 * @param roleLevel the roleLevel to set
	 */
	public void setRoleLevel(String roleLevel) {
		this.roleLevel = roleLevel;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the serviceProviderId
	 */
	public String getServiceProviderId() {
		return serviceProviderId;
	}

	/**
	 * @param serviceProviderId the serviceProviderId to set
	 */
	public void setServiceProviderId(String serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	/**
	 * @return the subServiceProviderId
	 */
	public String getSubServiceProviderId() {
		return subServiceProviderId;
	}

	/**
	 * @param subServiceProviderId the subServiceProviderId to set
	 */
	public void setSubServiceProviderId(String subServiceProviderId) {
		this.subServiceProviderId = subServiceProviderId;
	}

	/**
	 * @return the roleTypeList
	 */
	public List<String> getRoleTypeList() {
		return roleTypeList;
	}

	/**
	 * @param roleTypeList the roleTypeList to set
	 */
	public void setRoleTypeList(List<String> roleTypeList) {
		this.roleTypeList = roleTypeList;
	}

	/**
	 * @return the roleCategory
	 */
	
	public String getRoleCategory() {
		return roleCategory;
	}
	
	/**
	 * @param roleCategory the roleCategory to set
	 */

	public void setRoleCategory(String roleCategory) {
		this.roleCategory = roleCategory;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the roleId
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the description 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the feature
	 */
	public String[] getFeature() {
		return feature;
	}

	/**
	 * @param feature the feature to set
	 */
	public void setFeature(String[] feature) {
		this.feature = feature;
	}

	/**
	 * @return the featurData
	 */
	public String[] getFeaturData() {
		return featurData;
	}

	/**
	 * @param featurData the featurData to set
	 */
	public void setFeaturData(String[] featurData) {
		this.featurData = featurData;
	}

	public RoleLevel getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleLevel roleType) {
		this.roleType = roleType;
	}

	public String getMakerChecker() {
		return makerChecker;
	}

	public void setMakerChecker(String makerChecker) {
		this.makerChecker = makerChecker;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the makerCheckerRequired
	 */
	public String getMakerCheckerRequired() {
		return makerCheckerRequired;
	}

	/**
	 * @param makerCheckerRequired the makerCheckerRequired to set
	 */
	public void setMakerCheckerRequired(String makerCheckerRequired) {
		this.makerCheckerRequired = makerCheckerRequired;
	}

	/**
	 * @return the serviceProvider
	 */
	public String getServiceProvider() {
		return serviceProvider;
	}

	/**
	 * @param serviceProvider the serviceProvider to set
	 */
	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	/**
	 * @return the serviceProviderList
	 */
	public String[] getServiceProviderList() {
		return serviceProviderList;
	}

	/**
	 * @param serviceProviderList the serviceProviderList to set
	 */
	public void setServiceProviderList(String[] serviceProviderList) {
		this.serviceProviderList = serviceProviderList;
	}

	/**
	 * @return the subServiceProvierList
	 */
	public String[] getSubServiceProvierList() {
		return subServiceProvierList;
	}

	/**
	 * @param subServiceProvierList the subServiceProvierList to set
	 */
	public void setSubServiceProvierList(String[] subServiceProvierList) {
		this.subServiceProvierList = subServiceProvierList;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the updateCheckFlage
	 */
	public String getUpdateCheckFlage() {
		return updateCheckFlage;
	}

	/**
	 * @param updateCheckFlage the updateCheckFlage to set
	 */
	public void setUpdateCheckFlage(String updateCheckFlage) {
		this.updateCheckFlage = updateCheckFlage;
	}

	public UserRoleEntityMapRequest getUserRoleEntityMapRequest() {
		return userRoleEntityMapRequest;
	}

	public void setUserRoleEntityMapRequest(
			UserRoleEntityMapRequest userRoleEntityMapRequest) {
		this.userRoleEntityMapRequest = userRoleEntityMapRequest;
	}
}
