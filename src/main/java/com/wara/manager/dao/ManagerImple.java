package com.wara.manager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.wara.manager.dto.Manager;
import com.wara.owner.dto.Owner;

@Component
public class ManagerImple implements ManagerDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ManagerImple(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private RowMapper<Manager> manRowMapper = 
			new RowMapper<Manager>() {
				@Override
				public Manager mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Manager manager = new Manager(
							rs.getString("mgr_id"),
							rs.getString("mgr_pwd"));
							rs.getInt("cate_id");
							manager.setMgr_no(rs.getLong("mgr_no"));
					return manager;
				}
			};

	@Override
	public Manager selectById(String mgr_id) {
		List<Manager> results = jdbcTemplate.query(
				"select * from manager where mgr_id = ?",
				manRowMapper,mgr_id);
		return results.isEmpty() ? null : results.get(0);
	}

	
}
