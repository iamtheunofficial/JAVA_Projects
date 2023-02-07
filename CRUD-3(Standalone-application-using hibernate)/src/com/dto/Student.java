package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer std_Id;
	
	@Column(name = "name")
private String std_Name;
	
	@Column(name = "address")
private String std_Address;

static {
	System.out.println("student class loading");
}
	public Student() {
		System.out.println("contructor called");
	}
	public Integer getStd_Id() {
		return std_Id;
	}
	public void setStd_Id(Integer std_Id) {
		this.std_Id = std_Id;
	}
	public String getStd_Name() {
		return std_Name;
	}
	public void setStd_Name(String std_Name) {
		this.std_Name = std_Name;
	}
	public String getStd_Address() {
		return std_Address;
	}
	public void setStd_Address(String std_Address) {
		this.std_Address = std_Address;
	}
	@Override
	public String toString() {
		return "Student [std_Id=" + std_Id + ", std_Name=" + std_Name + ", std_Address=" + std_Address + "]";
	}
	
}
