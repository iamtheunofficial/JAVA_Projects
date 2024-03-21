package com.health.model;

import java.time.LocalDate;

import com.health.enumclass.PaymentStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;



@Entity
@Table(name = "billing_details")

public class Billing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long billingId;
	
	
	private Double amountDue;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	
	
	private String paymentMode;
	private LocalDate paymentdate;
	
	@ManyToOne
	private Appointment appointment;

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

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
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

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "Billing [billingId=" + billingId + ", amountDue=" + amountDue + ", paymentStatus=" + paymentStatus
				+ ", paymentMode=" + paymentMode + ", paymentdate=" + paymentdate + "]";
	}

	public Billing(@Size(min = 0) Double amountDue, PaymentStatus paymentStatus, String paymentMode,
			LocalDate paymentdate, Appointment appointment) {
		super();
		this.amountDue = amountDue;
		this.paymentStatus = paymentStatus;
		this.paymentMode = paymentMode;
		this.paymentdate = paymentdate;
		this.appointment = appointment;
	}
	
	public Billing() {
		// TODO Auto-generated constructor stub
	}
	
}
