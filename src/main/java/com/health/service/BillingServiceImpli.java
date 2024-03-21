package com.health.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.dto.BillingDto;
import com.health.model.Billing;
import com.health.repositories.BillingRepo;
import com.health.repositories.PatientRepo;

@Service
public class BillingServiceImpli implements IBillingService {

	@Autowired
	BillingRepo billingRepo;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	PatientRepo patientRepo;
	
	@Override
	public BillingDto addBill(Billing billing) {
		Billing b= billingRepo.save(billing);
		BillingDto billingDto= mapper.map(b, BillingDto.class);
		billingDto.setPatientName(b.getAppointment().getPatient().getName());
	return billingDto;
	}

	@Override
	public BillingDto getBill(Long appointId) {
		Billing b= billingRepo.findByAppointId(appointId).orElseThrow(()->new RuntimeException("please book the appointment"));
	
		BillingDto billingDto=mapper.map(b, BillingDto.class);
	 billingDto.setPatientName(b.getAppointment().getPatient().getName());
	 return billingDto;
	}
	@Override
	public List<BillingDto> getAllBills(Long patientId) {
		List<Billing> list= billingRepo.getAllBills(patientId);
		List<BillingDto> bills=new ArrayList<>();
		for(Billing k:list) {
			BillingDto dto=mapper.map(k, BillingDto.class);
			dto.setPatientName(k.getAppointment().getPatient().getName());
			bills.add(dto);
		}
		return bills;
	}

}
