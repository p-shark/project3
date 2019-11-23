package com.wara.member.dto;

import java.util.Date;

public class Book {
	  private int book_id;
	  private Date book_date;
	  private Date stay_date;
	  private int stay_count;
	  private int checks;
	  private int room_id;
	  private int mem_id;
	  
	public Book(Date book_date, Date stay_date, 
			int stay_count, int checks, int room_id, int mem_id) {
		this.book_date = book_date;
		this.stay_date = stay_date;
		this.stay_count = stay_count;
		this.checks = checks;
		this.room_id = room_id;
		this.mem_id = mem_id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public Date getBook_date() {
		return book_date;
	}

	public void setBook_date(Date book_date) {
		this.book_date = book_date;
	}

	public Date getStay_date() {
		return stay_date;
	}

	public void setStay_date(Date stay_date) {
		this.stay_date = stay_date;
	}

	public int getStay_count() {
		return stay_count;
	}

	public void setStay_count(int stay_count) {
		this.stay_count = stay_count;
	}

	public int getChecks() {
		return checks;
	}

	public void setChecks(int checks) {
		this.checks = checks;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getMem_id() {
		return mem_id;
	}

	public void setMem_id(int mem_id) {
		this.mem_id = mem_id;
	}
	
	
	  
}
