package com.wara.pension.command;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class RegisterRoom {
	private List<String> cname; /* 방이름 */
	private List<Integer> camount;
	private List<String> csize; /* 크기 */
	private List<Integer> cnopeak_week; /* 비수기 주중 */
	private List<Integer> cnopeak_weekend; /* 비수기 주말 */
	private List<Integer> cpeak_week; /* 성수기 주중 */
	private List<Integer> cpeak_weekend; /* 성수기 주말 */
	private List<String> cswim;
	private List<String> cspa;
	private List<String> cmul;
	private List<String> csingle;
	private List<String> cview;
	private List<String> cbar_ter;
	private List<String> cbar_toge;
	private List<MultipartFile[]> cfile;
	
	public RegisterRoom(List<String> cname, List<Integer> camount, List<String> csize, List<Integer> cnopeak_week,
			List<Integer> cnopeak_weekend, List<Integer> cpeak_week, List<Integer> cpeak_weekend, List<String> cswim,
			List<String> cspa, List<String> cmul, List<String> csingle, List<String> cview, List<String> cbar_ter,
			List<String> cbar_toge, List<MultipartFile[]> cfile) {
		this.cname = cname;
		this.camount = camount;
		this.csize = csize;
		this.cnopeak_week = cnopeak_week;
		this.cnopeak_weekend = cnopeak_weekend;
		this.cpeak_week = cpeak_week;
		this.cpeak_weekend = cpeak_weekend;
		this.cswim = cswim;
		this.cspa = cspa;
		this.cmul = cmul;
		this.csingle = csingle;
		this.cview = cview;
		this.cbar_ter = cbar_ter;
		this.cbar_toge = cbar_toge;
		this.cfile = cfile;
	}

	public List<String> getCname() {
		return cname;
	}

	public void setCname(List<String> cname) {
		this.cname = cname;
	}

	public List<Integer> getCamount() {
		return camount;
	}

	public void setCamount(List<Integer> camount) {
		this.camount = camount;
	}

	public List<String> getCsize() {
		return csize;
	}

	public void setCsize(List<String> csize) {
		this.csize = csize;
	}

	public List<Integer> getCnopeak_week() {
		return cnopeak_week;
	}

	public void setCnopeak_week(List<Integer> cnopeak_week) {
		this.cnopeak_week = cnopeak_week;
	}

	public List<Integer> getCnopeak_weekend() {
		return cnopeak_weekend;
	}

	public void setCnopeak_weekend(List<Integer> cnopeak_weekend) {
		this.cnopeak_weekend = cnopeak_weekend;
	}

	public List<Integer> getCpeak_week() {
		return cpeak_week;
	}

	public void setCpeak_week(List<Integer> cpeak_week) {
		this.cpeak_week = cpeak_week;
	}

	public List<Integer> getCpeak_weekend() {
		return cpeak_weekend;
	}

	public void setCpeak_weekend(List<Integer> cpeak_weekend) {
		this.cpeak_weekend = cpeak_weekend;
	}

	public List<String> getCswim() {
		return cswim;
	}

	public void setCswim(List<String> cswim) {
		this.cswim = cswim;
	}

	public List<String> getCspa() {
		return cspa;
	}

	public void setCspa(List<String> cspa) {
		this.cspa = cspa;
	}

	public List<String> getCmul() {
		return cmul;
	}

	public void setCmul(List<String> cmul) {
		this.cmul = cmul;
	}

	public List<String> getCsingle() {
		return csingle;
	}

	public void setCsingle(List<String> csingle) {
		this.csingle = csingle;
	}

	public List<String> getCview() {
		return cview;
	}

	public void setCview(List<String> cview) {
		this.cview = cview;
	}

	public List<String> getCbar_ter() {
		return cbar_ter;
	}

	public void setCbar_ter(List<String> cbar_ter) {
		this.cbar_ter = cbar_ter;
	}

	public List<String> getCbar_toge() {
		return cbar_toge;
	}

	public void setCbar_toge(List<String> cbar_toge) {
		this.cbar_toge = cbar_toge;
	}

	public List<MultipartFile[]> getCfile() {
		return cfile;
	}

	public void setCfile(List<MultipartFile[]> cfile) {
		this.cfile = cfile;
	}
	
	
}
