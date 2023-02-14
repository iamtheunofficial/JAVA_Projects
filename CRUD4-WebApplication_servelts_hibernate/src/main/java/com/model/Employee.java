package com.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_details")
public class Employee {
	@Id
	@Column(name = "e_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "e_name", length = 20, nullable = false)
	private String name;
	@Column(name = "e_address", length = 20, nullable = false)
	private String address;
	@Column(name = "e_age", length = 20, nullable = false)
	private Integer age;
	@Column(name = "e_dob", length = 20, nullable = false)
	private LocalDate Dob;

	public Employee() {
		System.out.println("object created");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public LocalDate getDob() {
		return Dob;
	}

	public void setDob(LocalDate dob) {
		Dob = dob;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", age=" + age + ", Dob=" + Dob + "]";
	}

}
