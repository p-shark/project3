package com.wara.pension.dto;

public class PensionPic {
	private int pension_pic_no;
	private String pension_pic_path;
	
	public PensionPic(String pension_pic_path) {
		this.pension_pic_path = pension_pic_path;
	}

	public int getPension_pic_no() {
		return pension_pic_no;
	}

	public void setPension_pic_no(int pension_pic_no) {
		this.pension_pic_no = pension_pic_no;
	}

	public String getPension_pic_path() {
		return pension_pic_path;
	}

	public void setPension_pic_path(String pension_pic_path) {
		this.pension_pic_path = pension_pic_path;
	}
}
