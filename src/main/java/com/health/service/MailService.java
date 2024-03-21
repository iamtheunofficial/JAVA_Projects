package com.health.service;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.health.exception.PatientNotFoundException;
import com.health.model.Patient;
import com.health.repositories.PatientRepo;
import com.health.utility.AppointmentStatus;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService  {

	@Autowired
	JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@Autowired
	private PatientRepo patientRepo;
	
	public String mailTrigger(AppointmentStatus appointment,Long patientId) throws MessagingException {
	Optional<Patient> patient=patientRepo.findById(patientId);
	if(patient.isPresent()) {
	String	msg= "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <title>Appointment Status</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <h2>Appointment Status</h2>\n" +
            "    <p>Your appointment is confirmed with Dr. " + appointment.getDoctorName() + " on " + appointment.getDateOfAppointment() + ".</p>\n" +
            "    <p>Appointment ID: " + appointment.getAppointId() + "</p>\n" +
            "    <p>Message: " + appointment.getMsg() + "</p>\n" +
            "</body>\n" +
            "</html>";
	String status=sendMail(msg, patient.get().getEmail());
	
return status;
	}
	throw new PatientNotFoundException("invalid email address");
	}

	
	public String sendMail(String msg, String email) throws MessagingException {
		MimeMessage message=javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(fromEmail);
		helper.setCc(email);
		helper.setSubject("Appointment is Confirmed");
		helper.setSentDate(new Date());
		helper.setText(msg,true);
//		helper.addAttachment("download.png", new ClassPathResource("download.png"));
		javaMailSender.send(message);
		return "mail-sent";
	}

}