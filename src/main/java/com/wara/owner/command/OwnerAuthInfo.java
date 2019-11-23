package com.wara.owner.command;

public class OwnerAuthInfo {
	
	private Long owner_no;
	private String owner_id;
	private String owner_name;
	private int cate_id;
	
	public OwnerAuthInfo(Long owner_no, String owner_id, String owner_name, int cate_id) {
		this.owner_no = owner_no;
		this.owner_id = owner_id;
		this.owner_name = owner_name;
		this.cate_id = cate_id;
	}

	public Long getOwner_no() {
		return owner_no;
	}

	public String getOwner_id() {
		return owner_id;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public int getCate_id() {
		return cate_id;
	}

	
}
