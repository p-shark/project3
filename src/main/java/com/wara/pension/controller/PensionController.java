package com.wara.pension.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wara.member.command.BookListCommand;
import com.wara.owner.command.OwnerAuthInfo;
import com.wara.pension.command.RegisterPension;
import com.wara.pension.command.RegisterRoom;
import com.wara.pension.command.RoomFacilityCommand;
import com.wara.pension.command.SearchPensionCommand;
import com.wara.pension.dto.Pension;
import com.wara.pension.dto.Room;
import com.wara.pension.service.PensionService;

@Controller
public class PensionController {
	private static final Log logger = LogFactory.getLog(PensionController.class);

	private PensionService pensionService;
	
	@Autowired
	public void setPensionService(PensionService pensionService) {
		this.pensionService = pensionService;
	}
	
	/* 펜션 검색 Controller */
	@RequestMapping("/searchPension")
	public String search (SearchPensionCommand searchPensionCommand, Model model) {
		System.out.println(searchPensionCommand.getSwim());
		String area = searchPensionCommand.getSido1()+searchPensionCommand.getGugun1();
		SearchPensionCommand searchCmd = new SearchPensionCommand(
				area, searchPensionCommand.getSido1(), searchPensionCommand.getGugun1(),
				searchPensionCommand.getCheckIn(), searchPensionCommand.getStay_count(), 
				searchPensionCommand.getPerson(), searchPensionCommand.getSwim(), 
				searchPensionCommand.getSpa(), searchPensionCommand.getMul(), 
				searchPensionCommand.getSingle(), searchPensionCommand.getView(), 
				searchPensionCommand.getBar_ter(), searchPensionCommand.getBar_toge());
		List<Pension> results = pensionService.searchPension(searchCmd);
		model.addAttribute("searchPensionCommand", searchCmd);
		model.addAttribute("searchResults", results);
		return "search/searchResult";
	}
	
	@GetMapping("/recommendation")
	public String managerPage() {
		return "search/recommendation";
	}
	
	@GetMapping("/recommend")
	public String recommend (@RequestParam(value = "recommend", defaultValue = "false") String recommend, Model model) {
		List<Pension> results = pensionService.recommendPension(recommend);
		model.addAttribute("recommend", recommend);
		model.addAttribute("searchResults", results);
		return "search/recommend";
	}
	
	@GetMapping("/searchPension/pensionInfo")
	public String pensionInfo(@RequestParam(value = "pen_id", defaultValue = "false") String pen_id, Model model) {
		Object[] results = pensionService.pensionInfo(pen_id);
		Pension pension = (Pension) results[0];
		
		List<RoomFacilityCommand> rooms = (List<RoomFacilityCommand>) results[1];
		List<BookListCommand> books = pensionService.bookList(pen_id);
		
		model.addAttribute("books", books);
		model.addAttribute("pension", pension);
		model.addAttribute("rooms", rooms);
		return "search/pensionInfo";
	}
	
	/* 펜션 회원가입 Controller */
	@PostMapping("/owner/step1")
	public String step1() {
		return "registerPension/step1";
	}
	
	@PostMapping("/owner/step2")
	public String step2(@Nullable RegisterPension registerPension, Model model, HttpSession session) throws IOException {
		OwnerAuthInfo ownerAuthInfo = (OwnerAuthInfo) session.getAttribute("authInfo");
		Long owner_id = ownerAuthInfo.getOwner_no();
		Long pen_no = pensionService.registerPension(registerPension, owner_id);
		model.addAttribute("pen_no", pen_no);
		return "registerPension/step2";
	}
	
	@GetMapping("/owner/step3")
	public String step3(RegisterRoom registerRoom, Model model,HttpServletRequest request) throws IOException {
		System.out.println(registerRoom.getCswim().get(0));
		System.out.println(registerRoom.getCspa().get(0));
		int pen_no = Integer.parseInt(request.getParameter("pen_no"));
		System.out.println(pen_no);
		pensionService.registerRoom(registerRoom, pen_no);
		return "registerPension/step3";
	}
	
	/* 사진 올리기 */
	@RequestMapping(value="/owner/pensionPic", method=RequestMethod.POST)
	// @ResponseBody를 사용해주면 view를 생성해주는것이 아니라, JSON 혹은 Object 형태로 데이터를 넘겨준다.
	public @ResponseBody List<String> pensionPicNo1(HttpServletRequest request) {
		int penno = Integer.parseInt(request.getParameter("pen_no"));
		return pensionService.findPicPath(penno);
	}
	
	@RequestMapping(value="/owner/pensionPic", method=RequestMethod.GET)
	 // @ResponseBody를 사용해주면 view를 생성해주는것이 아니라, JSON 혹은 Object 형태로 데이터를 넘겨준다.
	public @ResponseBody List<String> pensionPicNo2(HttpServletRequest request) {
		int penno = Integer.parseInt(request.getParameter("pen_no"));
		return pensionService.findPicPath(penno);
	}
	
	
	
}
