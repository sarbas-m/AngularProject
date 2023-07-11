package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faith.app.entity.Test;
import com.faith.app.entity.TestReport;

@Repository
public interface ILabTestReportRepository extends CrudRepository<TestReport, Integer>{
	
	@Query("from TestReport where Report like %?1%")
	public List<TestReport> fingByReport(String name);
	
	@Query("from TestReport where testPrescription.appointmentId=?1")
	public List<TestReport>getTestReportHistory(Integer appointmentId);

	@Query("from TestReport where testPrescription.testPresIsActive='true'")
	public List<TestReport> getTestReport();
	
	@Query("from TestReport where isActive='true'")
	public List<TestReport> getTestList();
	
	@Query("from TestReport where testPrescriptionId=?1")
	public TestReport getReportByPrescriptionId(int testPrescriptionId);
	


}
