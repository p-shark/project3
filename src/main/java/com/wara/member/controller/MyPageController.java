package com.wara.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wara.member.command.AuthInfo;
import com.wara.member.command.BookListCommand;
import com.wara.member.command.CheckPasswordCommand;
import com.wara.member.command.ModifyCommand;
import com.wara.member.dto.Member;
import com.wara.member.exception.WrongIdPasswordException;
import com.wara.member.service.BookImple;
import com.wara.member.service.ModifyService;
import com.wara.member.validator.CheckPasswordCommandValidator;
import com.wara.member.validator.ModifyCommandValidator;

@Controller
@RequestMapping("mypage")
public class MyPageController {

	private ModifyService modifyService;
	
	@Autowired
	public void setModifyService(ModifyService modifyService) {
		this.modifyService = modifyService;
	}
	
	@Autowired
	BookImple bookDao;
	
	/* 예약 확인 */
	@GetMapping("/checkBooking")
	public String book(Model model, HttpSession session ,@RequestParam(value="book_no", required=false) @Nullable Integer book_no) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		List<BookListCommand> bookList = bookDao.selectByBook_Id(authInfo.getMem_id());
		model.addAttribute("bookList", bookList);
		return "mypage/checkBooking";
	}

	/* 예약 취소*/
	@GetMapping("/cancel")
	public String bookRefresh(Model model, HttpSession session,@RequestParam(value="book_no") int book_no) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		bookDao.updateBookCancel(authInfo.getMem_id(),book_no);
		List<BookListCommand> bookList = bookDao.selectByBook_Id(authInfo.getMem_id());
		model.addAttribute("bookList", bookList);
		return "mypage/checkBooking";
	}	
	
	/* 회원 수정 */
	@GetMapping("/modifyMember/1")
	public String checkPassword_M(Model model) {
		CheckPasswordCommand checkPasswordCommand = new CheckPasswordCommand();
		model.addAttribute("checkPasswordCommand", checkPasswordCommand);
		return "mypage/checkPassword";
	}

	@PostMapping("/modifyMember/2")
	public String checkPasswordForm(CheckPasswordCommand checkPwCmd,
			Errors errors, HttpSession session, Model model) {
		new CheckPasswordCommandValidator().validate(checkPwCmd, errors);
		if (errors.hasErrors()) {
			return "mypage/checkPassword";
		}
		try {
			AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
			// 비밀번호 일치하는지 확인
			modifyService.checkPassword(authInfo.getId(), checkPwCmd.getCurrentPassword());
			// selectById
			Member member = modifyService.changeForm(authInfo.getId());
			model.addAttribute("modi", member);
			// modifyCommand 만들어줌
			model.addAttribute("modifyCommand", new ModifyCommand());
			return "mypage/modifyForm";
		} catch (WrongIdPasswordException e) {
			errors.rejectValue("currentPassword", "notMatching");
			return "mypage/checkPassword";
		}
	}
	
	@PostMapping("/modifyMember/3")
	public String modifyMember(ModifyCommand modifyCommand, Errors errors,HttpSession session) {
		new ModifyCommandValidator().validate(modifyCommand, errors);
		if (errors.hasErrors()) {
			return "mypage/modifyForm";
		}
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		Member member = new Member(authInfo.getMem_id(), modifyCommand.getName(), authInfo.getId(), 
				modifyCommand.getPassword(), modifyCommand.getEmail(), modifyCommand.getPhone(),authInfo.getCate_id());
		modifyService.modifyMember(member);
		return "mypage/checkBooking";
	}
	
	/* 회원 탈퇴 */
	@GetMapping("/leaveMember/1")
	public String checkPassword_L(Model model) {
		CheckPasswordCommand checkPasswordCommand = new CheckPasswordCommand();
		model.addAttribute("checkPasswordCommand", checkPasswordCommand);
		return "mypage/checkPassword";
	}
	
	@PostMapping("/leaveMember/2")
	public String checkPasswordForm_L(CheckPasswordCommand checkPwCmd,
			Errors errors, HttpSession session, Model model) {
		new CheckPasswordCommandValidator().validate(checkPwCmd, errors);
		if (errors.hasErrors()) {
			return "mypage/checkPassword";
		}
		
		try {
			AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
			// 비밀번호 일치하는지 확인
			modifyService.checkPassword(authInfo.getId(), checkPwCmd.getCurrentPassword());
			return "mypage/LeaveMember";
		} catch (WrongIdPasswordException e) {
			errors.rejectValue("currentPassword", "notMatching");
			return "mypage/checkPassword";
		}
	}
	
	@PostMapping("/leaveMember/3")
	public String leaveMember(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		modifyService.leaveMember(authInfo.getMem_id());
	    // 로그아웃
	    session.invalidate();
		return "redirect:/";
	}
}
