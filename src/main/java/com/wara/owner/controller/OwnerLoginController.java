package com.wara.owner.controller;

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

import com.wara.member.command.LoginCommand;
import com.wara.member.exception.WrongIdPasswordException;
import com.wara.member.validator.LoginCommandValidator;
import com.wara.owner.command.OwnerAuthInfo;
import com.wara.owner.validator.OwnerAuthService;

@Controller
@RequestMapping("owner")
public class OwnerLoginController {
	
	private OwnerAuthService ownerAuthService;
	
	@Autowired
	public void setOwnerAuthService(OwnerAuthService ownerAuthService) {
		this.ownerAuthService = ownerAuthService;
	}
	
	@GetMapping
	public String form(LoginCommand ownerLoginCommand,
			@CookieValue(value = "REMEMBER", required = false) Cookie rCookie) {
		if (rCookie != null) {
			ownerLoginCommand.setId(rCookie.getValue());
			ownerLoginCommand.setRememberId(true);
		}
		
		return "owner/loginform";
	}
	
	@PostMapping
    public String submit(LoginCommand ownerLoginCommand, Errors errors,
    		HttpSession session, HttpServletResponse response) {
    	new LoginCommandValidator().validate(ownerLoginCommand, errors);
    	if (errors.hasErrors()) {
    		return "owner/loginform";
    	}
    	try {
    		OwnerAuthInfo ownerAuthInfo = ownerAuthService.authenticate
    				( ownerLoginCommand.getId(), ownerLoginCommand.getPassword());
    		session.setAttribute("authInfo", ownerAuthInfo);
    		Cookie rememberCookie = new Cookie ("REMEMBER",ownerLoginCommand.getId());
    		rememberCookie.setPath("/");
    		if(ownerLoginCommand.isRememberId()) {
    			rememberCookie.setMaxAge(60*60*24*30);
    		} else {
    			rememberCookie.setMaxAge(0);
    		}
    		response.addCookie(rememberCookie);
    		return "redirect:/";
    	} catch (WrongIdPasswordException e) {
            errors.reject("idPasswordNotMatching");
            return "owner/loginform";
        }
    	
    }
	
}
