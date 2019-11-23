package com.wara.member.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.wara.member.command.BookListCommand;
import com.wara.member.dao.BookDao;

@Repository
public class BookImple implements BookDao {

private JdbcTemplate jdbcTemplate;
	
	private RowMapper<BookListCommand> bookRowMapper = 
			new RowMapper<BookListCommand>() {
				@Override
				public BookListCommand mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					BookListCommand bookListCommand = new BookListCommand(
							rs.getDate("book_date"),
							rs.getDate("check_in"),
							rs.getDate("check_out"),
							rs.getInt("stay_count"),
							rs.getInt("room_amount"),
							rs.getString("room_name"),
							rs.getString("pen_name"),
							rs.getBoolean("book_checks"));
					bookListCommand.setBook_no(rs.getInt("book_no"));

					return bookListCommand;
				}
			};
			
	@Autowired
	public BookImple(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public List<BookListCommand> selectByBook_Id(Long mem_no) {
		List<BookListCommand> results = jdbcTemplate.query(
				"select * from book b, room r,pension p where b.room_no = r.room_no and r.pen_no = p.pen_no and b.mem_no= ?",
				bookRowMapper, mem_no);
		return results.isEmpty() ? null : results;
	}


	public void updateBookCancel(Long mem_no, Integer book_no) {
		jdbcTemplate.update(
			"update book set book_checks = 0 where mem_no = ? and book_no = ?",
			mem_no, book_no);
	}
	
	@Override
	public List<BookListCommand> bookList(Long owner_no) {
		List<BookListCommand> result =  jdbcTemplate.query(
				"select * from book b, room r, pension p, owner o where b.room_no = r.room_no and r.pen_no = p.pen_no and o.pen_no = p.pen_no and b.book_checks=1 and o.owner_no=?", bookRowMapper, owner_no);
		return result.isEmpty() ? null : result;
	}
	
}
