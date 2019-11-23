package com.wara.pension.command;

public class RoomFacilityCommand {

	private int room_no;
	private String name; /* 방이름 */
	private String size; /* 크기  */
	private int amount; /* 최대 인원수 */
	private String photo; /* 사진 */
	private int nopeak_week; /* 비수기 주중 */
	private int nopeak_weekend; /* 비수기 주말 */
	private int peak_week; /* 성수기 주중 */
	private int peak_weekend; /* 성수기 주말 */
	private Boolean swim;
	private Boolean spa;
	private Boolean mul;
	private Boolean single;
	private Boolean view;
	private Boolean bar_ter;
	private Boolean bar_toge;

	public RoomFacilityCommand(int room_no, int amount, String name, String size, int nopeak_week, int nopeak_weekend, int peak_week,
			int peak_weekend, boolean swim, boolean spa, boolean mul, boolean single, boolean view,
			boolean bar_ter, boolean bar_toge) {
		this.amount = amount;
		this.room_no = room_no;
		this.name = name;
		this.size = size;
		this.nopeak_week = nopeak_week;
		this.nopeak_weekend = nopeak_weekend;
		this.peak_week = peak_week;
		this.peak_weekend = peak_weekend;
		this.swim = swim;
		this.spa = spa;
		this.mul = mul;
		this.single = single;
		this.view = view;
		this.bar_ter = bar_ter;
		this.bar_toge = bar_toge;
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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
	public Boolean getSwim() {
		return swim;
	}
	public void setSwim(Boolean swim) {
		this.swim = swim;
	}
	public Boolean getSpa() {
		return spa;
	}
	public void setSpa(Boolean spa) {
		this.spa = spa;
	}
	public Boolean getMul() {
		return mul;
	}
	public void setMul(Boolean mul) {
		this.mul = mul;
	}
	public Boolean getSingle() {
		return single;
	}
	public void setSingle(Boolean single) {
		this.single = single;
	}
	public Boolean getView() {
		return view;
	}
	public void setView(Boolean view) {
		this.view = view;
	}
	public Boolean getBar_ter() {
		return bar_ter;
	}
	public void setBar_ter(Boolean bar_ter) {
		this.bar_ter = bar_ter;
	}
	public Boolean getBar_toge() {
		return bar_toge;
	}
	public void setBar_toge(Boolean bar_toge) {
		this.bar_toge = bar_toge;
	}
	
	
	
}
