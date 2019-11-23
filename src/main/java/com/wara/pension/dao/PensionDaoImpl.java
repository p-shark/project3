package com.wara.pension.dao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.wara.member.command.BookListCommand;
import com.wara.member.dto.Member;
import com.wara.pension.command.RegisterPension;
import com.wara.pension.command.RegisterRoom;
import com.wara.pension.command.RoomFacilityCommand;
import com.wara.pension.command.SearchPensionCommand;
import com.wara.pension.dto.Pension;
import com.wara.pension.dto.PensionPic;
import com.wara.pension.dto.Room;

@Repository
public class PensionDaoImpl implements PensionDao{
	private static final String SAVE_PATH = "c:\\upload\\";
	
	private JdbcTemplate jdbcTemplate;	
	@Autowired
	public PensionDaoImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/* Pension */
	private RowMapper<Pension> penRowMapper = new RowMapper<Pension>() {
		@Override
		public Pension mapRow(ResultSet rs, int rowNum) throws SQLException {
			Pension pension = new Pension( 
					rs.getString("pen_name"), 
					rs.getString("pen_address"), 
					rs.getString("pen_phone"),
					rs.getDate("peak_end"), 
					rs.getDate("peak_start"), 
					rs.getString("pen_info"), 
					rs.getBoolean("pen_pickup"),
					rs.getInt("owner_no"), 
					rs.getString("pen_area"));
			pension.setPen_id(rs.getInt("pen_no"));
			return pension;
		}
	};
	
	/* Room */
	private RowMapper<Room> roomRowMapper = new RowMapper<Room>() {
		@Override
		public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
			Room room = new Room( 
					rs.getInt("room_amount"),
					rs.getString("room_name"), 
					rs.getString("room_size"), 
					rs.getString("room_photo"),
					rs.getInt("nopeak_week"), 
					rs.getInt("nopeak_weekend"), 
					rs.getInt("peak_week"),
					rs.getInt("peak_weekend"), 
					rs.getInt("pen_no"), 
					rs.getInt("fac_no"));
			room.setRoom_no(rs.getInt("room_no"));
			return room;
		}
	};
	
	/* RoomFacility */
	private RowMapper<RoomFacilityCommand> roomfacilityRowMapper = new RowMapper<RoomFacilityCommand>() {
		@Override
		public RoomFacilityCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
			RoomFacilityCommand roomfacility = new RoomFacilityCommand (
							rs.getInt("room_no"),
							rs.getInt("room_amount"),
							rs.getString("room_name"), 
							rs.getString("room_size"), 
							rs.getInt("nopeak_week"), 
							rs.getInt("nopeak_weekend"), 
							rs.getInt("peak_week"),
							rs.getInt("peak_weekend"),
							rs.getBoolean("swim"),
							rs.getBoolean("spa"),
							rs.getBoolean("mul"),
							rs.getBoolean("single"),
							rs.getBoolean("view"),
							rs.getBoolean("bar_ter"),
							rs.getBoolean("bar_toge"));
			return roomfacility;
		}
	};


	/* BookListCommand */
	private RowMapper<BookListCommand> bookRowMapper = 
			new RowMapper<BookListCommand>() {
				@Override
				public BookListCommand mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					BookListCommand bookListCommand = new BookListCommand(
							rs.getInt("room_no"),
							rs.getInt("pen_no"),
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

			
	@Override
	public List<BookListCommand> selectByBook_penno(String pen_no) {
		List<BookListCommand> results = jdbcTemplate.query(
				"select * from book b natural join room r natural join pension p where b.pen_no = ? ",
				bookRowMapper, pen_no );
		return results.isEmpty() ? null : results;
	}

	
	private RowMapper<String> pensionpicRowMapper = new RowMapper<String>() {

		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			String pic_path = rs.getString("pension_pic_path");
			return pic_path;
		}
		
	};

	@Override
	public List<Pension> selectByMultipleCondition(SearchPensionCommand searchCmd) {
		// 선택사항: area, check_in, stay_count, person, facility
		// pension : area
		// book : check_in, stay_count
		// room : person
		// facility : facility
		
		String sql = "select distinct p.* from  room r natural join facility f natural join pension p where ";
		
		/* check_in SQL */
		sql += "pen_no not in (select p.pen_no from book b natural join room r natural join facility f natural join pension p " + 
				"where '"+searchCmd.getCheckIn()+"' between check_in and DATE_SUB(check_out, INTERVAL 1 DAY)) ";
		
		if(searchCmd.getStay_count()>=1) {
			for(int i=1; i<=(searchCmd.getStay_count()-1); i++) {
				sql+= "and pen_no not in "
						+ "(select p.pen_no from book b natural join room r natural join facility f natural join pension p "
						+ "where DATE_ADD('"+searchCmd.getCheckIn()+"', INTERVAL "+i+" DAY) between check_in and DATE_SUB(check_out, INTERVAL 1 DAY))";
			}
		}
		
		/* facility SQL */
		if(searchCmd.getSwim().equals("1")) {
			sql += "and swim=1 ";
		} 
		
		if (searchCmd.getSpa().equals("1")) {
			sql += "and spa=1 ";
		} 
		
		if (searchCmd.getMul().equals("1")) {
			sql += "and mul=1 ";
		} 
		
		if (searchCmd.getSingle().equals("1")) {
			sql += "and single=1 ";
		} 
		
		if (searchCmd.getView().equals("1")) {
			sql += "and view=1 ";
		} 
		
		if (searchCmd.getBar_ter().equals("1")) {
			sql += "and bar_ter=1 ";
		} 
		
		if (searchCmd.getBar_toge().equals("1")) {
			sql += "and bar_toge=1 ";
		}
		
		/* amount SQL */
		sql += "and "+searchCmd.getPerson()+"<=room_amount ";
		
		/* area SQL */
		sql += "and p.pen_area = '"+searchCmd.getArea()+"'";
		
		List<Pension> results = jdbcTemplate.query(sql,penRowMapper);
		return results.isEmpty() ? null : results;
	}

	@Override
	public List<Pension> selectByArea(String recommend) {
		String sql="select * from pension where pen_area like '%"+recommend+"%'";
		List<Pension> results = jdbcTemplate.query(
				sql, penRowMapper);
		return results;
	}

	@Override
	public Pension selectByPensionId(String pen_id) {
		List<Pension> results = jdbcTemplate.query("select * from pension where pen_no = ?", penRowMapper,pen_id);
		return results.isEmpty() ? null : results.get(0);
	}

	@Override
	public List<RoomFacilityCommand> selectByPensionIdforRoom(String pen_id) {
		List<RoomFacilityCommand> results = jdbcTemplate.query(
				"select * from room natural join facility natural join pension where pen_no=?"
				, roomfacilityRowMapper,pen_id);
		return results;
	}
	
	@Override
	public Long regist(RegisterPension registerPension, Long owner_id) throws IOException {
		Date peak_start = Date.valueOf(registerPension.getPeak_start());
		Date peak_end = Date.valueOf(registerPension.getPeak_end());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement(
						"insert into pension (pen_name , pen_address, pen_phone, peak_start , peak_end ,  pen_info , pen_pickup , pen_area ,owner_no) "
						+ "values(?,?,?,?,?,?,?,substring_index(?,' ',2),?)",
						new String[] { "pen_no" });
				// 인덱스 파라미터 값 설정
				pstmt.setString(1, registerPension.getName());
				pstmt.setString(2, registerPension.getAddress());
				pstmt.setString(3, registerPension.getPhone());
				pstmt.setDate(4, peak_start);
				pstmt.setDate(5, peak_end);
				pstmt.setString(6, registerPension.getInfo());
				pstmt.setBoolean(7, registerPension.getPickup());
				pstmt.setString(8, registerPension.getAddress());
				pstmt.setLong(9, owner_id);
				// 생성한 PreparedStatement 객체 리턴
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		Long pen_no = keyValue.longValue();
		
		/*사진 업로드*/
		insertPic(registerPension, pen_no);
		return pen_no;
	}
	
	private void insertPic(RegisterPension registerPension, Long pen_no) throws IOException {
		MultipartFile[] uploadFile = registerPension.getFile();
		//temp 폴더에 있는 File을 특정 폴더에 복사(경로 지정. 해당 경로를 db에 저장)
		
		for(MultipartFile m : uploadFile) {
			String fileName = registerPension.getName() + "-" + m.getOriginalFilename();
	        FileCopyUtils.copy(m.getBytes(), new File(SAVE_PATH + fileName));
	        jdbcTemplate.update("insert into pension_pic(pension_pic_path, pen_no) values(?,?)", fileName, pen_no);
		}
	}

	@Override
	public List<String> pensionPicPath(int penno) {
		List<String> results = jdbcTemplate.query("select pension_pic_path from pension_pic where pen_no = ?", pensionpicRowMapper,penno);
		return results.isEmpty() ? null : results;
	}

	@Override
	public int registerFacility(RegisterRoom registerRoom, int i) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"insert into facility (swim, spa, mul, single, view, bar_ter, bar_toge) " +
								"values (?, ?, ?, ?, ?, ?, ?)",
						new String[] { "fac_no" });
				// 인덱스 파라미터 값 설정
				pstmt.setString(1, registerRoom.getCswim().get(i));
				pstmt.setString(2, registerRoom.getCspa().get(i));
				pstmt.setString(3, registerRoom.getCmul().get(i));
				pstmt.setString(4, registerRoom.getCsingle().get(i));
				pstmt.setString(5, registerRoom.getCview().get(i));
				pstmt.setString(6, registerRoom.getCbar_ter().get(i));
				pstmt.setString(7, registerRoom.getCbar_toge().get(i));
				// 생성한 PreparedStatement 객체 리턴
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		int fac_no = keyValue.intValue();
		return fac_no;
	}

	@Override
	public void registerRoom(RegisterRoom registerRoom, int i, int pen_no, int fac_no) throws IOException {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"insert into room (room_amount, room_name, room_size, nopeak_week, nopeak_weekend, peak_week, peak_weekend, pen_no, fac_no) " +
								"values (?, ?, ?, ?, ?, ?, ?, ?, ?)",
						new String[] { "fac_no" });
				// 인덱스 파라미터 값 설정
				pstmt.setInt(1, registerRoom.getCamount().get(i));
				pstmt.setString(2, registerRoom.getCname().get(i));
				pstmt.setString(3, registerRoom.getCsize().get(i));
				pstmt.setInt(4, registerRoom.getCnopeak_week().get(i));
				pstmt.setInt(5, registerRoom.getCnopeak_weekend().get(i));
				pstmt.setInt(6, registerRoom.getCpeak_week().get(i));
				pstmt.setInt(7, registerRoom.getCpeak_weekend().get(i));
				pstmt.setInt(7, pen_no);
				pstmt.setInt(7, fac_no);
				// 생성한 PreparedStatement 객체 리턴
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		int room_no = keyValue.intValue();
		
		/*사진 업로드*/
		insertRoomPic(registerRoom, room_no, pen_no, i);
	}

	private void insertRoomPic(RegisterRoom registerRoom, int room_no, int pen_no, int i) throws IOException {
		MultipartFile[] uploadFile = registerRoom.getCfile().get(i);
		//temp 폴더에 있는 File을 특정 폴더에 복사(경로 지정. 해당 경로를 db에 저장)
		
		for(MultipartFile m : uploadFile) {
			String fileName = pen_no + "-" + registerRoom.getCname().get(i) + "-" + m.getOriginalFilename();
	        FileCopyUtils.copy(m.getBytes(), new File(SAVE_PATH + fileName));
	        jdbcTemplate.update("insert into room_pic(room_pic_path, room_no) values(?,?)", fileName, room_no);
		}
	}
}
