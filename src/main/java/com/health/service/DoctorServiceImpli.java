package com.health.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.health.dto.DoctorDto;
import com.health.enumclass.AppointmentSttaus;
import com.health.repositories.AppointmentRepo;
import com.health.repositories.DoctorRepo;
import com.health.repositories.RoleRepo;
import com.health.repositories.SpecializationRepo;
import com.health.utility.StatusMsg;

import jakarta.mail.MessagingException;
import com.health.model.*;

@Service
@Transactional
public class DoctorServiceImpli implements IDoctorService {

	@Autowired
	DoctorRepo doctorRepo;

	@Autowired
	ModelMapper mapper;

	@Autowired
	AppointmentRepo appointmentRepo;

	@Autowired
	SpecializationRepo specializationRepo;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoleRepo roleRepo;

	@Autowired
	PasswordEncoder encoder;
	@Override
	public DoctorDto addDoctor(DoctorDto doctorDto) {
		Doctor doc = mapper.map(doctorDto, Doctor.class);
		
		Set<String> specilization = doctorDto.getSpecializations();
		Set<Specialization> spec = new LinkedHashSet<>();

		for (String k : specilization) {
			spec.add(new Specialization(k, null, Set.of(doc)));

		}
		doc.setSpecializations(spec);
		specializationRepo.saveAll(spec);
		Doctor d = doctorRepo.save(doc);
		DoctorDto dto = mapper.map(d, DoctorDto.class);
		Role role=roleRepo.save(new Role("DOCTOR"));

		userService.save(new com.health.model.User(d.getDoctorName(),encoder.encode(d.getEmail()) ,role, true));
		return dto;

	}

	@Override
	public List<DoctorDto> getAllDoctors() {
		List<Doctor> doctors = doctorRepo.findAll();
		List<DoctorDto> dto = new ArrayList<>();

		System.out.println(doctors);
		for (Doctor k : doctors) {
			DoctorDto docDto = mapper.map(k, DoctorDto.class);
			docDto.setDoctorId(k.getDoctorId());
			dto.add(docDto);
		}
		return dto;
	}

	@Override
	public DoctorDto updateDoctor(DoctorDto doctorDto, Long doctorId) {
		Optional<Doctor> doctor = doctorRepo.findById(doctorId);
		if (doctor.isPresent()) {
			Set<String> spec = doctorDto.getSpecializations();
			Doctor d = mapper.map(doctorDto, Doctor.class);
			Set<Specialization> specialization = new LinkedHashSet<>();

			for (String k : spec) {
				specialization.add(new Specialization(k, null, Set.of(doctor.get())));

			}
			d.setSpecializations(specialization);
			specializationRepo.saveAll(specialization);
			return mapper.map(doctorRepo.save(d), DoctorDto.class);
		}
		throw new RuntimeException("doctor not found");
	}

	@Override
	public DoctorDto getDoctor(Long doctorId) {
		Doctor doc = doctorRepo.findById(doctorId).orElseThrow(() -> new RuntimeException("doctor not found"));
		return mapper.map(doc, DoctorDto.class);
	}

	@Override
	public StatusMsg deleteDoctor(Long doctorId) {
		Optional<Doctor> doctor = doctorRepo.findById(doctorId);
if(doctor.isPresent()) {
		List<Appointment> appoints = appointmentRepo.findAppointmentsDoctorId(doctorId);
		if (appoints.size()!=0) {
for(Appointment k:appoints) {
	k.setDoctor(null);
	k.setStatus(AppointmentSttaus.CANCELLED);
}
appointmentRepo.saveAll(appoints);

doctorRepo.deleteById(doctorId);

			for(Appointment l:appoints) {
				String mail=l.getPatient().getEmail();
				try {
					String response=mailService.sendMail(" your Appointment has been cancelled we will get back to you soon ",mail);
				} catch (MessagingException e) {
				throw new RuntimeException("error while sending mail");
				}
				
			}
		} else {
			doctorRepo.findById(doctorId).map(k -> {
				doctorRepo.deleteById(doctorId);
				return k;
			}).get();
			
		}
		return new StatusMsg("Success", LocalDate.now());
}
throw new RuntimeException("doctor not found invalid doctor id");

	}

}
