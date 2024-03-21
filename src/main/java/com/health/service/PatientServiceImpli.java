package com.health.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.health.dto.MfaTokenData;
import com.health.dto.MfaTokenData;
import com.health.dto.PatientDto;
import com.health.exception.PatientNotFoundException;
import com.health.model.Appointment;
import com.health.model.Patient;
import com.health.model.Role;
import com.health.model.User;
import com.health.repositories.AppointmentRepo;
import com.health.repositories.PatientRepo;
import com.health.repositories.RoleRepo;
import com.health.repositories.UserRepo;

import dev.samstevens.totp.exceptions.QrGenerationException;

@Service
public class PatientServiceImpli implements IPatientService {

	@Autowired
	PatientRepo patientRepo;

	@Autowired
	ModelMapper mapper;
	
	@Autowired
	UserService service;
	
	@Autowired
	RoleRepo roleRepo;
	
	@Autowired
	AppointmentRepo appointmentRepo;
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
    TotpManager totpManager;


	@Override
	public MfaTokenData addPatient(PatientDto patientDto) {

		Patient patient = mapper.map(patientDto, Patient.class);
		Patient reposne= patientRepo.save(patient);
		
		Role role=roleRepo.save(new Role("PATIENT"));
		User savedUser=new User(reposne.getName(),encoder.encode(reposne.getEmail()), role,totpManager.generateSecretKey(),true, true);
User saved=service.save(savedUser)	;
String qrCode;
		try {
			qrCode = totpManager.getQRCode(saved.getSecretKey());
			 return new MfaTokenData(saved.getSecretKey(), qrCode);
		} catch (QrGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return null;
				

	}

	 @Override
	    public boolean verifyTotp(String code, String username) {
	        User user = service.findByName(username);
	        System.out.println(user);
	        return totpManager.verifyTotp(code, user.getSecretKey());
	    }
	
	@Override
	public Patient getPatient(Long patientId) {
		Optional<Patient> patient = patientRepo.findById(patientId);
		return patient.orElseThrow(() -> new PatientNotFoundException("There no patient available for the given id"));

	}

	@Override
	public Patient updatePatientDetails(PatientDto patientDto, Long patientId) {
		Patient patient = mapper.map(patientDto, Patient.class);
		patient.setPatientId(patientId);
		return patientRepo.findById(patientId).map(existingPatient -> patientRepo.save(patient))
				.orElseThrow(() -> new PatientNotFoundException("Patient not found with given id"));

	}

	@Override
	public Patient updateNameAndEmail(String name, String email, Long patientId) {

		return patientRepo.findById(patientId).map(p ->

		{
			p.setName(name);
			p.setEmail(email);
			return patientRepo.save(p);
		}).orElseThrow(() -> new PatientNotFoundException("Patient not found with given id"));

	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public Patient deletePatientById(Long patientId) {
		Optional<Patient> optional=patientRepo.findById(patientId);
		if(optional.isPresent()) {
			List<Long> appointments=appointmentRepo.findByPatientId(patientId);
			List<Appointment> appoints=appointmentRepo.findAllById(appointments);
			if(appoints.size()!=0) {
			Patient dummyPatient	=patientRepo.findById(1l).get();
				for(Appointment k:appoints) {
					k.setPatient(dummyPatient);
					System.out.println(k);
				}
				appointmentRepo.saveAll(appoints);
			}
			patientRepo.deleteById(patientId);
			return optional.get();
		}
	throw	new PatientNotFoundException("Patient not found with given id");

	}

}
