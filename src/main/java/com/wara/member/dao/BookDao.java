package com.wara.member.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wara.member.command.BookListCommand;

public interface BookDao {

	List<BookListCommand> selectByBook_Id(Long id);
	List<BookListCommand> bookList(Long owner_no);
	
}

