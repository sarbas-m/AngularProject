package com.faith.app.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class TestPrescription {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer testPrescriptionId;
	private LocalDate testPresCreatedOn;
	private String testPresIsActive;
	
	@PrePersist
	@PreUpdate
	public void prePersist() {
		if(testPresCreatedOn==null) { //we set default value in case if the value is not set yet
			testPresCreatedOn=LocalDate.now();
		}
		if(testPresIsActive==null) {
			testPresIsActive="true";
		}
		
		}
	
	private Integer appointmentId;
	@ManyToOne
	@JoinColumn(name="appointmentId", insertable = false, updatable = false)
	private Appointment appointment;
	
	private Integer testId;
	@ManyToOne
	@JoinColumn(name="testId", insertable = false, updatable = false)
	private Test test;
	
	@JsonBackReference
	@OneToOne(mappedBy="testPrescription")
	private TestReport testReport;

	@Override
	public String toString() {
		return "TestPrescription [testPrescriptionId=" + testPrescriptionId + ", testPresCreatedOn=" + testPresCreatedOn
				+ ", testPresIsActive=" + testPresIsActive + ", appointmentId=" + appointmentId + ", appointment="
				+ appointment + ", testId=" + testId + ", test=" + test + "]";
	}

	public TestPrescription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getTestPrescriptionId() {
		return testPrescriptionId;
	}

	public void setTestPrescriptionId(Integer testPrescriptionId) {
		this.testPrescriptionId = testPrescriptionId;
	}

	public LocalDate getTestPresCreatedOn() {
		return testPresCreatedOn;
	}

	public void setTestPresCreatedOn(LocalDate testPresCreatedOn) {
		this.testPresCreatedOn = testPresCreatedOn;
	}

	public String getTestPresIsActive() {
		return testPresIsActive;
	}

	public void setTestPresIsActive(String testPresIsActive) {
		this.testPresIsActive = testPresIsActive;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public TestReport getTestReport() {
		return testReport;
	}

	public void setTestReport(TestReport testReport) {
		this.testReport = testReport;
	}

	public TestPrescription(Integer testPrescriptionId, LocalDate testPresCreatedOn, String testPresIsActive,
			Integer appointmentId, Appointment appointment, Integer testId, Test test, TestReport testReport) {
		super();
		this.testPrescriptionId = testPrescriptionId;
		this.testPresCreatedOn = testPresCreatedOn;
		this.testPresIsActive = testPresIsActive;
		this.appointmentId = appointmentId;
		this.appointment = appointment;
		this.testId = testId;
		this.test = test;
		this.testReport = testReport;
	}


}
