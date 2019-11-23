package com.wara.owner.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wara.owner.command.OwnerAuthInfo;
import com.wara.owner.dao.OwnerDao;
import com.wara.owner.dto.Owner;
import com.wara.owner.exception.WrongIdPasswordException;

/* 세션에 로그인 정보를 다는 서비스 클래스 */
@Service
public class OwnerAuthService {

	private OwnerDao ownerDao;
	
	@Autowired
	public void setOwnerDao(OwnerDao ownerDao) {
		this.ownerDao = ownerDao;
	}
	
	public OwnerAuthInfo authenticate (String owner_id, String owner_pwd) {
		Owner owner = ownerDao.selectById(owner_id);
		if(owner == null) {
			throw new WrongIdPasswordException();
		}
		
		if (!owner.matchPassword(owner_pwd)) {
			throw new WrongIdPasswordException();
		}
		System.out.println(owner.getCate_id());
		return new OwnerAuthInfo(owner.getOwner_no(), owner.getOwner_id(), owner.getOwner_name(), 2);
		
	}
	
}
