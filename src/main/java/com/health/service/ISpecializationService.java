package com.health.service;

import com.health.model.Specialization;
import java.util.List;

public interface ISpecializationService {

	public Specialization addSpecialization(Specialization specialization);
	public Specialization getSpecialization(Long specializationId);
	public List<Specialization> getSpecilization(List<Long> specializationIds);
public Specialization updateSpecialization(Specialization specialization,Long specializationId);
public Long deleteSpecialization(Long specializationId);

}
