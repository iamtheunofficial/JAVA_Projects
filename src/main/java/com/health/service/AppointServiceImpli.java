package com.health.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.health.dto.AppointmentDto;
import com.health.enumclass.AppointmentSttaus;
import com.health.exception.AppointmentNotFound;
import com.health.exception.PatientNotFoundException;
import com.health.model.Appointment;
import com.health.model.Doctor;
import com.health.model.Patient;
import com.health.repositories.AppointmentRepo;
import com.health.repositories.DoctorRepo;
import com.health.repositories.PatientRepo;
import com.health.utility.AppointmentStatus;
import com.health.utility.Appointments;
import com.health.utility.StatusMsg;

import jakarta.mail.MessagingException;

@Service
@Transactional
public class AppointServiceImpli implements IAppointmentService {

	@Autowired
	AppointmentRepo appointmentRepo;

	@Autowired
	PatientRepo patientRepo;

	@Autowired
	DoctorRepo doctorRepo;

	@Autowired
	ModelMapper mapper;

	@Autowired
	MailService mailService;

	@Override
	public AppointmentStatus bookAppointment(AppointmentDto appointmentDto, Long patientId, Long doctorId) {
		Optional<Patient> patient = patientRepo.findById(patientId);
		Optional<Doctor> doctor = doctorRepo.findById(doctorId);
//		Double amount = appointmentDto.getAmount();
		if (patient.isPresent() && doctor.isPresent()) {
			Appointment appointment = mapper.map(appointmentDto, Appointment.class);
			appointment.setDoctor(doctor.get());
			appointment.setPatient(patient.get());
			appointment.setStatus(AppointmentSttaus.CONFIRMED);

			Appointment saved = appointmentRepo.save(appointment);
			AppointmentStatus status = new AppointmentStatus(saved.getAppointId(), saved.getStatus().name(),
					saved.getAppointDate(), saved.getDoctor().getDoctorName(), saved.getPatient().getPatientId());
			System.out.println(status);
			if (saved != null) {
				try {
					mailService.mailTrigger(status, patientId);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			return status;

		}
		throw new PatientNotFoundException("please check the patient and doctor id");
	}

	@Override
	public AppointmentStatus getAppointmentDetails(Long appointmentId) {
		Optional<Appointment> appointment = appointmentRepo.findById(appointmentId);
		if (appointment.isPresent()) {
			Appointment appointmentBooked = appointment.get();
			AppointmentStatus response = new AppointmentStatus(appointmentId, "your appointment is confirmed",
					appointmentBooked.getAppointDate(), appointmentBooked.getDoctor().getDoctorName(),
					appointmentBooked.getPatient().getPatientId());

			return response;
		}
		throw new AppointmentNotFound("there is no appointment booked");
	}

	@Override
	public AppointmentStatus updateAppointment(AppointmentDto appointmentDto, Long appointmentId) {
		return null;
	}

	@Override
	public Long deleteAppointment(Long appointmentId) {
		return null;
	}

	public Appointment get(Long id) {
		return appointmentRepo.findById(id).orElseThrow(() -> new AppointmentNotFound("No appointment found"));
	}

	@Override
	public List<Appointments> getAllAppointmentOfDoctorId(Long doctorId) {
		List<Appointment> appoiontments = appointmentRepo.findByDoctorId(doctorId);
		List<Appointments> dto = new ArrayList<>();
		for (Appointment k : appoiontments) {
			dto.add(mapper.map(k, Appointments.class));
		}
		;
		return dto;
	}
	@Override
	public AppointmentStatus reScheduleAppointment(AppointmentDto appointmentDto, Long appointmentId) {
Optional<Appointment>  optional=appointmentRepo.findById(appointmentId);
if(optional.isPresent()) {
	optional.get().setAppointDate(appointmentDto.getAppointDate());
	optional.get().setAppointTime(appointmentDto.getAppointTime());
	optional.get().setStatus(AppointmentSttaus.RESCHEDULED);
	Appointment updatedAppointment=appointmentRepo.save(optional.get());
	AppointmentStatus response = new AppointmentStatus(appointmentId, "your appointment is rescheduled to "+appointmentDto.getAppointDate() +" time = "+appointmentDto.getAppointTime(),
			updatedAppointment.getAppointDate(), updatedAppointment.getDoctor().getDoctorName(),
			updatedAppointment.getPatient().getPatientId());

	try {
		mailService.sendMail(response.getMsg(), optional.get().getPatient().getEmail());
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException("mail sending failed");
	}
	
	return response;
	
}	
throw new AppointmentNotFound("appointmernt not found");
	}
	
	@Override
	public StatusMsg completeAppointmentStatus(Long appointmentId) {
Optional<Appointment> a=appointmentRepo.findById(appointmentId).map(k->
{
k.setStatus(AppointmentSttaus.COMPLETED)	;
appointmentRepo.save(k);
return k;
}
		);
		if(a.isPresent()) {
			return new StatusMsg("AppointmentStatus updated succesfully", LocalDate.now());
		}
		throw new AppointmentNotFound("Appointment not found");
	}

}
