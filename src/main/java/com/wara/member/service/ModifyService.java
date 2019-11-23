package com.wara.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wara.member.dao.MemberDao;
import com.wara.member.dto.Member;
import com.wara.member.exception.WrongIdPasswordException;

/*회원 수정을 하기위한 서비스 클래스*/
@Service
public class ModifyService {

	private MemberDao memberDao;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void checkPassword(String id, String password) {
		Member member = memberDao.selectById(id);
		if (!member.matchPassword(password)) {
			throw new WrongIdPasswordException();
		}
	}
	
	public 	Member changeForm(String id) {
		Member member = memberDao.selectById(id);
		return member;
	}
	
	public Member modifyMember(Member member) {
		memberDao.changeMember(member);
		return member;
	}

	public void leaveMember(Long mem_id) {
		memberDao.deleteMember(mem_id);
	}
}
