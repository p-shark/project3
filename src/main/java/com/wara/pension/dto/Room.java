package com.wara.pension.dto;

public class Room {
	private int room_no;
	private String name; /* 방이름 */
	private int amount;
	private String size; /* 크기 */
	private int nopeak_week; /* 비수기 주중 */
	private int nopeak_weekend; /* 비수기 주말 */
	private int peak_week; /* 성수기 주중 */
	private int peak_weekend; /* 성수기 주말 */
	private int pen_id; /* 펜션번호 */
	private int fac_id; /* 시설번호 */
	
	
	public Room(String name, int amount, String size, int nopeak_week, int nopeak_weekend, int peak_week,
			int peak_weekend) {
		this.name = name;
		this.amount = amount;
		this.size = size;
		this.nopeak_week = nopeak_week;
		this.nopeak_weekend = nopeak_weekend;
		this.peak_week = peak_week;
		this.peak_weekend = peak_weekend;
	}

	public Room(int amount, String name, String size, String photo, int nopeak_week, int nopeak_weekend, int peak_week,
			int peak_weekend, int pen_id, int fac_id) {
		this.amount = amount;
		this.name = name;
		this.size = size;
		this.nopeak_week = nopeak_week;
		this.nopeak_weekend = nopeak_weekend;
		this.peak_week = peak_week;
		this.peak_weekend = peak_weekend;
		this.pen_id = pen_id;
		this.fac_id = fac_id;
	}

	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getNopeak_week() {
		return nopeak_week;
	}

	public void setNopeak_week(int nopeak_week) {
		this.nopeak_week = nopeak_week;
	}

	public int getNopeak_weekend() {
		return nopeak_weekend;
	}

	public void setNopeak_weekend(int nopeak_weekend) {
		this.nopeak_weekend = nopeak_weekend;
	}

	public int getPeak_week() {
		return peak_week;
	}

	public void setPeak_week(int peak_week) {
		this.peak_week = peak_week;
	}

	public int getPeak_weekend() {
		return peak_weekend;
	}

	public void setPeak_weekend(int peak_weekend) {
		this.peak_weekend = peak_weekend;
	}

	public int getPen_id() {
		return pen_id;
	}

	public void setPen_id(int pen_id) {
		this.pen_id = pen_id;
	}

	public int getFac_id() {
		return fac_id;
	}

	public void setFac_id(int fac_id) {
		this.fac_id = fac_id;
	}
	
	
	
	
}

