package com.wara.pension.dao;

import java.io.IOException;
import java.util.List;

import com.wara.member.command.BookListCommand;
import com.wara.pension.command.RegisterPension;
import com.wara.pension.command.RegisterRoom;
import com.wara.pension.command.RoomFacilityCommand;
import com.wara.pension.command.SearchPensionCommand;
import com.wara.pension.dto.Pension;

public interface PensionDao {
	
	public List<Pension> selectByMultipleCondition(SearchPensionCommand searchPensionCommand);
	public List<Pension> selectByArea(String recommend);
	public Pension selectByPensionId(String pen_id);
	public List<RoomFacilityCommand> selectByPensionIdforRoom(String pen_id);
	Long regist(RegisterPension registerPension, Long owner_id) throws IOException;
	public List<String> pensionPicPath(int penno);
	public int registerFacility(RegisterRoom registerRoom, int i);
	public void registerRoom(RegisterRoom registerRoom, int i, int pen_no, int fac_no) throws IOException;

	List<BookListCommand> selectByBook_penno(String pen_no);
}
