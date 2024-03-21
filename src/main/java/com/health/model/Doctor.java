package com.health.model;

import java.time.LocalTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "doctor_details")

public class Doctor  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long doctorId;
	
	@Column(nullable = false)
	@Pattern(regexp = "[a-zA-Z]+")
	private String doctorName;
	
	@Size(min = 12)
	@Column(unique = true)
	private String email;
	
	
	private LocalTime availabilty;
	
	@Value("0")
	private Double fees;
	
	 @ManyToMany
	    @JoinTable(
	            name = "doctor_specialization",
	            joinColumns = @JoinColumn(name = "doctorId"),
	            inverseJoinColumns = @JoinColumn(name = "specialization_id")
	    )
	    private Set<Specialization> specializations;

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalTime getAvailabilty() {
		return availabilty;
	}

	public void setAvailabilty(String availabilty) {
		this.availabilty=LocalTime.parse(availabilty);
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}

	public Set<Specialization> getSpecializations() {
		return specializations;
	}

	public void setSpecializations(Set<Specialization> specializations) {
		this.specializations = specializations;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", email=" + email + ", availabilty="
				+ availabilty + ", fees=" + fees + "]";
	}

	 
	
}
