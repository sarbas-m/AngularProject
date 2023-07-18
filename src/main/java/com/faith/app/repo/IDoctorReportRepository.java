package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.faith.app.entity.TestReport;

public interface IDoctorReportRepository extends CrudRepository<TestReport,Integer> {
	
	@Query("from TestReport where testPrescription.appointment.patientId=?1")
	public List<TestReport> getTestReport(int patientId);

}
