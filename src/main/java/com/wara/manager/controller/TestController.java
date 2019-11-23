package com.wara.manager.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wara.pension.dto.Pension;
import com.wara.pension.service.PensionService;

@Controller
@RequestMapping("test")
public class TestController {
	
	private TestService testService;
	
	@Autowired
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	
	@GetMapping
	public String test() {
		return "page/test";
	}
	
	
//	@GetMapping("/choices")
//	public @ResponseBody List<Pension> choice(HttpServletRequest request){
//		
//		String params[] = request.getParameterValues("pen_nos");
//		System.out.println(params + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
//		String param = params[0]+ ","+params[1];
//		System.out.println(params + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
//		List<Pension> results = testService.pensionInfo(param);
//		
//		return results;
//	}
	
	@PostMapping("/choices")
	public @ResponseBody List<Pension> choicePost(@RequestBody Map<String, Object> params, HttpServletRequest request){
		List<String> paramList = (List<String>) params.get("pen_nos");
		System.out.println(paramList + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   ");
		List<Pension> results = testService.pensionInfo(paramList);
		
		return results;
	}
}
