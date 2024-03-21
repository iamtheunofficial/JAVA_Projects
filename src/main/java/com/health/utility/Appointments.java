package com.health.utility;

import java.time.LocalDate;
import java.time.LocalTime;


public class Appointments {

	private LocalDate appointDate;
	private LocalTime appointTime;
private Long patientId;
private Long appointmentId;


public LocalDate getAppointDate() {
	return appointDate;
}
public void setAppointDate(LocalDate appointDate) {
	this.appointDate = appointDate;
}
public LocalTime getAppointTime() {
	return appointTime;
}
public void setAppointTime(LocalTime appointTime) {
	this.appointTime = appointTime;
}


public Long getPatientId() {
	return patientId;
}
public void setPatientId(Long patientId) {
	this.patientId = patientId;
}
public Long getAppointmentId() {
	return appointmentId;
}
public void setAppointmentId(Long appointmentId) {
	this.appointmentId = appointmentId;
}


public Appointments(LocalDate appointDate, LocalTime appointTime, Long patientId, Long appointmentId) {
	super();
	this.appointDate = appointDate;
	this.appointTime = appointTime;
	this.patientId = patientId;
	this.appointmentId = appointmentId;
}
public Appointments() {
}
	
	


}
