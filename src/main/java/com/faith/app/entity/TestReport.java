package com.faith.app.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class TestReport {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer testReportId;
	private Integer testActualValue;
	private LocalDate reportCreatedOn;
	@PrePersist
	@PreUpdate
	public void prePersist() {
		if(reportCreatedOn==null) {
			reportCreatedOn=LocalDate.now();
		}
	}
	
	private Integer testPrescriptionId;
	@OneToOne
	@JoinColumn(name="testPrescriptionId",insertable = false, updatable = false)
	private TestPrescription testPrescription;
	
	public Integer getTestReportId() {
		return testReportId;
	}
	public void setTestReportId(Integer testReportId) {
		this.testReportId = testReportId;
	}
	public Integer getTestActualValue() {
		return testActualValue;
	}
	public void setTestActualValue(Integer testActualValue) {
		this.testActualValue = testActualValue;
	}
	public LocalDate getReportCreatedOn() {
		return reportCreatedOn;
	}
	public void setReportCreatedOn(LocalDate reportCreatedOn) {
		this.reportCreatedOn = reportCreatedOn;
	}
	public Integer getTestPrescriptionId() {
		return testPrescriptionId;
	}
	public void setTestPrescriptionId(Integer testPrescriptionId) {
		this.testPrescriptionId = testPrescriptionId;
	}
	public TestPrescription getTestPrescription() {
		return testPrescription;
	}
	public void setTestPrescription(TestPrescription testPrescription) {
		this.testPrescription = testPrescription;
	}
	public TestReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TestReport [testReportId=" + testReportId + ", testActualValue=" + testActualValue
				+ ", reportCreatedOn=" + reportCreatedOn + ", testPrescriptionId=" + testPrescriptionId
				+ ", testPrescription=" + testPrescription + "]";
	}
	public TestReport(Integer testReportId, Integer testActualValue, LocalDate reportCreatedOn,
			Integer testPrescriptionId, TestPrescription testPrescription) {
		super();
		this.testReportId = testReportId;
		this.testActualValue = testActualValue;
		this.reportCreatedOn = reportCreatedOn;
		this.testPrescriptionId = testPrescriptionId;
		this.testPrescription = testPrescription;
	}
	


}


