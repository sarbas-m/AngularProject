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

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    private String patientEmail;
    
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



	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", registrationNumber=" + registrationNumber + ", patientName="
				+ patientName + ", patientAge=" + patientAge + ", patientGender=" + patientGender
				+ ", patientPhoneNumber=" + patientPhoneNumber + ", patientAddress=" + patientAddress
				+ ", patientBloodGroup=" + patientBloodGroup + ", patientCreatedOn=" + patientCreatedOn
				+ ", patientEmail=" + patientEmail + ", patientIsActive=" + patientIsActive + ", validityDate="
				+ validityDate + "]";
	}




	


}