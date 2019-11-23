package com.wara.manager.controller;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wara.pension.dto.Pension;

@Component
public interface TestDao {
	
	public List<Pension> selectBySelectedPenNo(List<String> pen_nos); 
}
