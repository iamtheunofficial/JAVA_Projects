package com.health.service;

import com.health.dto.DoctorDto;
import com.health.utility.StatusMsg;

import java.util.List;

public interface IDoctorService {

	public DoctorDto addDoctor(DoctorDto doctorDto);
	public DoctorDto updateDoctor(DoctorDto doctorDto,Long doctorId);
	public DoctorDto getDoctor(Long doctorId);
	public StatusMsg deleteDoctor(Long doctorId);
	
	public List<DoctorDto> getAllDoctors();
}
