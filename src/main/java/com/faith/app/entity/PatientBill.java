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
public class PatientBill {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer patientBillId;
	private Integer patientBillAmount;
	private LocalDate patientbillCreatedOn;
	private String patientBillIsActive;
	private String patientBillNo;
	
	@PrePersist
	@PreUpdate	
	private void persist() {
		if(patientBillIsActive==null)
			patientBillIsActive="true";
		if(patientbillCreatedOn==null) { //we set default value in case if the value is not set yet
			patientbillCreatedOn=LocalDate.now();
		}
	}
	
	public String getPatientBillNo() {
		return patientBillNo;
	}
	public void setPatientBillNo(String patientBillNo) {
		this.patientBillNo = patientBillNo;
	}

	private Integer appointmentId;
	@ManyToOne
	@JoinColumn(name="appointmentId",insertable=false,updatable=false)
	private Appointment appointment;

	public Integer getPatientBillId() {
		return patientBillId;
	}
	public void setPatientBillId(Integer patientBillId) {
		this.patientBillId = patientBillId;
	}
	public Integer getPatientBillAmount() {
		return patientBillAmount;
	}
	public void setPatientBillAmount(Integer patientBillAmount) {
		this.patientBillAmount = patientBillAmount;
	}
	public LocalDate getPatientbillCreatedOn() {
		return patientbillCreatedOn;
	}
	public void setPatientbillCreatedOn(LocalDate patientbillCreatedOn) {
		this.patientbillCreatedOn = patientbillCreatedOn;
	}
	public String getPatientBillIsActive() {
		return patientBillIsActive;
	}
	public void setPatientBillIsActive(String patientBillIsActive) {
		this.patientBillIsActive = patientBillIsActive;
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
	@Override
	public String toString() {
		return "PatientBill [patientBillId=" + patientBillId + ", patientBillAmount=" + patientBillAmount
				+ ", patientbillCreatedOn=" + patientbillCreatedOn + ", patientBillIsActive=" + patientBillIsActive
				+ ", appointmentId=" + appointmentId + ", appointment=" + appointment + "]";
	}
	public PatientBill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientBill(Integer patientBillId, Integer patientBillAmount, LocalDate patientbillCreatedOn,
			String patientBillIsActive, Integer appointmentId, Appointment appointment) {
		super();
		this.patientBillId = patientBillId;
		this.patientBillAmount = patientBillAmount;
		this.patientbillCreatedOn = patientbillCreatedOn;
		this.patientBillIsActive = patientBillIsActive;
		this.appointmentId = appointmentId;
		this.appointment = appointment;
	}
	
	



}