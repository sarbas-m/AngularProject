package com.faith.app.entity;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appointmentId;
	private Integer tokenNo;
	private String appointmentIsActive;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime appCreatedOn;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime appValidityDate;
	

	@PrePersist
	@PreUpdate
	private void persist() {
		if (appointmentIsActive == null) {
			appointmentIsActive = "true";
		}

	}


	private Integer patientId;
	@ManyToOne
	@JoinColumn(name = "patientId",insertable=false,updatable=false)
	private Patient patient;
	
	private Integer departmentId;

	private Integer doctorId;
	@ManyToOne
	@JoinColumn(name = "doctorId",insertable=false,updatable=false)
	private Doctor doctor;
    


	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Integer getTokenNo() {
		return tokenNo;
	}

	public void setTokenNo(Integer tokenNo) {
		this.tokenNo = tokenNo;
	}

	public String getAppointmentIsActive() {
		return appointmentIsActive;
	}

	public void setAppointmentIsActive(String appointmentIsActive) {
		this.appointmentIsActive = appointmentIsActive;
	}

	public LocalDateTime getAppCreatedOn() {
		return appCreatedOn;
	}

	public void setAppCreatedOn(LocalDateTime appCreatedOn) {
		this.appCreatedOn = appCreatedOn;
	}

	public LocalDateTime getAppValidityDate() {
		return appValidityDate;
	}

	public void setAppValidityDate(LocalDateTime appValidityDate) {
		this.appValidityDate = appValidityDate;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	


	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}


	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}


	

}