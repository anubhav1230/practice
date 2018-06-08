package com.luv2code.springdemo.validation;




import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = { EmailCodeConstraintValidator.class })
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)

public @interface EmailCode {

	//define default emailcode
	
	public String value() default "@cybage.com";
	
	//define default error message
	public String message() default "must end with @cybage.com";
	
	
	//define default groups
	
	public Class<?> [] groups() default{};
	//define default payloads
	
	public Class<? extends Payload>[] payload() default{};
	
}
