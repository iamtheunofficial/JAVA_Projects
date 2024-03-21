package com.health.dto;

import java.time.LocalDate;
import java.time.LocalTime;


public class AppointmentDto {

	private LocalDate appointDate;
	private LocalTime appointTime;
//	private Double amount;
	

//public Double getAmount() {
//		return amount;
//	}
//	public void setAmount(Double amount) {
//		this.amount = amount;
//	}
public LocalDate getAppointDate() {
	return appointDate;
}
public void setAppointDate(String appointDate) {
	
	this.appointDate = LocalDate.parse(appointDate);
}
public LocalTime getAppointTime() {
	return appointTime;
}
public void setAppointTime(String appointTime) {
	this.appointTime = LocalTime.parse(appointTime);
}


public AppointmentDto(LocalDate appointDate, LocalTime appointTime) {
	super();
	this.appointDate = appointDate;
	this.appointTime = appointTime;
	

}

public AppointmentDto() {
}
	
	


}
