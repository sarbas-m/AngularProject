package com.faith.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.entity.Appointment;
import com.faith.app.repo.IRecAppointmentRepo;

@Service
public class RecAppointmentServiceImplementation implements IRecAppointmentService{

	@Autowired
	private IRecAppointmentRepo appointmentRepo;
	
	@Override
	public List<Appointment> listOfAppointments() {
		// TODO Auto-generated method stub
		return (List<Appointment>) appointmentRepo.listOfAppointments();
	}

	@Override
	public void addTheAppointment(Appointment appoint) {
		// TODO Auto-generated method stub
		appointmentRepo.save(appoint);
		
		
	}

	@Override
	public Appointment getAppoinmentById(int id) {
		// TODO Auto-generated method stub
		return appointmentRepo.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found"+id));
	}

	@Override
	public void disAbleAppoint(Appointment appointmenting) {
		
		appointmenting.setAppointmentIsActive("false");
		appointmentRepo.save(appointmenting);
		
	}

	@Override
	public List<Appointment> listAppointByPatient(int patientId) {
		// TODO Auto-generated method stub
		return appointmentRepo.listAppointByPatient(patientId);
	}

	@Override
	public int getMaxAppointId() {
		// TODO Auto-generated method stub
		return appointmentRepo.getMaxAppointId();
	}

	@Override
	public Appointment gettingApDetails(int appId) {
		// TODO Auto-generated method stub
		return appointmentRepo.gettingApDetails(appId);
	}

	@Override
	public int gettingTokenNum(int apoId) {
		// TODO Auto-generated method stub
		return appointmentRepo.gettingTokenNum(apoId);
	}


	
	
	
	

}
