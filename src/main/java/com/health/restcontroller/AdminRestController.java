package com.health.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health.dto.AppointmentDto;
import com.health.dto.DoctorDto;
import com.health.service.IAppointmentService;
import com.health.service.IDoctorService;
import com.health.service.MailService;
import com.health.utility.AppointmentStatus;
import com.health.utility.StatusMsg;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

	@Autowired
	IDoctorService doctorService;
	
	@Autowired
	IAppointmentService appointmentService;
	
	@DeleteMapping("/deletedoctor/{doctorId}")

	@PreAuthorize("hasRole('ADMIN') and hasAuthority('WRITE') and #doctorId!=0")
	public ResponseEntity<?> deleteDoctor(@PathVariable Long doctorId){
		StatusMsg response=doctorService.deleteDoctor(doctorId);
	
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/reschedule/{appointmentId}")
	public ResponseEntity<AppointmentStatus> reScheduleAppointment(@RequestBody AppointmentDto appointmentDto,@PathVariable Long appointmentId){
		AppointmentStatus appointmentStatus=appointmentService.reScheduleAppointment(appointmentDto,appointmentId);
	System.out.println("controll");
		return ResponseEntity.ok(appointmentStatus);
	}
}
