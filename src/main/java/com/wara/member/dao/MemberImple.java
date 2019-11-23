package com.wara.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.wara.member.command.BookListCommand;
import com.wara.member.dto.Member;

@Component
public class MemberImple implements MemberDao{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MemberImple(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private RowMapper<Member> memRowMapper = 
			new RowMapper<Member>() {
				@Override
				public Member mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Member member = new Member(
							rs.getString("mem_name"),
							rs.getString("mem_id"),
							rs.getString("mem_pwd"),
							rs.getString("mem_email"),
							rs.getString("mem_phone"),
							rs.getInt("cate_id"));
					member.setMem_id(rs.getLong("mem_no"));
					return member;
				}
			};
			
	@Override
	public Member selectById(String id) {
		List<Member> results = jdbcTemplate.query(
				"select * from members where mem_id = ?",
				memRowMapper,id);
		return results.isEmpty() ? null : results.get(0);
	}

	@Override
	public void changeMember(Member member) {
		jdbcTemplate.update(
			"update MEMBERS set mem_pwd = ?, mem_NAME = ?, mem_EMAIL = ?, mem_PHONE = ? where MEM_NO=?",
			member.getPassword(),member.getName(),member.getEmail(),member.getPhone(), member.getMem_id());
	}

	@Override
	public void deleteMember(Long mem_id) {
		jdbcTemplate.update(
			"delete from MEMBERS where MEM_NO=?", mem_id);
	}

	@Override
	public void insert(Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement(
						"insert into members (mem_name, mem_id, mem_pwd, mem_email, mem_phone, cate_id) " +
								"values (?, ?, ?, ?, ?, 1)",
						new String[] { "mem_no" });
				// 인덱스 파라미터 값 설정
				pstmt.setString(1, member.getName());
				pstmt.setString(2, member.getId());
				pstmt.setString(3, member.getPassword());
				pstmt.setString(4, member.getEmail());
				pstmt.setString(5, member.getPhone());
				// 생성한 PreparedStatement 객체 리턴
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setMem_id(keyValue.longValue());
	}
}
