package com.health.service;

import java.time.LocalDate;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.dto.InsurencePolicyDto;
import com.health.exception.PatientNotFoundException;
import com.health.model.InsurencePolicy;
import com.health.model.Patient;
import com.health.repositories.InsurencePolicyRepo;
import com.health.repositories.PatientRepo;
import com.health.utility.StatusMsg;

@Service
public class InsurencePolicyServiceImpli implements IInsurencePolicyService{

	@Autowired
	PatientRepo patientRepo;
	
	@Autowired
	InsurencePolicyRepo policyRepo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public StatusMsg addInsurence(InsurencePolicyDto policy,Long patientId) {
	Optional<Patient> patient=patientRepo.findById(patientId);
		if(patient.isPresent()) {
			Patient patientSaved=patient.get();
			InsurencePolicy mappedPolicy=mapper.map(policy, InsurencePolicy.class);
			InsurencePolicy insurence=policyRepo.save(mappedPolicy);
			patientSaved.setInsurence(insurence);
			patientRepo.save(patientSaved);
			return new StatusMsg("Insurence added with the id ="+insurence.getInsurenceId(), LocalDate.now());
			
		}
	throw new PatientNotFoundException("No patient found");	
	}

	@Override
	public InsurencePolicy getInsurence(Long insurenceId) {
		return null;
	}

	@Override
	public InsurencePolicy updateInsurence(InsurencePolicy policy, Long insurenceId) {
		return null;
	}

	@Override
	public Long deleteInsurence(Long insurenceId) {
		return null;
	}
	@Override
	public Double getInsurenceAmount(Long patientId) {
		Optional<Patient> patient=patientRepo.findById(patientId);
		if(patient.isPresent()) {
		 InsurencePolicy policy = patient.get().getInsurence();
	if(policy!=null) {
		return policy.getInsurenceAmount();
	}
	return 0d;
		}
		throw new PatientNotFoundException("patient not found");
	}

}
