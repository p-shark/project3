package com.wara.pension.dto;


public class Facility {
	private int fac_no;
	private String swim;
	private String spa;
	private String mul;
	private String single;
	private String view;
	private String bar_ter;
	private String bar_toge;
	private int room_no;
	
	public Facility(int fac_no, String swim, String spa, String mul, String single, String view, String bar_ter,
			String bar_toge, int room_no) {
		this.swim = swim;
		this.spa = spa;
		this.mul = mul;
		this.single = single;
		this.view = view;
		this.bar_ter = bar_ter;
		this.bar_toge = bar_toge;
	}

	public int getFac_no() {
		return fac_no;
	}

	public void setFac_no(int fac_no) {
		this.fac_no = fac_no;
	}

	public String getSwim() {
		return swim;
	}

	public void setSwim(String swim) {
		this.swim = swim;
	}

	public String getSpa() {
		return spa;
	}

	public void setSpa(String spa) {
		this.spa = spa;
	}

	public String getMul() {
		return mul;
	}

	public void setMul(String mul) {
		this.mul = mul;
	}

	public String getSingle() {
		return single;
	}

	public void setSingle(String single) {
		this.single = single;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getBar_ter() {
		return bar_ter;
	}

	public void setBar_ter(String bar_ter) {
		this.bar_ter = bar_ter;
	}

	public String getBar_toge() {
		return bar_toge;
	}

	public void setBar_toge(String bar_toge) {
		this.bar_toge = bar_toge;
	}

	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	
	
}
