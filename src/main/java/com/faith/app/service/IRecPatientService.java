package com.faith.app.service;

import java.util.List;

import com.faith.app.entity.Patient;

public interface IRecPatientService {
	
	public List<Patient> getListPatient();
	
	public void addThePatient(Patient patients);

	public Patient getPatientByTheId(int id);
	
	public void disAblePatient(Patient patient);
	public int getPrimaryKey();
	
	public String getRegistrationNumber(int patientId);
}
