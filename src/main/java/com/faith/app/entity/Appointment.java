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
	@ManyToOne
	@JoinColumn(name = "departmentId",insertable=false,updatable=false)
	private Department department;
    
	private Integer doctorId;
	@ManyToOne
	@JoinColumn(name = "doctorId",insertable=false,updatable=false)
	private Doctor doctor;
    
	@JsonBackReference
	@OneToMany(mappedBy = "appointment")
	private List<DoctorNote> doctorNote;

	@JsonBackReference
	@OneToMany(mappedBy = "appointment")
	private List<Diagnos> diagnos;
	@JsonBackReference
	@OneToMany(mappedBy = "appointment")
	private List<TestPrescription> testPrescription;
	@JsonBackReference
	@OneToMany(mappedBy = "appointment")
	private List<MedicinePrescription> medicinePrescription;
	@JsonBackReference
	@OneToMany(mappedBy = "appointment")
	private List<PatientBill> patientBill;
	@JsonBackReference
	@OneToMany(mappedBy = "appointment")
	private List<MedicineBill> medicineBill;
	@JsonBackReference
	@OneToMany(mappedBy = "appointment")
	private List<TestBill> testBill;


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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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

	public List<DoctorNote> getDoctorNote() {
		return doctorNote;
	}

	public void setDoctorNote(List<DoctorNote> doctorNote) {
		this.doctorNote = doctorNote;
	}

	public List<Diagnos> getDiagnos() {
		return diagnos;
	}

	public void setDiagnos(List<Diagnos> diagnos) {
		this.diagnos = diagnos;
	}

	public List<TestPrescription> getTestPrescription() {
		return testPrescription;
	}

	public void setTestPrescription(List<TestPrescription> testPrescription) {
		this.testPrescription = testPrescription;
	}

	public List<MedicinePrescription> getMedicinePrescription() {
		return medicinePrescription;
	}

	public void setMedicinePrescription(List<MedicinePrescription> medicinePrescription) {
		this.medicinePrescription = medicinePrescription;
	}

	public List<PatientBill> getPatientBill() {
		return patientBill;
	}

	public void setPatientBill(List<PatientBill> patientBill) {
		this.patientBill = patientBill;
	}

	public List<MedicineBill> getMedicineBill() {
		return medicineBill;
	}

	public void setMedicineBill(List<MedicineBill> medicineBill) {
		this.medicineBill = medicineBill;
	}

	public List<TestBill> getTestBill() {
		return testBill;
	}

	public void setTestBill(List<TestBill> testBill) {
		this.testBill = testBill;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", tokenNo=" + tokenNo + ", appointmentIsActive="
				+ appointmentIsActive + ", appCreatedOn=" + appCreatedOn + ", appValidityDate=" + appValidityDate
				+ ", patientId=" + patientId + ", patient=" + patient + ", departmentId=" + departmentId
				+ ", department=" + department + ", doctorId=" + doctorId + ", doctor=" + doctor + ", doctorNote="
				+ doctorNote + ", diagnos=" + diagnos + ", testPrescription=" + testPrescription
				+ ", medicinePrescription=" + medicinePrescription + ", patientBill=" + patientBill + ", medicineBill="
				+ medicineBill + ", testBill=" + testBill + "]";
	}

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(Integer appointmentId, Integer tokenNo, String appointmentIsActive, LocalDateTime appCreatedOn,
			LocalDateTime appValidityDate, Integer patientId, Patient patient, Integer departmentId,
			Department department, Integer doctorId, Doctor doctor, List<DoctorNote> doctorNote, List<Diagnos> diagnos,
			List<TestPrescription> testPrescription, List<MedicinePrescription> medicinePrescription,
			List<PatientBill> patientBill, List<MedicineBill> medicineBill, List<TestBill> testBill) {
		super();
		this.appointmentId = appointmentId;
		this.tokenNo = tokenNo;
		this.appointmentIsActive = appointmentIsActive;
		this.appCreatedOn = appCreatedOn;
		this.appValidityDate = appValidityDate;
		this.patientId = patientId;
		this.patient = patient;
		this.departmentId = departmentId;
		this.department = department;
		this.doctorId = doctorId;
		this.doctor = doctor;
		this.doctorNote = doctorNote;
		this.diagnos = diagnos;
		this.testPrescription = testPrescription;
		this.medicinePrescription = medicinePrescription;
		this.patientBill = patientBill;
		this.medicineBill = medicineBill;
		this.testBill = testBill;
	}


}