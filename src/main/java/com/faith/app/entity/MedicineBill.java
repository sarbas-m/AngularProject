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
public class MedicineBill {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer medicineBillId;
	private Double medicineBillAmount;
	private LocalDate medBillCreatedOn;
	private String medBillIsActive;
	private String medicineBillNo;
	@PrePersist
	@PreUpdate
	private void persist() {
		if(medBillIsActive==null)
			medBillIsActive="true";
		if(medBillCreatedOn==null) { //we set default value in case if the value is not set yet
			medBillCreatedOn=LocalDate.now();
		}
	}
	
	
	public String getMedicineBillNo() {
		return medicineBillNo;
	}


	public void setMedicineBillNo(String medicineBillNo) {
		this.medicineBillNo = medicineBillNo;
	}


	public void setMedicineBillId(Integer medicineBillId) {
		this.medicineBillId = medicineBillId;
	}


	public void setMedicineBillAmount(Double medicineBillAmount) {
		this.medicineBillAmount = medicineBillAmount;
	}


	@ManyToOne
	@JoinColumn(name="appointmentId",insertable=false,updatable=false)
	private Appointment appointment;



	public Integer getMedicineBillId() {
		return medicineBillId;
	}


	public double getMedicineBillAmount() {
		return medicineBillAmount;
	}


	public void setMedicineBillAmount(double medicineBillAmount) {
		this.medicineBillAmount = medicineBillAmount;
	}


	public LocalDate getMedBillCreatedOn() {
		return medBillCreatedOn;
	}


	public void setMedBillCreatedOn(LocalDate medBillCreatedOn) {
		this.medBillCreatedOn = medBillCreatedOn;
	}


	public String getMedBillIsActive() {
		return medBillIsActive;
	}


	public void setMedBillIsActive(String medBillIsActive) {
		this.medBillIsActive = medBillIsActive;
	}


	public Appointment getAppointment() {
		return appointment;
	}


	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}


	public MedicineBill() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "MedicineBill [medicineBillId=" + medicineBillId + ", medicineBillAmount=" + medicineBillAmount
				+ ", medBillCreatedOn=" + medBillCreatedOn + ", medBillIsActive=" + medBillIsActive + ", appointment="
				+ appointment + "]";
	}


	public MedicineBill(int medicineBillId, double medicineBillAmount, LocalDate medBillCreatedOn,
			String medBillIsActive, Appointment appointment) {
		super();
		this.medicineBillId = medicineBillId;
		this.medicineBillAmount = medicineBillAmount;
		this.medBillCreatedOn = medBillCreatedOn;
		this.medBillIsActive = medBillIsActive;
		this.appointment = appointment;
	}
	




}
