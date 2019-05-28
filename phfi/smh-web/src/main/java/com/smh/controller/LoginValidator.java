package com.smh.controller;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.smh.model.LoginRequest;
import com.smh.util.Properties;
@Service
public class LoginValidator implements Validator {
	public LoginValidator() {
	  }

	  @Override
	  public boolean supports(Class<?> clazz) {
	    return LoginRequest.class.isAssignableFrom(clazz);
	  }

	  @SuppressWarnings("unused")
	  @Override
	  public void validate(Object object, Errors errors) {
		  LoginRequest customerPersonalData = (LoginRequest) object;
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "spUser", Properties.getProperty("chatak.username.required"));
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "spPass", Properties.getProperty("chatak.password.required"));

	  }

}
