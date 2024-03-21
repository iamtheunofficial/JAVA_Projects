package com.health.utility;

import java.time.LocalDate;

public class StatusMsg {

	private String msg;
	private LocalDate date;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public StatusMsg(String msg, LocalDate date) {
		super();
		this.msg = msg;
		this.date = date;
	}
	public StatusMsg() {
		// TODO Auto-generated constructor stub
	}
}
