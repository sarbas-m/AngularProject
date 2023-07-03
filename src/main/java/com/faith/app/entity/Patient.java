package com.faith.app.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer patientId;
	private String registrationNumber;
	private String patientName;
	private Integer patientAge;
	private String patientGender;
	private String patientPhoneNumber;
	private String patientAddress;
	private String patientBloodGroup;
    private LocalDate patientCreatedOn;
    
    @PrePersist
	@PreUpdate
	public void prePersist() {
		if(patientIsActive==null) { //we set default value in case if the value is not set yet
			patientIsActive="true";
		}
		if(patientCreatedOn==null) {
			patientCreatedOn=LocalDate.now();
		}
		if(validityDate==null) {
	         validityDate = LocalDate.now().plusMonths(6);
		}
	}
	private String patientIsActive;
	private LocalDate validityDate;
	
	@OneToMany(mappedBy="patient")
	private List<Appointment> appointment;

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Integer getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(Integer patientAge) {
		this.patientAge = patientAge;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	public String getPatientPhoneNumber() {
		return patientPhoneNumber;
	}

	public void setPatientPhoneNumber(String patientPhoneNumber) {
		this.patientPhoneNumber = patientPhoneNumber;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public String getPatientBloodGroup() {
		return patientBloodGroup;
	}

	public void setPatientBloodGroup(String patientBloodGroup) {
		this.patientBloodGroup = patientBloodGroup;
	}

	public LocalDate getPatientCreatedOn() {
		return patientCreatedOn;
	}

	public void setPatientCreatedOn(LocalDate patientCreatedOn) {
		this.patientCreatedOn = patientCreatedOn;
	}

	public String getPatientIsActive() {
		return patientIsActive;
	}

	public void setPatientIsActive(String patientIsActive) {
		this.patientIsActive = patientIsActive;
	}

	public LocalDate getValidityDate() {
		return validityDate;
	}

	public void setValidityDate(LocalDate validityDate) {
		this.validityDate = validityDate;
	}

	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", registrationNumber=" + registrationNumber + ", patientName="
				+ patientName + ", patientAge=" + patientAge + ", patientGender=" + patientGender
				+ ", patientPhoneNumber=" + patientPhoneNumber + ", patientAddress=" + patientAddress
				+ ", patientBloodGroup=" + patientBloodGroup + ", patientCreatedOn=" + patientCreatedOn
				+ ", patientIsActive=" + patientIsActive + ", validityDate=" + validityDate + ", appointment="
				+ appointment + "]";
	}

	public Patient(Integer patientId, String registrationNumber, String patientName, Integer patientAge,
			String patientGender, String patientPhoneNumber, String patientAddress, String patientBloodGroup,
			LocalDate patientCreatedOn, String patientIsActive, LocalDate validityDate, List<Appointment> appointment) {
		super();
		this.patientId = patientId;
		this.registrationNumber = registrationNumber;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientGender = patientGender;
		this.patientPhoneNumber = patientPhoneNumber;
		this.patientAddress = patientAddress;
		this.patientBloodGroup = patientBloodGroup;
		this.patientCreatedOn = patientCreatedOn;
		this.patientIsActive = patientIsActive;
		this.validityDate = validityDate;
		this.appointment = appointment;
	}
	


}