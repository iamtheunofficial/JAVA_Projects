package com.health.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.health.model.Billing;
import java.util.List;

public interface BillingRepo  extends JpaRepository<Billing, Long>{

	@Query(" from com.health.model.Billing where appointment.appointId=:appointId")
	public Optional<Billing> findByAppointId(Long appointId);
	
	@Query(" from com.health.model.Billing where appointment.patient.patientId=:patientId")
	public List<Billing> getAllBills(Long patientId);
}
