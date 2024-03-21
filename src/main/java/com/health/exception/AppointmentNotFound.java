package com.health.exception;

public class AppointmentNotFound  extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public AppointmentNotFound(String msg) {
super(msg);	}
}
