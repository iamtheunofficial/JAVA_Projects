package com.health.service;

import com.health.dto.AppointmentDto;
import com.health.model.Appointment;
import com.health.utility.AppointmentStatus;
import com.health.utility.Appointments;
import com.health.utility.StatusMsg;

import java.util.List;

public interface IAppointmentService {

	public AppointmentStatus bookAppointment(AppointmentDto appointmentDto,Long patientId,Long doctorId);
public AppointmentStatus getAppointmentDetails(Long appointmentId);
public AppointmentStatus updateAppointment(AppointmentDto appointmentDto,Long appointmentId);
public Long deleteAppointment(Long appointmentId);
public Appointment get(Long id);

public List<Appointments> getAllAppointmentOfDoctorId(Long doctorId);
public AppointmentStatus reScheduleAppointment(AppointmentDto appointmentDto, Long appointmentId);
public StatusMsg completeAppointmentStatus(Long appointmentId);
}
