package com.wara.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wara.member.command.RegisterRequest;
import com.wara.member.exception.DuplicateMemberException;
import com.wara.member.service.MemberRegisterService;
import com.wara.member.validator.RegisterRequestValidator;

@Controller
public class RegisterController {
	
	private MemberRegisterService memberRegisterService;
	
	@Autowired
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}
	
	@RequestMapping("/register/step1")
	public String handleStep1() {
		return "register/step1";
	}
	
	@PostMapping("/register/step2")
	public String handleStep2(
			@RequestParam(value = "agree1", defaultValue = "false") Boolean agree1,
			@RequestParam(value = "agree2", defaultValue = "false") Boolean agree2,
			Model model) {
		if (!agree1 || !agree2) {
			return "register/step1";
		}
		model.addAttribute("registerRequest", new RegisterRequest());
		return "register/step2";
	}
	
	@GetMapping("/register/step2")
	public String handleStep2Get() {
		return "redirect:/register/step1";
	}
	
	@PostMapping("/register/step3")
	public String handleStep3(RegisterRequest regReq, Errors errors) {
		new RegisterRequestValidator().validate(regReq, errors);
		if (errors.hasErrors())
			return "register/step2";

		try {
			memberRegisterService.regist(regReq);
			return "redirect:/";
		} catch (DuplicateMemberException ex) {
			errors.rejectValue("id", "duplicate");
			return "register/step2";
		}
	}
}
