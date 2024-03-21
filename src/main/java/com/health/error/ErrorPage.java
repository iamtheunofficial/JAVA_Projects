package com.health.error;

import org.springframework.http.HttpStatus;

public class ErrorPage {

	private String msg;
	private HttpStatus statusCode;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public HttpStatus getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}
	public ErrorPage(String msg, HttpStatus statusCode) {
		super();
		this.msg = msg;
		this.statusCode = statusCode;
	}
	public ErrorPage() {
		// TODO Auto-generated constructor stub
	}
}
