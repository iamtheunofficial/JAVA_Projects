package com.health.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "specilization_details")

public class Specialization {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long specId;
	
	@Column(nullable = false)
	private String specName;
	
	private String specDesc;
	 @ManyToMany(mappedBy = "specializations")
	    private Set<Doctor> doctors;
	public Long getSpecId() {
		return specId;
	}
	public void setSpecId(Long specId) {
		this.specId = specId;
	}
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	public String getSpecDesc() {
		return specDesc;
	}
	public void setSpecDesc(String specDesc) {
		this.specDesc = specDesc;
	}
	public Set<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}
	@Override
	public String toString() {
		return "Specialization [specId=" + specId + ", specName=" + specName + ", specDesc=" + specDesc + "]";
	}
	public Specialization() {
		// TODO Auto-generated constructor stub
	}
	public Specialization(String specName, String specDesc, Set<Doctor> doctors) {
		super();
		this.specName = specName;
		this.specDesc = specDesc;
		this.doctors = doctors;
	}
	
	 
	 
	
}
