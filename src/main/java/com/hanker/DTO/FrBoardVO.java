package com.hanker.DTO;

import java.sql.Date;

public class FrBoardVO {
	
	private int frno;
	private String frtitle;
	private String frwriter;
	private String frcontent;
	private int frviewcnt;
	private Date regdate;
	
	
	public int getFrno() {
		return frno;
	}
	public void setFrno(int frno) {
		this.frno = frno;
	}
	public String getFrtitle() {
		return frtitle;
	}
	public void setFrtitle(String frtitle) {
		this.frtitle = frtitle;
	}
	public String getFrwriter() {
		return frwriter;
	}
	public void setFrwriter(String frwriter) {
		this.frwriter = frwriter;
	}
	public String getFrcontent() {
		return frcontent;
	}
	public void setFrcontent(String frcontent) {
		this.frcontent = frcontent;
	}
	public int getFrviewcnt() {
		return frviewcnt;
	}
	public void setFrviewcnt(int frviewcnt) {
		this.frviewcnt = frviewcnt;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	
}
