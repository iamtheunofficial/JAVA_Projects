package com.health.dto;

import java.time.LocalTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class DoctorDto {

//	@JsonIgnore
	private Long doctorId;

	private String doctorName;
	private LocalTime availabilty;
	private Double fees;
    private Set<String> specializations;
	private String email;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public LocalTime getAvailabilty() {
		return availabilty;
	}
	public void setAvailabilty(LocalTime availabilty) {
		this.availabilty = availabilty;
	}
	public Double getFees() {
		return fees;
	}
	public void setFees(Double fees) {
		this.fees = fees;
	}
	public Set<String> getSpecializations() {
		return specializations;
	}
	public void setSpecializations(Set<String> specializations) {
		this.specializations = specializations;
	}
	
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	@Override
	public String toString() {
		return "DoctorDto [doctorName=" + doctorName + ", availabilty=" + availabilty + ", fees=" + fees
				+ ", specializations=" + specializations + ", email=" + email + "]";
	}
	 
    public DoctorDto(String doctorName, LocalTime availabilty, Double fees, Set<String> specializations,
			 String email) {
		super();
		this.doctorName = doctorName;
		this.availabilty = availabilty;
		this.fees = fees;
		this.specializations = specializations;
		
		this.email = email;
	}
	public DoctorDto() {
	}


}
