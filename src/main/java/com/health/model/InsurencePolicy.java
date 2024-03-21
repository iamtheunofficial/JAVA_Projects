package com.health.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
;


@Entity

public class InsurencePolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long insurenceId;
	
	@Column(nullable = false)
	private String insurenceProvider;
	
	private String details;
	
	private Double insurenceAmount;
	
	@Column(unique = true)
	private Long policyNumber;
	private Long contact;
	public Long getInsurenceId() {
		return insurenceId;
	}
	public void setInsurenceId(Long insurenceId) {
		this.insurenceId = insurenceId;
	}
	public String getInsurenceProvider() {
		return insurenceProvider;
	}
	public void setInsurenceProvider(String insurenceProvider) {
		this.insurenceProvider = insurenceProvider;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Double getInsurenceAmount() {
		return insurenceAmount;
	}
	public void setInsurenceAmount(Double insurenceAmount) {
		this.insurenceAmount = insurenceAmount;
	}
	public Long getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(Long policyNumber) {
		this.policyNumber = policyNumber;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "InsurencePolicy [insurenceId=" + insurenceId + ", insurenceProvider=" + insurenceProvider + ", details="
				+ details + ", insurenceAmount=" + insurenceAmount + ", policyNumber=" + policyNumber + ", contact="
				+ contact + "]";
	}
	
	
		
}
