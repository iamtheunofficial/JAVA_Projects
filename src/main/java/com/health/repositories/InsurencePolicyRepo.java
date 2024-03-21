package com.health.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.model.InsurencePolicy;

public interface InsurencePolicyRepo extends JpaRepository<InsurencePolicy, Long>{

}
