package com.wara.manager.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.wara.pension.dto.Pension;

@Repository
public class TestDaoImpl implements TestDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public TestDaoImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/* Pension */
	private RowMapper<Pension> penRowMapper = new RowMapper<Pension>() {
		@Override
		public Pension mapRow(ResultSet rs, int rowNum) throws SQLException {
			Pension pension = new Pension(rs.getString("pen_name"), rs.getString("pen_address"),
					rs.getString("pen_phone"), rs.getDate("peak_end"), rs.getDate("peak_start"),
					rs.getString("pen_info"), rs.getBoolean("pen_pickup"), rs.getInt("owner_no"),
					rs.getString("pen_area"));
					pension.setPen_id(rs.getInt("pen_no"));
			return pension;
		}
	};

	@Override
	public List<Pension> selectBySelectedPenNo(List<String> param) {
		System.out.println(param + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");

		StringBuilder sql = new StringBuilder("select * from pension where pen_no in (");
		for (int i = 0; i < param.size(); i++) {
			sql = i < (param.size() - 1) ? sql.append("?,") : sql.append("?)");
		}
		
		System.out.println(sql + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  ");
		String sqlKing = sql.toString();
		List<Pension> results = jdbcTemplate.query(sqlKing, new PreparedStatementSetter() {

			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				for (int i = 1; i <= param.size(); i++) {
					preparedStatement.setString(i, param.get(i-1));
				}
			}
		}, penRowMapper);
		return results;
	}

}
