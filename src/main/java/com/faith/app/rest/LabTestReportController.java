package com.faith.app.rest;

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

import com.faith.app.entity.TestReport;
import com.faith.app.service.ITestReportService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LabTestReportController {

  @Autowired
  private ITestReportService testReportService;

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
    return testReportService.getTestReportHistory(appointmentId);
  }

 
}
