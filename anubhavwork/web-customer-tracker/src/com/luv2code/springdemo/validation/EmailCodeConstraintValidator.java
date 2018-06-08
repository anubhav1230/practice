package com.luv2code.springdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailCodeConstraintValidator implements ConstraintValidator<EmailCode, String> {

	private String emailSuffix;

	public void initialize(EmailCode thecode) {

		emailSuffix = thecode.value();

	}

	@Override
	public boolean isValid(String theEmail, ConstraintValidatorContext theConstraintValdatorContext) {
		// TODO Auto-generated method stub
		boolean result ;
		
			result = theEmail.endsWith(emailSuffix);
		
		return result;
	}

}


