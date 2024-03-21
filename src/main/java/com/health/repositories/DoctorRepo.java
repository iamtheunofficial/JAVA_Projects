package com.health.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.model.Doctor;

public interface DoctorRepo  extends JpaRepository<Doctor, Long>{

}
