package com.faith.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faith.app.entity.Appointment;
import com.faith.app.repo.IDoctorAppointRepository;

@Service
public class DoctorAppointServiceImple implements IDoctorAppointService {
	
	@Autowired
	private IDoctorAppointRepository doctorRepo;


	@Override
	public List<Appointment> getTodaysAppointmentList(int userId) {
		// TODO Auto-generated method stub
		return  doctorRepo.getTodaysAppointmentList(userId);
	}



	@Override
	public Appointment getAppointmentList(int appointmentId) {
		// TODO Auto-generated method stub
		return doctorRepo.findById(appointmentId).orElseThrow(() -> new RuntimeException("Appointment not found"+appointmentId));
	}



	@Override
	public List<Appointment> getPatientDat(int tokenNo) {
		
		// TODO Auto-generated method stub
		return doctorRepo.getPatientDat(tokenNo);
	}



	@Override
	@Transactional
	public void disableAppoint(int appointmentId) {
		
		doctorRepo.disableApp(appointmentId);
		
	}



	@Override
	public List<Appointment> getDisabledAppointmentList(int userId) {
		// TODO Auto-generated method stub
		return doctorRepo.getDisabledAppointmentList(userId);
	}



	



	

}
