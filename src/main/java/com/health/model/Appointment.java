package com.health.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.health.enumclass.AppointmentSttaus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;


@Entity
@Table(name = "appointment_table")

public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long appointId;
	
//	@Future
	private LocalDate appointDate;
	
//	@Future
	private LocalTime appointTime;
	
	@Enumerated(EnumType.STRING)  // represent enum type should be sto stored as string in db
	@Column(length = 20)
	private AppointmentSttaus status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor")
	private Doctor doctor;

	public Long getAppointId() {
		return appointId;
	}

	public void setAppointId(Long appointId) {
		this.appointId = appointId;
	}

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

	public AppointmentSttaus getStatus() {
		return status;
	}

	public void setStatus(AppointmentSttaus status) {
		this.status = status;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Appointment [appointId=" + appointId + ", appointDate=" + appointDate + ", appointTime=" + appointTime
				+ ", status=" + status + "]";
	}

	
	
	
}
