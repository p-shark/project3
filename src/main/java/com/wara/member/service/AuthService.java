package com.wara.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wara.member.command.AuthInfo;
import com.wara.member.dao.MemberDao;
import com.wara.member.dto.Member;
import com.wara.member.exception.WrongIdPasswordException;

/* 세션에 로그인 정보를 다는 서비스 클래스 */
@Service
public class AuthService {
	private MemberDao memberDao;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public AuthInfo authenticate (String id, String password) {
		Member member = memberDao.selectById(id);
		
		if(member == null) {
			throw new WrongIdPasswordException();
		}
		
		if (!member.matchPassword(password)) {
			throw new WrongIdPasswordException();
		}
		
		return new AuthInfo(member.getMem_id(), member.getId(), member.getName(), member.getCate_id());
	}
}
