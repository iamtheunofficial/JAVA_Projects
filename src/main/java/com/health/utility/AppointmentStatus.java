package com.health.utility;

import java.time.LocalDate;

public class AppointmentStatus {

	public Long appointId;
	public String msg;
	public LocalDate dateOfAppointment;
	public String doctorName;
	private Long patientId;
	
	
	
	public AppointmentStatus(Long appointId, String msg, LocalDate dateOfAppointment, String doctorName,
			Long patientId) {
		super();
		this.appointId = appointId;
		this.msg = msg;
		this.dateOfAppointment = dateOfAppointment;
		this.doctorName = doctorName;
		this.patientId = patientId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Long getAppointId() {
		return appointId;
	}
	public void setAppointId(Long appointId) {
		this.appointId = appointId;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public LocalDate getDateOfAppointment() {
		return dateOfAppointment;
	}
	public void setDateOfAppointment(LocalDate dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	public AppointmentStatus() {
	}
	public AppointmentStatus(Long appointId, String msg, LocalDate dateOfAppointment, String doctorName) {
		super();
		this.appointId = appointId;
		this.msg = msg;
		this.dateOfAppointment = dateOfAppointment;
		this.doctorName = doctorName;
	}
	@Override
	public String toString() {
		return "AppointmentStatus [appointId=" + appointId + ", msg=" + msg + ", dateOfAppointment=" + dateOfAppointment
				+ ", DoctorName=" + doctorName + "]";
	}
	
	
	
}
