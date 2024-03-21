package com.health.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.model.Patient;

public interface PatientRepo extends JpaRepository<Patient,Long>{

	public Optional<Patient> findByEmail(String email);
	public Optional<Patient> findByName(String name);

}
