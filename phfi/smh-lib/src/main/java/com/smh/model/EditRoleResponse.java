package com.smh.model;

import java.util.List;
import java.util.Map;

public class EditRoleResponse extends Response {

	 private static final long serialVersionUID = 8519671020268336667L;

	  private UserRoleRequest roleRequest;

	  private Map<Long, List<PHFIFeatureRequest>> featureMap;

	  private List<Long> existingFeature;

	  private Long serviceProvider;

	  private List<String> serviceProviderList;

	  private List<String> subServiceProviderList;

	/**
	 * @return the roleRequest
	 */
	public UserRoleRequest getRoleRequest() {
		return roleRequest;
	}

	/**
	 * @param roleRequest the roleRequest to set
	 */
	public void setRoleRequest(UserRoleRequest roleRequest) {
		this.roleRequest = roleRequest;
	}

	/**
	 * @return the featureMap
	 */
	public Map<Long, List<PHFIFeatureRequest>> getFeatureMap() {
		return featureMap;
	}

	/**
	 * @param featureMap the featureMap to set
	 */
	public void setFeatureMap(Map<Long, List<PHFIFeatureRequest>> featureMap) {
		this.featureMap = featureMap;
	}

	/**
	 * @return the existingFeature
	 */
	public List<Long> getExistingFeature() {
		return existingFeature;
	}

	/**
	 * @param existingFeature the existingFeature to set
	 */
	public void setExistingFeature(List<Long> existingFeature) {
		this.existingFeature = existingFeature;
	}

	/**
	 * @return the serviceProvider
	 */
	public Long getServiceProvider() {
		return serviceProvider;
	}

	/**
	 * @param serviceProvider the serviceProvider to set
	 */
	public void setServiceProvider(Long serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	/**
	 * @return the serviceProviderList
	 */
	public List<String> getServiceProviderList() {
		return serviceProviderList;
	}

	/**
	 * @param serviceProviderList the serviceProviderList to set
	 */
	public void setServiceProviderList(List<String> serviceProviderList) {
		this.serviceProviderList = serviceProviderList;
	}

	/**
	 * @return the subServiceProviderList
	 */
	public List<String> getSubServiceProviderList() {
		return subServiceProviderList;
	}

	/**
	 * @param subServiceProviderList the subServiceProviderList to set
	 */
	public void setSubServiceProviderList(List<String> subServiceProviderList) {
		this.subServiceProviderList = subServiceProviderList;
	}
	  
	  
}
