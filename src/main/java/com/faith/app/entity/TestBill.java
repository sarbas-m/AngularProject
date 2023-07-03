package com.faith.app.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class TestBill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer testBillId;
	private String testbillNumber;
	private Integer testBillAmount;

	private LocalDate testBillCreatedOn;
	private String testBillIsActive;

	@PrePersist
	@PreUpdate
	private void prePersist() {
		if (testBillIsActive == null) {
			testBillIsActive = "true";
		}
		if (testBillCreatedOn == null) {
			testBillCreatedOn = LocalDate.now();
		}
	}

	private Integer appointmentId;
	@ManyToOne
	@JoinColumn(name = "appointmentId", insertable = false, updatable = false)
	private Appointment appointment;

	public Integer getTestBillId() {
		return testBillId;
	}
	public void setTestBillId(Integer testBillId) {
		this.testBillId = testBillId;
	}
	public String getTestbillNumber() {
		return testbillNumber;
	}
	public void setTestbillNumber(String testbillNumber) {
		this.testbillNumber = testbillNumber;
	}
	public Integer getTestBillAmount() {
		return testBillAmount;
	}
	public void setTestBillAmount(Integer testBillAmount) {
		this.testBillAmount = testBillAmount;
	}
	public LocalDate getTestBillCreatedOn() {
		return testBillCreatedOn;
	}
	public void setTestBillCreatedOn(LocalDate testBillCreatedOn) {
		this.testBillCreatedOn = testBillCreatedOn;
	}
	public String getTestBillIsActive() {
		return testBillIsActive;
	}
	public void setTestBillIsActive(String testBillIsActive) {
		this.testBillIsActive = testBillIsActive;
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
	public TestBill(Integer testBillId, String testbillNumber, Integer testBillAmount, LocalDate testBillCreatedOn,
			String testBillIsActive, Integer appointmentId, Appointment appointment) {
		super();
		this.testBillId = testBillId;
		this.testbillNumber = testbillNumber;
		this.testBillAmount = testBillAmount;
		this.testBillCreatedOn = testBillCreatedOn;
		this.testBillIsActive = testBillIsActive;
		this.appointmentId = appointmentId;
		this.appointment = appointment;
	}
	public TestBill() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TestBill [testBillId=" + testBillId + ", testbillNumber=" + testbillNumber + ", testBillAmount="
				+ testBillAmount + ", testBillCreatedOn=" + testBillCreatedOn + ", testBillIsActive=" + testBillIsActive
				+ ", appointmentId=" + appointmentId + ", appointment=" + appointment + "]";
	}

	
	
}
