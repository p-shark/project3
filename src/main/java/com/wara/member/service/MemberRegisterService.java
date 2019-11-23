package com.wara.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wara.member.command.RegisterRequest;
import com.wara.member.dao.MemberDao;
import com.wara.member.dto.Member;
import com.wara.member.exception.DuplicateMemberException;

@Service
public class MemberRegisterService {
	private MemberDao memberDao;
	
	@Autowired
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public Long regist(RegisterRequest req) {
		Member member = memberDao.selectById(req.getId());
		if (member != null) {
			throw new DuplicateMemberException("dup id " + req.getId());
		}
		Member newMember = new Member(
				req.getName(), req.getId(), req.getPassword(), req.getEmail(), req.getPhone());
		memberDao.insert(newMember);
		return newMember.getMem_id();
	}
}
