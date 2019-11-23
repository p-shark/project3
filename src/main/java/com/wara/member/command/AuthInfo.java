package com.wara.member.command;

public class AuthInfo {
	private Long mem_id;
	private String id;
	private String name;
	private int cate_id;
	
	public AuthInfo(Long mem_id, String id, String name, int cate_id) {
		this.mem_id = mem_id;
		this.id = id;
		this.name = name;
		this.cate_id = cate_id;
	}

	public Long getMem_id() {
		return mem_id;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getCate_id() {
		return cate_id;
	}
}
