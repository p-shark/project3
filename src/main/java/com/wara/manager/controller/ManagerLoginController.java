package com.wara.manager.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wara.manager.command.ManagerAuthInfo;
import com.wara.manager.service.ManagerAuthService;
import com.wara.member.command.LoginCommand;
import com.wara.member.exception.WrongIdPasswordException;
import com.wara.member.validator.LoginCommandValidator;

@Controller
@RequestMapping("manager")
public class ManagerLoginController {
	
	private ManagerAuthService managerAuthService;
	
	@Autowired
	public void setManagerAuthService(ManagerAuthService managerAuthService) {
		this.managerAuthService = managerAuthService;
	}
	
	@GetMapping
	public String form(LoginCommand managerLoginCommand,
			@CookieValue(value = "REMEMBER", required = false) Cookie rCookie) {
		if (rCookie != null) {
			managerLoginCommand.setId(rCookie.getValue());
			managerLoginCommand.setRememberId(true);
		}
		
		return "manager/loginform";
	}
	
	@PostMapping
    public String submit(LoginCommand managerLoginCommand, Errors errors,
    		HttpSession session, HttpServletResponse response) {
    	new LoginCommandValidator().validate(managerLoginCommand, errors);
    	if (errors.hasErrors()) {
    		return "manager/loginform";
    	}
    	try {
    		ManagerAuthInfo managerAuthInfo = managerAuthService.authenticate
    				( managerLoginCommand.getId(), managerLoginCommand.getPassword());
    		session.setAttribute("authInfo", managerAuthInfo);
    		Cookie rememberCookie = new Cookie ("REMEMBER",managerLoginCommand.getId());
    		rememberCookie.setPath("/");
    		if(managerLoginCommand.isRememberId()) {
    			rememberCookie.setMaxAge(60*60*24*30);
    		} else {
    			rememberCookie.setMaxAge(0);
    		}
    		response.addCookie(rememberCookie);
    		return "redirect:/";
    	} catch (WrongIdPasswordException e) {
            errors.reject("idPasswordNotMatching");
            return "manager/loginform";
        }
    	
    }
	
}
