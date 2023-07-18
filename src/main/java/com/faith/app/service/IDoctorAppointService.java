package com.faith.app.service;

import java.util.List;
import java.util.Optional;
import com.faith.app.entity.Appointment;


public interface IDoctorAppointService {
		
	public List<Appointment> getTodaysAppointmentList(int userId);
		
	public Appointment getAppointmentList(int appointmentId);
	
	public List<Appointment> getPatientDat(int tokenNo);
	
	public void disableAppoint(int appointmentId);
	
	public List<Appointment> getDisabledAppointmentList(int userId);

	

}
