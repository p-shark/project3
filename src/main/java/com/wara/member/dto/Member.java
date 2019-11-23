package com.wara.member.dto;

import com.wara.member.exception.WrongIdPasswordException;

public class Member {
	
	private Long mem_id;
	private String name;
	private String id;
	private String password;
	private String email;
	private String phone;
	private int cate_id;

	public Member(Long mem_id, String name, String id, String password, String email, String phone, int cate_id) {
		this.mem_id = mem_id;
		this.name = name;
		this.id = id;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.cate_id = cate_id;
	}
	
	public Member(String name, String id, String password, String email, String phone, int cate_id) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.cate_id = cate_id;
	}
	
	public Member(String name, String id, String password, String email, String phone) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}

	public Long getMem_id() {
		return mem_id;
	}

	public void setMem_id(Long mem_id) {
		this.mem_id = mem_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getCate_id() {
		return cate_id;
	}

	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}

	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.password = newPassword;
	}

	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}
}
