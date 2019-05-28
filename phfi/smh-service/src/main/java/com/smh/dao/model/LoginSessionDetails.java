package com.smh.dao.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOGIN_SESSION_DETAILS")
public class LoginSessionDetails implements Serializable {
	
	private static final long serialVersionUID = 7902003834872833035L;

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	@Column(name = "SESSION_ID")
	private String sessionId;
	
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "LOGIN_STATUS")
	private String loginStatus;
	
	@Column(name = "LOGIN_TIME")
	private Timestamp loginTime;
	
	@Column(name = "LOGOUT_TIME")
	private Timestamp logoutTime;
	
	@Column(name = "LAST_ACTIVITY_TIME")
	private Timestamp lastActivityTime;
	
	@Column(name = "PORTAL_TYPE")
	private String portalType;
	
	@Column(name = "IP_ADDRESS")
	private String ipAddress;
	
	@Column(name = "BROWSER_TYPE")
	private String browserType;
	

	public String getBrowserType() {
		return browserType;
	}

	public void setBrowserType(String browserType) {
		this.browserType = browserType;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

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
	 * @return the loginStatus
	 */
	public String getLoginStatus() {
		return loginStatus;
	}

	/**
	 * @param loginStatus the loginStatus to set
	 */
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	/**
	 * @return the loginTime
	 */
	public Timestamp getLoginTime() {
		return loginTime;
	}

	/**
	 * @param loginTime the loginTime to set
	 */
	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * @return the logoutTime
	 */
	public Timestamp getLogoutTime() {
		return logoutTime;
	}

	/**
	 * @param logoutTime the logoutTime to set
	 */
	public void setLogoutTime(Timestamp logoutTime) {
		this.logoutTime = logoutTime;
	}

	/**
	 * @return the portalType
	 */
	public String getPortalType() {
		return portalType;
	}

	/**
	 * @param portalType the portalType to set
	 */
	public void setPortalType(String portalType) {
		this.portalType = portalType;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Timestamp getLastActivityTime() {
		return lastActivityTime;
	}

	public void setLastActivityTime(Timestamp lastActivityTime) {
		this.lastActivityTime = lastActivityTime;
	}
	
}
