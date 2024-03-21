package com.health.dto;


public class InsurencePolicyDto {

	private String insurenceProvider;
	private String details;
	private Double insurenceAmount;
	private Long policyNumber;
	private Long contact;
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
	public InsurencePolicyDto(String insurenceProvider, String details, Double insurenceAmount, Long policyNumber,
			Long contact) {
		super();
		this.insurenceProvider = insurenceProvider;
		this.details = details;
		this.insurenceAmount = insurenceAmount;
		this.policyNumber = policyNumber;
		this.contact = contact;
	}
public InsurencePolicyDto() {
	// TODO Auto-generated constructor stub
}


}
