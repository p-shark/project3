package com.wara.member.command;

import java.util.Date;

public class BookListCommand {

	 private int book_no;
	 private int room_no;
	 private int pen_no;
	 private Date book_date;
	 private Date check_in;
	 private Date check_out;
	 private int stay_count;
	 private int room_amount;
	 private String room_name;
	 private String pen_name;
	 private boolean book_checks;
	 private long mem_id;
	 private long owner_no;
	 
	 
	 
	 
	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	public int getPen_no() {
		return pen_no;
	}

	public void setPen_no(int pen_no) {
		this.pen_no = pen_no;
	}

	public BookListCommand(int book_no, int room_no, int pen_no, Date book_date, Date check_in, Date check_out,
			int stay_count, int room_amount, String room_name, String pen_name, boolean book_checks) {
		this.book_no = book_no;
		this.room_no = room_no;
		this.pen_no = pen_no;
		this.book_date = book_date;
		this.check_in = check_in;
		this.check_out = check_out;
		this.stay_count = stay_count;
		this.room_amount = room_amount;
		this.room_name = room_name;
		this.pen_name = pen_name;
		this.book_checks = book_checks;
	}
	
	public BookListCommand(int room_no, int pen_no, Date book_date, Date check_in, Date check_out, int stay_count, int room_amount, String room_name, String pen_name, boolean book_checks) {
		this.room_no = room_no;
		this.pen_no = pen_no;
		this.book_date = book_date;
		this.check_in = check_in;
		this.check_out = check_out;
		this.stay_count = stay_count;
		this.room_amount = room_amount;
		this.room_name = room_name;
		this.pen_name = pen_name;
		this.book_checks = book_checks;
	}


	public BookListCommand(Date book_date, Date check_in, Date check_out, int stay_count, int room_amount, String room_name, String pen_name, boolean book_checks) {
		this.book_date = book_date;
		this.check_in = check_in;
		this.check_out = check_out;
		this.stay_count = stay_count;
		this.room_amount = room_amount;
		this.room_name = room_name;
		this.pen_name = pen_name;
		this.book_checks = book_checks;
	}

	public int getBook_no() {
		return book_no;
	}

	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}

	public Date getBook_date() {
		return book_date;
	}

	public void setBook_date(Date book_date) {
		this.book_date = book_date;
	}

	public Date getCheck_in() {
		return check_in;
	}

	public void setCheck_in(Date check_in) {
		this.check_in = check_in;
	}

	public Date getCheck_out() {
		return check_out;
	}

	public void setCheck_out(Date check_out) {
		this.check_out = check_out;
	}

	public int getStay_count() {
		return stay_count;
	}

	public void setStay_count(int stay_count) {
		this.stay_count = stay_count;
	}

	public int getRoom_amount() {
		return room_amount;
	}

	public void setRoom_amount(int room_amount) {
		this.room_amount = room_amount;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getPen_name() {
		return pen_name;
	}

	public void setPen_name(String pen_name) {
		this.pen_name = pen_name;
	}

	public boolean isBook_checks() {
		return book_checks;
	}

	public void setBook_checks(boolean book_checks) {
		this.book_checks = book_checks;
	}

	public long getMem_id() {
		return mem_id;
	}

	public void setMem_id(long mem_id) {
		this.mem_id = mem_id;
	}

	public long getOwner_no() {
		return owner_no;
	}

	public void setOwner_no(long owner_no) {
		this.owner_no = owner_no;
	}
}
