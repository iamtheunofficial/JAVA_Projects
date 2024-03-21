package com.health.service;

import org.springframework.stereotype.Service;

import com.health.dto.MedicalRecordDto;
import com.health.model.MedicalRecord;

@Service
public class MedicalRecordImpli implements IMedicalRecord {

	@Override
	public MedicalRecord addRecord(MedicalRecord medicalRecord) {
		return null;
	}

	@Override
	public MedicalRecordDto getPatientRecord(Long recordId) {
		return null;
	}

	@Override
	public MedicalRecord updateRecord(MedicalRecord medicalRecord, Long recordId) {
		return null;
	}

	@Override
	public Long deleteRecord(Long recordId) {
		return null;
	}

}
