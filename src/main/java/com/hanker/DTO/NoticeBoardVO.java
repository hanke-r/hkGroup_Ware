package com.hanker.DTO;

import java.sql.Date;

public class NoticeBoardVO {
	
	private int nbno;
	private String nbtitle;
	private String nbwriter;
	private String nbcontent;
	private String nbviewcnt;
	private Date regdate;
	
	
	
	public String getNbwriter() {
		return nbwriter;
	}
	public void setNbwriter(String nbwriter) {
		this.nbwriter = nbwriter;
	}
	public int getNbno() {
		return nbno;
	}
	public void setNbno(int nbno) {
		this.nbno = nbno;
	}
	public String getNbtitle() {
		return nbtitle;
	}
	public void setNbtitle(String nbtitle) {
		this.nbtitle = nbtitle;
	}
	public String getNbcontent() {
		return nbcontent;
	}
	public void setNbcontent(String nbcontent) {
		this.nbcontent = nbcontent;
	}
	public String getNbviewcnt() {
		return nbviewcnt;
	}
	public void setNbviewcnt(String nbviewcnt) {
		this.nbviewcnt = nbviewcnt;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
