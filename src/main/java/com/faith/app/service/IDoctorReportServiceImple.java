package com.faith.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.entity.TestReport;
import com.faith.app.repo.IDoctorReportRepository;

@Service
public class IDoctorReportServiceImple implements IDoctorReportService {
   
	@Autowired
	private IDoctorReportRepository reportRepo;
	
	@Override
	public List<TestReport> getTestReport(int patientId) {
		// TODO Auto-generated method stub
		return reportRepo.getTestReport(patientId);
	}

}
