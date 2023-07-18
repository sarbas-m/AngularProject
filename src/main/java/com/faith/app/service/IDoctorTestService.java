package com.faith.app.service;

import java.util.List;

import com.faith.app.entity.TestPrescription;

public interface IDoctorTestService {
	
	public void addTest(TestPrescription testPrescription);
	
	public List<TestPrescription> getTestHistory(int patientId);
	
	public List<TestPrescription> getTodaysTest(int appointmentId,int userId);
	
	public void deleteTest(int testPrescriptionId);

}
