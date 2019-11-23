package com.wara.owner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wara.owner.command.OwnerRegisterRequest;
import com.wara.owner.dao.OwnerDao;
import com.wara.owner.dto.Owner;
import com.wara.owner.exception.DuplicateOwnerException;

@Service
public class OwnerRegisterService {
	
	private OwnerDao ownerDao;
	
	@Autowired
	public OwnerRegisterService(OwnerDao ownerDao) {
		this.ownerDao = ownerDao;
	}
	
	public Long regist(OwnerRegisterRequest req) {
		Owner owner = ownerDao.selectById(req.getOwner_id());
		if (owner != null) {
			throw new DuplicateOwnerException("dup id " + req.getOwner_id());
		}
		Owner newOwner = new Owner(
				req.getOwner_id(), req.getOwner_pwd(), req.getOwner_name(), req.getOwner_email(), req.getOwner_phone(), req.getOwner_content());
		ownerDao.insert(newOwner);
		return newOwner.getOwner_no();
	}
}
