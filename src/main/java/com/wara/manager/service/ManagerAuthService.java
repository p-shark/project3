package com.wara.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wara.manager.command.ManagerAuthInfo;
import com.wara.manager.dao.ManagerDao;
import com.wara.manager.dto.Manager;
import com.wara.manager.exception.WrongIdPasswordException;

/* 세션에 로그인 정보를 다는 서비스 클래스 */
@Service
public class ManagerAuthService {

	private ManagerDao managerDao;
	
	@Autowired
	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}
	
	public ManagerAuthInfo authenticate (String mgr_id, String mgr_pwd) {
		Manager manager = managerDao.selectById(mgr_id);
		if(manager == null) {
			throw new WrongIdPasswordException();
		}
		
		if (!manager.matchPassword(mgr_pwd)) {
			throw new WrongIdPasswordException();
		}
		System.out.println(manager.getCate_id());
		return new ManagerAuthInfo(manager.getMgr_no(), manager.getMgr_id(), 3);
		
	}
	
}
