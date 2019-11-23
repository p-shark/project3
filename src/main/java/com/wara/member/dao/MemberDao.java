package com.wara.member.dao;

import org.springframework.stereotype.Component;

import com.wara.member.dto.Member;

@Component
public interface MemberDao {

	Member selectById(String id);

	void changeMember(Member member);

	void deleteMember(Long mem_id);

	void insert(Member Member);

}
