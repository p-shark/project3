package com.wara.pension.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wara.member.command.BookListCommand;
import com.wara.pension.command.RegisterPension;
import com.wara.pension.command.RegisterRoom;
import com.wara.pension.command.RoomFacilityCommand;
import com.wara.pension.command.SearchPensionCommand;
import com.wara.pension.dao.PensionDao;
import com.wara.pension.dto.Pension;
import com.wara.pension.dto.Room;

@Service
public class PensionService {
	
	private PensionDao pensionDao;
	
	@Autowired
	public void setPensionDao(PensionDao pensionDao) {
		this.pensionDao = pensionDao;
	}

	/* 펜션에 따른 예약목록전부 */
	public List<BookListCommand> bookList(String pen_no) {
		List<BookListCommand> results = pensionDao.selectByBook_penno(pen_no);
		return results;
	}
	
	
	/* 펜션 검색 Service */
	public List<Pension> searchPension(SearchPensionCommand searchPensionCommand) {
		// 선택사항: area, check_in, stay_count, person, facility
		List<Pension> results = pensionDao.selectByMultipleCondition(searchPensionCommand);
		return results;
	}

	public List<Pension> recommendPension(String recommend) {
		List<Pension> results = pensionDao.selectByArea(recommend);
		return results;
	}

	public Object[] pensionInfo(String pen_id) {
		Object[] results = new Object[2];
		Pension pension = pensionDao.selectByPensionId(pen_id);
		results[0] = pension;
		List<RoomFacilityCommand> rooms = pensionDao.selectByPensionIdforRoom(pen_id);
		results[1] = rooms;
		return results;
	}

	public Long registerPension(RegisterPension registerPension, Long owner_id) throws IOException {
		Long pen_no = pensionDao.regist(registerPension, owner_id);
		return pen_no;
	}

	public List<String> findPicPath(int penno) {
		List<String> pension_pic_Path = pensionDao.pensionPicPath(penno);
		return pension_pic_Path;
	}

	public void registerRoom(RegisterRoom registerRoom, int pen_no) throws IOException {
		System.out.println("엥!!");
		int count = registerRoom.getCname().size();
		System.out.println(count);
		for(int i=1; i<=count; i++) {
			System.out.println(i-1);
			int fac_no = pensionDao.registerFacility(registerRoom, i-1);
			pensionDao.registerRoom(registerRoom, i-1, pen_no, fac_no);
		}	
	}
}
