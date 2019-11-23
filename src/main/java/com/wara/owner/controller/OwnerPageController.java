package com.wara.owner.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wara.member.command.BookListCommand;
import com.wara.member.dao.BookDao;
import com.wara.owner.command.OwnerAuthInfo;

@Controller
@RequestMapping("ownerPage")
public class OwnerPageController {

	private BookDao bookDao;

	@Autowired
	private void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@GetMapping
	public String ownerPage() {
		return "owner/ownerPage";
	}

	/* 예약 확인 */
	@GetMapping("/confirmBooking")
	public String confirm(Model model, HttpSession session) {
		OwnerAuthInfo authInfo = (OwnerAuthInfo) session.getAttribute("authInfo");
		List<BookListCommand> books = bookDao.bookList(authInfo.getOwner_no());
		model.addAttribute("books", books);
		return "/owner/confirmBooking";
	}

}
