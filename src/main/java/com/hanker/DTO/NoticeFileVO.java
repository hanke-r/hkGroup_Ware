package com.hanker.DTO;

import java.sql.Date;

public class NoticeFileVO {
	
	private int nfno;
	private int nbno;
	private String nf_filename;
	private String nf_path;
	private String nf_fullpath;
	private String nf_size;
	private Date regdate;
	
	public int getNfno() {
		return nfno;
	}
	public void setNfno(int nfno) {
		this.nfno = nfno;
	}
	public int getNbno() {
		return nbno;
	}
	public void setNbno(int nbno) {
		this.nbno = nbno;
	}
	public String getNf_filename() {
		return nf_filename;
	}
	public void setNf_filename(String nf_filename) {
		this.nf_filename = nf_filename;
	}
	public String getNf_path() {
		return nf_path;
	}
	public void setNf_path(String nf_path) {
		this.nf_path = nf_path;
	}
	public String getNf_fullpath() {
		return nf_fullpath;
	}
	public void setNf_fullpath(String nf_fullpath) {
		this.nf_fullpath = nf_fullpath;
	}
	public String getNf_size() {
		return nf_size;
	}
	public void setNf_size(String nf_size) {
		this.nf_size = nf_size;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
