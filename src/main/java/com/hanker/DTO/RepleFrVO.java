package com.hanker.DTO;

import java.sql.Date;

public class RepleFrVO {
	
	private int ref_no;
	private int frno;
	private int uno;
	private String ref_writer;
	private String ref_content;
	private Date regdate;
	
	
	public int getRef_no() {
		return ref_no;
	}
	public void setRef_no(int ref_no) {
		this.ref_no = ref_no;
	}
	public int getFrno() {
		return frno;
	}
	public void setFrno(int frno) {
		this.frno = frno;
	}
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getRef_writer() {
		return ref_writer;
	}
	public void setRef_writer(String ref_writer) {
		this.ref_writer = ref_writer;
	}
	public String getRef_content() {
		return ref_content;
	}
	public void setRef_content(String ref_content) {
		this.ref_content = ref_content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	
}
