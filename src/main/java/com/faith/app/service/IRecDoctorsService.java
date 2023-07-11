package com.faith.app.service;

import java.util.List;

import com.faith.app.entity.Doctor;

public interface IRecDoctorsService {
	
	public List<Doctor> getDoctorsList();
	
	public Doctor getDoctorById(int doctorId);

}
