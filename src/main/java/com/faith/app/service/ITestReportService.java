package com.faith.app.service;

import java.util.List;
import java.util.Optional;

import com.faith.app.entity.Test;
import com.faith.app.entity.TestPrescription;
import com.faith.app.entity.TestReport;

public interface ITestReportService {

//list
public List<TestReport> getTestReport();

//Insert
public void addTestReport(TestReport report);

//update by id
public Optional<TestReport> getTestReport(Integer id);

//Delete

//find by TestReport name
public List<TestReport> getTestReportByName(String name);

//list particular
public List<TestReport>getTestReportHistory(Integer patientId);

//public void disableTestReport(int testId);

public List<TestReport> getTestList();

public TestReport getTestReportByTestReportId(int testReportId);

}