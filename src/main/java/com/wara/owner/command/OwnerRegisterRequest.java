package com.wara.owner.command;

public class OwnerRegisterRequest {
	
	private String owner_id; /* 아이디 */
	private String owner_pwd; /* 비밀번호 */
	private String confirmPassword; /* 비밀번호 확인 */
	private String owner_name; /* 담당자 */
	private String owner_email; /* 이메일 */
	private String owner_phone; /* 핸드폰번호 */
	private String owner_content; /* 내용 */
	
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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

	public boolean isPasswordEqualToConfirmPassword() {
		return owner_pwd.equals(confirmPassword);
	}
	
}
