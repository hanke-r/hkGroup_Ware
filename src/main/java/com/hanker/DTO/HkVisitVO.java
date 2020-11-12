package com.hanker.DTO;

import java.sql.Date;

public class HkVisitVO {
	private int visit_no;
	private String visit_id;
	private String visit_ip;
	private Date visit_time;
	
	
	public int getVisit_no() {
		return visit_no;
	}
	public void setVisit_no(int visit_no) {
		this.visit_no = visit_no;
	}
	public String getVisit_id() {
		return visit_id;
	}
	public void setVisit_id(String visit_id) {
		this.visit_id = visit_id;
	}
	public String getVisit_ip() {
		return visit_ip;
	}
	public void setVisit_ip(String visit_ip) {
		this.visit_ip = visit_ip;
	}
	public Date getVisit_time() {
		return visit_time;
	}
	public void setVisit_time(Date visit_time) {
		this.visit_time = visit_time;
	}
	
}
