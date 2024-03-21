package com.health.service;

import com.health.dto.BillingDto;
import com.health.model.Billing;
import java.util.List;

public interface IBillingService {

	public BillingDto addBill(Billing billing);
	public BillingDto getBill(Long appointmentId);
	public List<BillingDto> getAllBills(Long patientId);

}
