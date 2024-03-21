package com.health.dto;

import java.time.LocalDate;

public class MedicalRecordDto {

	private Long recordId;
	private String diagnosis;
	private String treatement;
	private String medication;
	private String note;
	private LocalDate date;
private String patientName;
private String doctorName;
public Long getRecordId() {
	return recordId;
}
public void setRecordId(Long recordId) {
	this.recordId = recordId;
}
public String getDiagnosis() {
	return diagnosis;
}
public void setDiagnosis(String diagnosis) {
	this.diagnosis = diagnosis;
}
public String getTreatement() {
	return treatement;
}
public void setTreatement(String treatement) {
	this.treatement = treatement;
}
public String getMedication() {
	return medication;
}
public void setMedication(String medication) {
	this.medication = medication;
}
public String getNote() {
	return note;
}
public void setNote(String note) {
	this.note = note;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public String getPatientName() {
	return patientName;
}
public void setPatientName(String patientName) {
	this.patientName = patientName;
}
public String getDoctorName() {
	return doctorName;
}
public void setDoctorName(String doctorName) {
	this.doctorName = doctorName;
}
@Override
public String toString() {
	return "MedicalRecordDto [recordId=" + recordId + ", diagnosis=" + diagnosis + ", treatement=" + treatement
			+ ", medication=" + medication + ", note=" + note + ", date=" + date + ", patientName=" + patientName
			+ ", doctorName=" + doctorName + "]";
}
public MedicalRecordDto(Long recordId, String diagnosis, String treatement, String medication, String note,
		LocalDate date, String patientName, String doctorName) {
	super();
	this.recordId = recordId;
	this.diagnosis = diagnosis;
	this.treatement = treatement;
	this.medication = medication;
	this.note = note;
	this.date = date;
	this.patientName = patientName;
	this.doctorName = doctorName;
}

public MedicalRecordDto() {
}


}
