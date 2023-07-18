package com.faith.app.service;

import java.util.List;


import com.faith.app.entity.TestReport;

public interface IDoctorReportService {
	
	public List<TestReport> getTestReport(int patientId);

}
