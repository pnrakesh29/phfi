package com.smh.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class LoginResponse extends Response {
  /**
   * 
   */
  private static final long serialVersionUID = -3128219292788373292L;

  private Boolean status;

  private String message;

  private Long userId;
  
  private String email;

  private String accessToken;

  private Long serviceProviderId;

  private Long subServiceProviderId;

  private List<Long> existingFeature;

  private Long userRoleId;

  private Boolean makerCheckerRequired;

  private String userType;
  
  private String userName;
  
  private String firstName;
  
  private String lastName;
  
  private Long loginMode;
  
  private Long entityId;
  
  

  /**
 * @return the userName
 */
public String getUserName() {
	return userName;
}

/**
 * @param userName the userName to set
 */
public void setUserName(String userName) {
	this.userName = userName;
}

/**
 * @return the firstName
 */
public String getFirstName() {
	return firstName;
}

/**
 * @param firstName the firstName to set
 */
public void setFirstName(String firstName) {
	this.firstName = firstName;
}

/**
 * @return the lastName
 */
public String getLastName() {
	return lastName;
}

/**
 * @param lastName the lastName to set
 */
public void setLastName(String lastName) {
	this.lastName = lastName;
}

/**
 * @return the loginMode
 */
public Long getLoginMode() {
	return loginMode;
}

/**
 * @param loginMode the loginMode to set
 */
public void setLoginMode(Long loginMode) {
	this.loginMode = loginMode;
}

/**
   * @return the serviceProviderId
   */
  public Long getServiceProviderId() {
    return serviceProviderId;
  }

  /**
   * @param serviceProviderId
   *          the serviceProviderId to set
   */
  public void setServiceProviderId(Long serviceProviderId) {
    this.serviceProviderId = serviceProviderId;
  }

  /**
   * @return the subServiceProviderId
   */
  public Long getSubServiceProviderId() {
    return subServiceProviderId;
  }

  /**
   * @param subServiceProviderId
   *          the subServiceProviderId to set
   */
  public void setSubServiceProviderId(Long subServiceProviderId) {
    this.subServiceProviderId = subServiceProviderId;
  }

  /**
   * @return the status
   */
  public Boolean getStatus() {
    return status;
  }

  /**
   * @param status
   *          the status to set
   */
  public void setStatus(Boolean status) {
    this.status = status;
  }

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message
   *          the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * @return the userId
   */
  public Long getUserId() {
    return userId;
  }

  /**
   * @param userId
   *          the userId to set
   */
  public void setUserId(Long userId) {
    this.userId = userId;
  }

  /**
   * @return the accessToken
   */
  public String getAccessToken() {
    return accessToken;
  }

  /**
   * @param accessToken
   *          the accessToken to set
   */
  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
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
   * @return the userRoleId
   */
  public Long getUserRoleId() {
    return userRoleId;
  }

  /**
   * @param userRoleId
   *          the userRoleId to set
   */
  public void setUserRoleId(Long userRoleId) {
    this.userRoleId = userRoleId;
  }

  /**
   * @return the makerCheckerRequired
   */
  public Boolean getMakerCheckerRequired() {
    return makerCheckerRequired;
  }

  /**
   * @param makerCheckerRequired
   *          the makerCheckerRequired to set
   */
  public void setMakerCheckerRequired(Boolean makerCheckerRequired) {
    this.makerCheckerRequired = makerCheckerRequired;
  }

  /**
   * @return the userType
   */
  public String getUserType() {
    return userType;
  }

  /**
   * @param userType
   *          the userType to set
   */
  public void setUserType(String userType) {
    this.userType = userType;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

public Long getEntityId() {
	return entityId;
}

public void setEntityId(Long entityId) {
	this.entityId = entityId;
}

}
