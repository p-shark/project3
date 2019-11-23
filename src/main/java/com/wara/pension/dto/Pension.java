package com.wara.pension.dto;

import java.sql.Date;

public class Pension {
	private int pen_id;  /* 펜션번호 */
	private String name; /* 펜션명 */
	private String address; /* 펜션주소 */
	private String phone; /* 문의번호 */
	private Date peak_end; /* 성수기 종료일 */
	private Date peak_start;  /* 성수기 시작일 */
	private String info; /* 입/퇴실 안내 */
	private boolean pickup; /* 픽업여부 */
	private String area; /* 지역 */
	private int owner_id;
    
    
	public Pension(String name, String address, String phone, Date peak_end,
			Date peak_start, String info, boolean pickup, int owner_id, String area) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.peak_end = peak_end;
		this.peak_start = peak_start;
		this.info = info;
		this.pickup = pickup;
		this.owner_id = owner_id;
		this.area = area;
	}

	public int getPen_id() {
		return pen_id;
	}

	public void setPen_id(int pen_id) {
		this.pen_id = pen_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getPeak_end() {
		return peak_end;
	}

	public void setPeak_end(Date peak_end) {
		this.peak_end = peak_end;
	}

	public Date getPeak_start() {
		return peak_start;
	}

	public void setPeak_start(Date peak_start) {
		this.peak_start = peak_start;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public boolean isPickup() {
		return pickup;
	}

	public void setPickup(boolean pickup) {
		this.pickup = pickup;
	}

	public int getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
    
    
	
	
}
