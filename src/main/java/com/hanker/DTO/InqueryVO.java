package com.hanker.DTO;

import java.sql.Date;

public class InqueryVO {
	
	private int inq_no;
	private int uno;
	private String inq_title;
	private String inq_content;
	private String inq_email;
	private String inq_writer;
	private String inq_answer;
	private Date regdate;
	
	
	
	public String getInq_email() {
		return inq_email;
	}
	public void setInq_email(String inq_email) {
		this.inq_email = inq_email;
	}
	public int getInq_no() {
		return inq_no;
	}
	public void setInq_no(int inq_no) {
		this.inq_no = inq_no;
	}
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getInq_title() {
		return inq_title;
		
	}
	public void setInq_title(String inq_title) {
		this.inq_title = inq_title;
	}
	public String getInq_content() {
		return inq_content;
	}
	public void setInq_content(String inq_content) {
		this.inq_content = inq_content;
	}
	public String getInq_writer() {
		return inq_writer;
	}
	public void setInq_writer(String inq_writer) {
		this.inq_writer = inq_writer;
	}
	public String getInq_answer() {
		return inq_answer;
	}
	public void setInq_answer(String inq_answer) {
		this.inq_answer = inq_answer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
