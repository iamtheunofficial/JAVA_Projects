package com.health.dto;

import java.time.LocalDate;


public class BillingDto {

	private Long billingId;
	private Double amountDue;
	private String paymentStatus;
	private String paymentMode;
	private LocalDate paymentdate;
	private Long appointmentId;
	private String patientName;
	public Long getBillingId() {
		return billingId;
	}
	public void setBillingId(Long billingId) {
		this.billingId = billingId;
	}
	public Double getAmountDue() {
		return amountDue;
	}
	public void setAmountDue(Double amountDue) {
		this.amountDue = amountDue;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public LocalDate getPaymentdate() {
		return paymentdate;
	}
	public void setPaymentdate(LocalDate paymentdate) {
		this.paymentdate = paymentdate;
	}
	public Long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	@Override
	public String toString() {
		return "BillingDto [billingId=" + billingId + ", amountDue=" + amountDue + ", paymentStatus=" + paymentStatus
				+ ", paymentMode=" + paymentMode + ", paymentdate=" + paymentdate + ", appointmentId=" + appointmentId
				+ ", patientName=" + patientName + "]";
	}
	public BillingDto(Long billingId, Double amountDue, String paymentStatus, String paymentMode, LocalDate paymentdate,
			Long appointmentId, String patientName) {
		super();
		this.billingId = billingId;
		this.amountDue = amountDue;
		this.paymentStatus = paymentStatus;
		this.paymentMode = paymentMode;
		this.paymentdate = paymentdate;
		this.appointmentId = appointmentId;
		this.patientName = patientName;
	}
	
	public BillingDto() {
	}


}
