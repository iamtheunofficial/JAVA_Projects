package com.health.dto;

import java.time.LocalDate;

public class PatientDto {

	private String name;
	private Integer age;
	private String email;
	private Long mblNo;
	private LocalDate dateOfBirth;
	private String address;
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
	public PatientDto(String name, Integer age, String email, Long mblNo, LocalDate dateOfBirth, String address) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.mblNo = mblNo;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}

	public PatientDto() {
	}

}
