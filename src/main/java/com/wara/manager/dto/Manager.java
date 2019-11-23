package com.wara.manager.dto;

public class Manager {
	
	private Long mgr_no; /* 관리자 번호 */
	private String mgr_id; /* 아이디 */
	private String mgr_pwd; /* 비밀번호 */
	private int cate_id; /* 분류번호 */
	
	public Manager(Long mgr_no, String mgr_id, String mgr_pwd, int cate_id) {
		this.mgr_no = mgr_no;
		this.mgr_id = mgr_id;
		this.mgr_pwd = mgr_pwd;
		this.cate_id = cate_id;
	}

	public Manager(String mgr_id, String mgr_pwd) {
		this.mgr_id = mgr_id;
		this.mgr_pwd = mgr_pwd;
	}

	public Long getMgr_no() {
		return mgr_no;
	}

	public void setMgr_no(Long mgr_no) {
		this.mgr_no = mgr_no;
	}

	public String getMgr_id() {
		return mgr_id;
	}

	public void setMgr_id(String mgr_id) {
		this.mgr_id = mgr_id;
	}

	public String getMgr_pwd() {
		return mgr_pwd;
	}

	public void setMgr_pwd(String mgr_pwd) {
		this.mgr_pwd = mgr_pwd;
	}

	public int getCate_id() {
		return cate_id;
	}

	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}

	public boolean matchPassword(String mgr_pwd) {
		return this.mgr_pwd.equals(mgr_pwd);
	}
	
}
