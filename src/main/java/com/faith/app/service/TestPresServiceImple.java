package com.faith.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faith.app.entity.TestPrescription;
import com.faith.app.repo.ILabTestPrescriptionRepository;

@Service
public class TestPresServiceImple implements ITestPrescriptionService {
	
	@Autowired
	private ILabTestPrescriptionRepository testprescription;

	@Override
	public List<TestPrescription> getTestPrescription() {
		return testprescription.getTestPrescription();
	}

	@Override
	public void addTestPrescription(TestPrescription testpres) {
		testprescription.save(testpres);
		
	}

	@Override
	public List<TestPrescription> getTestPrescriptionHistory(Integer appointmentId) {
		
		System.out.println(testprescription.getTestPrescriptionHistory(appointmentId));
		return(List<TestPrescription>) testprescription.getTestPrescriptionHistory(appointmentId);

	}

	@Transactional
	public void disableTestPrescription(int appointmentId) {
		
		testprescription.disableTestPrescription(appointmentId);
		
	}

}
