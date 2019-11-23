package com.wara.owner.dto;

import com.wara.member.exception.WrongIdPasswordException;

public class Owner {

	private Long owner_no; /* 펜션주 번호 */
	private String owner_id; /* 아이디 */
	private String owner_pwd; /* 비밀번호 */
	private String owner_name; /* 담당자 */
	private String owner_email; /* 이메일 */
	private String owner_phone; /* 핸드폰번호 */
	private String owner_content; /* 내용 */
	private boolean logincheck;
	private int cate_id; /* 분류번호 */
	private int pen_id; /* 펜션번호 */
	
	public Owner(Long owner_no, String owner_id, String owner_pwd, String owner_name, String owner_email, String owner_phone, String owner_content,
			boolean logincheck, int cate_id, int pen_id) {
		this.owner_no = owner_no;
		this.owner_id = owner_id;
		this.owner_pwd = owner_pwd;
		this.owner_name = owner_name;
		this.owner_email = owner_email;
		this.owner_phone = owner_phone;
		this.logincheck = logincheck;
		this.owner_content = owner_content;
		this.cate_id = cate_id;
		this.pen_id = pen_id;
	}
	
	public Owner(Long owner_no, String owner_id, String owner_pwd, String owner_name, String owner_email, String owner_phone, String owner_content,
			boolean logincheck, int cate_id) {
		this.owner_no = owner_no;
		this.owner_id = owner_id;
		this.owner_pwd = owner_pwd;
		this.owner_name = owner_name;
		this.owner_email = owner_email;
		this.owner_phone = owner_phone;
		this.owner_content = owner_content;
		this.logincheck = logincheck;
		this.cate_id = cate_id;
	}

	public Owner(String owner_id, String owner_pwd, String owner_name, String owner_email, String owner_phone, String owner_content, boolean logincheck) {
		this.owner_id = owner_id;
		this.owner_pwd = owner_pwd;
		this.owner_name = owner_name;
		this.owner_email = owner_email;
		this.owner_phone = owner_phone;
		this.owner_content = owner_content;
		this.logincheck = logincheck;
	}
	
	public Owner(String owner_id, String owner_pwd, String owner_name, String owner_email, String owner_phone, String owner_content) {
		this.owner_id = owner_id;
		this.owner_pwd = owner_pwd;
		this.owner_name = owner_name;
		this.owner_email = owner_email;
		this.owner_phone = owner_phone;
		this.owner_content = owner_content;
	}
	
	public Owner(String owner_id, String owner_name, String owner_email, String owner_phone, String owner_content, boolean logincheck) {
		this.owner_id = owner_id;
		this.owner_name = owner_name;
		this.owner_email = owner_email;
		this.owner_phone = owner_phone;
		this.owner_content = owner_content;
		this.logincheck = logincheck;
	}

	public Long getOwner_no() {
		return owner_no;
	}

	public void setOwner_no(Long owner_no) {
		this.owner_no = owner_no;
	}

	public String getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}

	public String getOwner_pwd() {
		return owner_pwd;
	}

	public void setOwner_pwd(String owner_pwd) {
		this.owner_pwd = owner_pwd;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public String getOwner_email() {
		return owner_email;
	}

	public void setOwner_email(String owner_email) {
		this.owner_email = owner_email;
	}

	public String getOwner_phone() {
		return owner_phone;
	}

	public void setOwner_phone(String owner_phone) {
		this.owner_phone = owner_phone;
	}

	public String getOwner_content() {
		return owner_content;
	}

	public void setOwner_content(String owner_content) {
		this.owner_content = owner_content;
	}

	public boolean isLogincheck() {
		return logincheck;
	}

	public void setLogincheck(boolean logincheck) {
		this.logincheck = logincheck;
	}

	public int getCate_id() {
		return cate_id;
	}

	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}

	public int getPen_id() {
		return pen_id;
	}

	public void setPen_id(int pen_id) {
		this.pen_id = pen_id;
	}

	public void changePassword(String oldPassword, String newPassword) {
		if (!owner_pwd.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.owner_pwd = newPassword;
	}

	public boolean matchPassword(String owner_pwd) {
		return this.owner_pwd.equals(owner_pwd);
	}
	
	
}
