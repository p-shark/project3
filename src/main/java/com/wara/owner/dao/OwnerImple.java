package com.wara.owner.dao;

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

import com.wara.owner.dto.Owner;

@Component
public class OwnerImple implements OwnerDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public OwnerImple(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private RowMapper<Owner> ownRowMapper = 
			new RowMapper<Owner>() {
				@Override
				public Owner mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Owner owner = new Owner(
							rs.getString("owner_id"),
							rs.getString("owner_pwd"),
							rs.getString("owner_name"),
							rs.getString("owner_email"),
							rs.getString("owner_phone"),
							rs.getString("owner_content"),
							rs.getBoolean("loginCheck"));
							rs.getInt("cate_id");
					owner.setOwner_no(rs.getLong("owner_no"));
					return owner;
				}
			};

	@Override
	public Owner selectById(String owner_id) {
		List<Owner> results = jdbcTemplate.query(
				"select * from owner where owner_id = ?",
				ownRowMapper,owner_id);
		return results.isEmpty() ? null : results.get(0);
	}

	@Override
	public void insert(Owner owner) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement(
						"insert into owner (owner_id, owner_pwd, owner_name, owner_email, "
						+ "owner_phone, owner_content, loginCheck, cate_id) " +
								"values (?, ?, ?, ?, ?, ?,false, 2)",
						new String[] { "owner_no" });
				// 인덱스 파라미터 값 설정
				pstmt.setString(1, owner.getOwner_id());
				pstmt.setString(2, owner.getOwner_pwd());
				pstmt.setString(3, owner.getOwner_name());
				pstmt.setString(4, owner.getOwner_email());
				pstmt.setString(5, owner.getOwner_phone());
				pstmt.setString(6, owner.getOwner_content());
				// 생성한 PreparedStatement 객체 리턴
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		owner.setOwner_no(keyValue.longValue());
	}
	
	@Override
	public List<Owner> selectByNo(Long owner_no) {
		List<Owner> results = jdbcTemplate.query(
				"select * from owner where owner_no=?",
				ownRowMapper, owner_no);
		return results.isEmpty() ? null : results;
	}

	@Override
	public void updateLogincheck(Long owner_no) {
		jdbcTemplate.update(
			"update owner set logincheck=true where owner_no=?", owner_no);
	}
	
	@Override
	public List<Owner> selectAll() {
		List<Owner> results = (List<Owner>) jdbcTemplate.query("select * from owner", ownRowMapper);
		System.out.println("results>>>>>>>>>>>>>>>>>>>" + results.get(0).getCate_id());
		return results; 
	}

	

	
	

}
