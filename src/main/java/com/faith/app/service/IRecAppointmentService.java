package com.faith.app.service;

import java.util.List;

import com.faith.app.entity.Appointment;

public interface IRecAppointmentService {
	
	public List<Appointment> listOfAppointments();
	
	public void addTheAppointment(Appointment appoint);
	
	public Appointment getAppoinmentById(int id);
	
	public void disAbleAppoint(Appointment appointmenting);
	
	public List<Appointment> listAppointByPatient(int patientId);
	
	public int getMaxAppointId();
	
	public Appointment gettingApDetails(int appId);
	
	public int gettingTokenNum(int apoId);
	

	
	

}
