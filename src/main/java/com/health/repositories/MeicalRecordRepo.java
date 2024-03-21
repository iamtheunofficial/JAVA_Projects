package com.health.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.model.MedicalRecord;

public interface MeicalRecordRepo extends JpaRepository<MedicalRecord, Long> {

}
