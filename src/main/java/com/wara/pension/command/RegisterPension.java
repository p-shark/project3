package com.wara.pension.command;
import org.springframework.web.multipart.MultipartFile;

public class RegisterPension {
	private String name;
	private String address;
	private String phone;
	private String peak_start;
	private String peak_end;
	private String info;
	private Boolean pickup;
	private String content;
	private MultipartFile[] file;
	
	public RegisterPension(String name, String address, String phone, String peak_start, String peak_end, String info,
			Boolean pickup, String content, MultipartFile[] file) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.peak_start = peak_start;
		this.peak_end = peak_end;
		this.info = info;
		this.pickup = pickup;
		this.content = content;
		this.file = file;
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

	public String getPeak_start() {
		return peak_start;
	}

	public void setPeak_start(String peak_start) {
		this.peak_start = peak_start;
	}

	public String getPeak_end() {
		return peak_end;
	}

	public void setPeak_end(String peak_end) {
		this.peak_end = peak_end;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Boolean getPickup() {
		return pickup;
	}

	public void setPickup(Boolean pickup) {
		this.pickup = pickup;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MultipartFile[] getFile() {
		return file;
	}

	public void setFile(MultipartFile[] file) {
		this.file = file;
	}
}
