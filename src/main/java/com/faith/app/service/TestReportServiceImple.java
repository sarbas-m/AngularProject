package com.faith.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faith.app.entity.TestPrescription;
import com.faith.app.entity.TestReport;
import com.faith.app.repo.ILabTestReportRepository;



@Service
public class TestReportServiceImple implements ITestReportService {
	
	@Autowired
	private ILabTestReportRepository testreport;


	@Override
	public List<TestReport> getTestReport() {
		return testreport.getTestReport();
	}

	@Override
	public void addTestReport(TestReport report) {
		testreport.save(report);
		//report.setTestReportId(report.getTestReportId());
		//testreport.save(report);		
	}

	@Override
	public Optional<TestReport> getTestReport(Integer id) {
		// TODO Auto-generated method stub
		return testreport.findById(id);
	}

//	public void deleteTestReport(int id) {
//		testreport.deleteById(id);
//	}
//		
//		

	@Override
	public List<TestReport> getTestReportByName(String name) {
		return testreport.fingByReport(name);
	}


	@Override
	public List<TestReport> getTestReportHistory(Integer appointmentId) {
		return(List<TestReport>) testreport.getTestReportHistory(appointmentId);
	}

	

	@Override
	public TestReport getTestReportByTestReportId(int testReportId) {
		// TODO Auto-generated method stub
		return testreport.getReportByPrescriptionId(testReportId);
	}

	@Override
	public List<TestReport> getTestList() {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public void disableTestReport(int testId) {
         
		testreport.disableTest(testId);
	}*/	
	
}
