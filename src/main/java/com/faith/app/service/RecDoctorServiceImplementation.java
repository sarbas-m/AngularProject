package com.faith.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.entity.Doctor;
import com.faith.app.repo.IRecDoctorRepo;

@Service
public class RecDoctorServiceImplementation implements IRecDoctorsService{
	
	@Autowired
	private IRecDoctorRepo recDoctorRepo;

	@Override
	public List<Doctor> getDoctorsList() {
		// TODO Auto-generated method stub
		return (List<Doctor>) recDoctorRepo.findAll();
	}

	@Override
	public Doctor getDoctorById(int doctorId) {
		// TODO Auto-generated method stub
		return recDoctorRepo.findById(doctorId).orElseThrow(() -> new RuntimeException("Employee not found"+doctorId));
	}

}
