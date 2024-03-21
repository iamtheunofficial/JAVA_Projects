package com.health.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.model.Specialization;

public interface SpecializationRepo extends JpaRepository<Specialization, Long>{

}
