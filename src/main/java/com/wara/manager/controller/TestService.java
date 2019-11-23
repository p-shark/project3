package com.wara.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wara.pension.dto.Pension;


@Service
public class TestService {

	private TestDao testDao;
	
	@Autowired
	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}
	
	public List<Pension> pensionInfo(List<String> param) {
		
		List<Pension> results = testDao.selectBySelectedPenNo(param);
		
		return results;
	}
	
}
