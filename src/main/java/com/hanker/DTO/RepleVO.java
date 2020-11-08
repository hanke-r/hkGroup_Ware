package com.hanker.DTO;

import java.sql.Date;

public class RepleVO {
	
	private int reno;
	private int nbno;
	private int uno;
	private String rewriter;
	private String recontent;
	private Date regdate;
	
	
	
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public int getReno() {
		return reno;
	}
	public void setReno(int reno) {
		this.reno = reno;
	}
	public int getNbno() {
		return nbno;
	}
	public void setNbno(int nbno) {
		this.nbno = nbno;
	}
	public String getRewriter() {
		return rewriter;
	}
	public void setRewriter(String rewriter) {
		this.rewriter = rewriter;
	}
	public String getRecontent() {
		return recontent;
	}
	public void setRecontent(String recontent) {
		this.recontent = recontent;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	

}
