package com.faith.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.entity.TestPrescription;
import com.faith.app.repo.IDoctorTestRepository;

@Service
public class DoctorTestServiceImple implements IDoctorTestService {
	
	@Autowired
	private IDoctorTestRepository testRepo;

	@Override
	public void addTest(TestPrescription testPrescription) {
		
		testRepo.save(testPrescription);

	}

	@Override
	public List<TestPrescription> getTestHistory(int patientId) {
		// TODO Auto-generated method stub
		return testRepo.getTestHistory(patientId);
	}

	@Override
	public List<TestPrescription> getTodaysTest(int appointmentId,int userId) {
		// TODO Auto-generated method stub
		return testRepo.getTodaysTest(appointmentId,userId);
	}

	@Override
	public void deleteTest(int testPrescriptionId) {
		
		testRepo.deleteById(testPrescriptionId);
		
	}

}
