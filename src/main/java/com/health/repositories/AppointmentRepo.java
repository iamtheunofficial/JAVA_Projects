package com.health.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.health.model.Appointment;
import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment, Long>{

	@Query(" from com.health.model.Appointment where doctor.doctorId=:doctorId and status IN ('CONFIRMED' ,'RESCHEDULED')")
	public List<Appointment> findByDoctorId(Long doctorId);
	
	@Query(" from com.health.model.Appointment where doctor.doctorId=:doctorId ")
	public List<Appointment> findAppointmentsDoctorId(Long doctorId);
	
	@Query("select patient.patientId from com.health.model.Appointment where patient.patientId=:patientId ")
	public List<Long> findByPatientId(Long patientId);
}
