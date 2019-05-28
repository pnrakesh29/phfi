package com.smh.util;

import java.io.Serializable;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.session.SessionRegistryImpl;

public class ChatakAuthenticationProvider implements AuthenticationProvider ,Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4394525563882293668L;
	private SessionRegistryImpl sessionRegistry;

	  /**
	   * Method to authenticate the user
	   * 
	   * @param authentication
	   */
	  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authentication.getCredentials(),
	                                                                                                      authentication.getCredentials(),
	                                                                                                      authentication.getAuthorities());
	    return authenticationToken;
	  }

	  /**
	   * Method to supports authenticated user
	   * 
	   * @param authentication
	   */
	  public boolean supports(Class<?> authentication) {
	    return authentication.equals(UsernamePasswordAuthenticationToken.class);
	  }

	  /**
	   * @return the sessionRegistry
	   */
	  public SessionRegistryImpl getSessionRegistry() {
	    return sessionRegistry;
	  }

	  /**
	   * @param sessionRegistry
	   *          the sessionRegistry to set
	   */
	  public void setSessionRegistry(SessionRegistryImpl sessionRegistry) {
	    this.sessionRegistry = sessionRegistry;
	  }

}
