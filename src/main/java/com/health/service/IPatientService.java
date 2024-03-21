package com.health.service;

import com.health.dto.MfaTokenData;
import com.health.dto.PatientDto;
import com.health.model.Patient;

public interface IPatientService {

	public MfaTokenData addPatient(PatientDto patientDto);

	public Patient getPatient(Long patientId);

	public Patient updatePatientDetails(PatientDto patientDto, Long patientId);

	public Patient updateNameAndEmail(String name, String email, Long patientId);

	public Patient deletePatientById(Long patientId);
    public boolean verifyTotp(String code, String username) ;

}
