package com.faith.app.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.demo.EmailSenderService;
import com.faith.app.entity.TestReport;
import com.faith.app.service.ITestReportService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LabTestReportController {

	@Autowired
	private ITestReportService testReportService;
	
	@Autowired
	private EmailSenderService service;

	@GetMapping("/report")
	public List<TestReport> getAllTestReports() {
		return testReportService.getTestReport();
	}

	@PostMapping("/report")
	public void addTestReport(@RequestBody TestReport report) {
		testReportService.addTestReport(report);
	}

	@GetMapping("/report/{testPrescriptionId}")
	public TestReport getTestReport(@PathVariable int testPrescriptionId) {
		System.out.println(testReportService.getTestReportByTestReportId(testPrescriptionId));
		return testReportService.getTestReportByTestReportId(testPrescriptionId);
	}

	@PutMapping("/report")
	public void updateTestReport(@RequestBody TestReport report) {
		testReportService.addTestReport(report);
	}

	@GetMapping("/report/search/{name}")
	public List<TestReport> getAllTestReportsByName(@PathVariable String name) {
		return testReportService.getTestReportByName(name);
	}

	@GetMapping("/report/history/{appointmentId}")
	public List<TestReport> getTestReportHistory(@PathVariable int appointmentId) {
		List<TestReport> report = testReportService.getTestReportHistory(appointmentId);
		String email = "";
		String patientName = "";
		String patientRegNo = "";
		LocalDate date = null;
		int lowRange = 0;
		int highRange = 0;
		int ActualValue = 0;
		String unit = "";
		String testName = "";
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%-30s%-25s%-25s%-25s%-25s%n", "TestName", "Low Range", "High Range","Result","Unit"));
		stringBuilder.append("-------------------------------------------------------------------------------------------------------------------\n");
		for (TestReport a : report) {
			email = a.getTestPrescription().getAppointment().getPatient().getPatientEmail();
			patientName = a.getTestPrescription().getAppointment().getPatient().getPatientName();
			patientRegNo = a.getTestPrescription().getAppointment().getPatient().getRegistrationNumber();
			date = a.getReportCreatedOn();
			lowRange = a.getTestPrescription().getTest().getLowRange();
			highRange = a.getTestPrescription().getTest().getHighRange();
			ActualValue = a.getTestActualValue();
			unit = a.getTestPrescription().getTest().getUnit();
			testName = a.getTestPrescription().getTest().getTestName();
			stringBuilder.append(String.format("%-30s%-25s%-25s%-25s%-25s%n", testName,lowRange,highRange,ActualValue,unit));

		}
		String result = stringBuilder.toString();
		String sub="Test Report("+LocalDate.now()+")";
		String body="Dear "+patientName+","+
		"\nPlease find the Test Report."+
				"\n\nPatient Reg.No : "+patientRegNo+
				"\n\nDate :"+date+"\n"+
				result+
				"\n\nSincerely,\nJenisha\nLabTechnician,Med Star Hospital";
		try {
			service.sendSimpleEmail(email, body, sub);
		}catch(Exception e) {
			System.out.println(e);
		}

		return testReportService.getTestReportHistory(appointmentId);
	}

}
