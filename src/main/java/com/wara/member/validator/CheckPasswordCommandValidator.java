package com.wara.member.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.wara.member.command.CheckPasswordCommand;

public class CheckPasswordCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CheckPasswordCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "currentPassword", "required");
	}

}
