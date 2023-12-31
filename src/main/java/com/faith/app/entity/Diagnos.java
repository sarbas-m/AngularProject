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

@Entity
public class Diagnos {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer diagnosId;
	private String diagnos;
	private LocalDate diagnosCreatedOn;
	
	
	@PrePersist
	@PreUpdate
	public void prePersist() {
		if(diagnosCreatedOn==null) { //we set default value in case if the value is not set yet
			diagnosCreatedOn=LocalDate.now();
		}
		
		}
	private Integer appointmentId;
	@ManyToOne
	@JoinColumn(name="appointmentId",insertable=false,updatable=false)
	private Appointment appointment;

	public Integer getDiagnosId() {
		return diagnosId;
	}

	public void setDiagnosId(Integer diagnosId) {
		this.diagnosId = diagnosId;
	}

	public String getDiagnos() {
		return diagnos;
	}

	public void setDiagnos(String diagnos) {
		this.diagnos = diagnos;
	}

	public LocalDate getDiagnosCreatedOn() {
		return diagnosCreatedOn;
	}

	public void setDiagnosCreatedOn(LocalDate diagnosCreatedOn) {
		this.diagnosCreatedOn = diagnosCreatedOn;
	}


	

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Diagnos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}



}
