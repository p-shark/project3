package com.wara.owner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wara.owner.command.OwnerRegisterRequest;
import com.wara.owner.exception.DuplicateOwnerException;
import com.wara.owner.service.OwnerRegisterService;
import com.wara.owner.validator.RegisterRequestValidator;

@Controller
@RequestMapping("owner")
public class OwnerRegisterController {
	
	private OwnerRegisterService ownerRegisterService;
	
	@Autowired
	public void setOwnerRegisterService(OwnerRegisterService ownerRegisterService) {
		this.ownerRegisterService = ownerRegisterService;
	}
	
	@RequestMapping("/ownerStep1")
	public String handleRegisterForm() {
		return "owner/ownerStep1";
	}
	
	@PostMapping("/ownerStep2")
	public String handleStep2(
			@RequestParam(value = "agree1", defaultValue = "false") Boolean agree1,
			@RequestParam(value = "agree2", defaultValue = "false") Boolean agree2,
			Model model) {
		if (!agree1 || !agree2) {
			return "owner/ownerStep1";
		}
		model.addAttribute("ownerRegisterRequest", new OwnerRegisterRequest());
		return "owner/ownerStep2";
	}
	
	@GetMapping("/ownerStep2")
	public String handleStep2Get() {
		return "redirect:/owner/ownerStep1";
	}
	
	@PostMapping("/ownerStep3")
	public String handleStep3(OwnerRegisterRequest regReq, Errors errors) {
		new RegisterRequestValidator().validate(regReq, errors);
		if (errors.hasErrors())
			return "owner/ownerStep2";

		try {
			ownerRegisterService.regist(regReq);
			return "owner/ownerStep3";
		} catch (DuplicateOwnerException ex) {
			errors.rejectValue("id", "duplicate");
			return "owner/ownerStep2";
		}
	}
	
}
