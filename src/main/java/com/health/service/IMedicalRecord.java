package com.health.service;

import com.health.dto.MedicalRecordDto;
import com.health.model.MedicalRecord;

public interface IMedicalRecord {

	public MedicalRecord addRecord(MedicalRecord medicalRecord);
	public MedicalRecordDto getPatientRecord(Long recordId);
	public MedicalRecord updateRecord(MedicalRecord medicalRecord,Long recordId);
	public Long deleteRecord(Long recordId);
	}
