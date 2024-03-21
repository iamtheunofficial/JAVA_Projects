package com.health.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.health.dto.AppointmentDto;
import com.health.dto.DoctorDto;
import com.health.model.Appointment;
import com.health.service.IAppointmentService;
import com.health.service.IDoctorService;
import com.health.utility.Appointments;
import com.health.utility.StatusMsg;

@RestController
@RequestMapping("/api/doctor")
@PreAuthorize("hasRole('DOCTOR')")
public class DoctorRestController {

	
	@Autowired
	IDoctorService doctorService;
	
	@Autowired
	IAppointmentService appointmentService;
	
	@PostMapping("/addDoctor")
	public ResponseEntity<DoctorDto> saveDoctor(@RequestBody DoctorDto doctorDto){
	
		DoctorDto doc=doctorService.addDoctor(doctorDto);
		return new ResponseEntity<DoctorDto>(doc,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getalldoctor")
	public ResponseEntity<List<DoctorDto>> getDoctor(){
		List<DoctorDto> doc= doctorService.getAllDoctors();
		
	
		return new ResponseEntity<List<DoctorDto>>(doc,HttpStatus.OK);
	}
	
	@GetMapping("/getdoctor/{doctorId}")
	public ResponseEntity<DoctorDto> getDoctorDetail(@PathVariable Long doctorId){
		DoctorDto dto=doctorService.getDoctor(doctorId);
		return ResponseEntity.ok().body(dto);
	}
		
	@PutMapping("/updatedetails/{doctorId}")
	public ResponseEntity<DoctorDto> updateDoctorProfile(@RequestBody DoctorDto doctorDto,@PathVariable Long doctorId){
		
		DoctorDto dto=doctorService.updateDoctor(doctorDto, doctorId);
		return  ResponseEntity.ok(dto);
		
	}
	
	@GetMapping("/getappointments/{doctorId}")
	public ResponseEntity<List<Appointments>> getAllAppointments(@PathVariable Long doctorId){
		List<Appointments> appointmentList=appointmentService.getAllAppointmentOfDoctorId(doctorId);
	return ResponseEntity.ok(appointmentList);
	}
	
	@GetMapping("/appointmentcomplete/{appointmenId}")
	public ResponseEntity<StatusMsg> completeAppointmentStatus(@PathVariable Long appointmenId){
		StatusMsg status=appointmentService.completeAppointmentStatus(appointmenId);
	return ResponseEntity.ok(status);
	}
}
