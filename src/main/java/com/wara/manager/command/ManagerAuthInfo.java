package com.wara.manager.command;

public class ManagerAuthInfo {
	
	private Long mgr_no;
	private String mgr_id;
	private int cate_id;
	
	public ManagerAuthInfo(Long mgr_no, String mgr_id, int cate_id) {
		this.mgr_no = mgr_no;
		this.mgr_id = mgr_id;
		this.cate_id = cate_id;
	}

	public Long getMgr_no() {
		return mgr_no;
	}

	public String getMgr_id() {
		return mgr_id;
	}

	public int getCate_id() {
		return cate_id;
	}

}
