package com.wara.owner.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.wara.owner.command.OwnerRegisterRequest;

public class RegisterRequestValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return OwnerRegisterRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("OwnerRegisterRequestValidator#validate(): " + this);
		OwnerRegisterRequest regReq = (OwnerRegisterRequest) target;
		if (regReq.getOwner_id() == null || regReq.getOwner_id().trim().isEmpty()) {
			errors.rejectValue("owner_id", "required");
		} else {
			
		}
		ValidationUtils.rejectIfEmpty(errors, "owner_pwd", "required");
		ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owner_name", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owner_email", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owner_phone", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owner_content", "required");

		if (!regReq.getOwner_pwd().isEmpty()) {
			if (!regReq.isPasswordEqualToConfirmPassword()) {
				errors.rejectValue("confirmPassword", "nomatch");
			}
		}
	}

}
