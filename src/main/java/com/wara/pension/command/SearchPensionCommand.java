package com.wara.pension.command;

public class SearchPensionCommand {
	private String area;
	private String sido1;
	private String gugun1;
	private String checkIn;
	private int stay_count;
	private int person;
	private String swim;
	private String spa;
	private String mul;
	private String single;
	private String view;
	private String bar_ter;
	private String bar_toge;
	

	public SearchPensionCommand(String area, String sido1, String gugun1, String checkIn, int stay_count, int person,
			String swim, String spa, String mul, String single, String view, String bar_ter, String bar_toge) {
		this.area = area;
		this.sido1 = sido1;
		this.gugun1 = gugun1;
		this.checkIn = checkIn;
		this.stay_count = stay_count;
		this.person = person;
		this.swim = swim;
		this.spa = spa;
		this.mul = mul;
		this.single = single;
		this.view = view;
		this.bar_ter = bar_ter;
		this.bar_toge = bar_toge;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}


	public String getSido1() {
		return sido1;
	}

	public void setSido1(String sido1) {
		this.sido1 = sido1;
	}

	public String getGugun1() {
		return gugun1;
	}

	public void setGugun1(String gugun1) {
		this.gugun1 = gugun1;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public int getStay_count() {
		return stay_count;
	}

	public void setStay_count(int stay_count) {
		this.stay_count = stay_count;
	}

	public int getPerson() {
		return person;
	}

	public void setPerson(int person) {
		this.person = person;
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
}
