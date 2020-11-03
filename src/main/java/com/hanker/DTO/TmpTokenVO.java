package com.hanker.DTO;

import java.sql.Date;

public class TmpTokenVO {
	
	private int ttno;
	private String email;
	private int token;
	private String emailcert;
	private Date regdate;
	
	
	public int getTtno() {
		return ttno;
	}
	public void setTtno(int ttno) {
		this.ttno = ttno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getToken() {
		return token;
	}
	public void setToken(int token) {
		this.token = token;
	}
	public String getEmailcert() {
		return emailcert;
	}
	public void setEmailcert(String emailcert) {
		this.emailcert = emailcert;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

}
