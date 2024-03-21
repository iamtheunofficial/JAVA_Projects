package com.health.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "patient_details")

public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientId;
	
	@Column(name = "patient_name",nullable = false,unique = true)
	@Pattern(regexp = "[A-Za-z]+")
	private String name;
	
	@Column(length = 8)
	private Integer age;
	
//	@Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z]+\\.com$")
	@Email(message = "please enter the valid email address")
    @NotBlank(message = "Email is required")

	@Column(unique = true)
	private String email;
	
	private Long mblNo;
	
	@Past         // the entered date should be less the currentdate
	private LocalDate dateOfBirth;
	
	@Column(nullable = false)
	private String address;
	
	@ManyToOne
	@JoinColumn(name="insurenceId")
	private InsurencePolicy insurence;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMblNo() {
		return mblNo;
	}

	public void setMblNo(Long mblNo) {
		this.mblNo = mblNo;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public InsurencePolicy getInsurence() {
		return insurence;
	}

	public void setInsurence(InsurencePolicy insurence) {
		this.insurence = insurence;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", name=" + name + ", age=" + age + ", email=" + email + ", mblNo="
				+ mblNo + ", dateOfBirth=" + dateOfBirth + ", address=" + address + "]";
	}

	
	
	

}
