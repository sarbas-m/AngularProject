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
public class MedicinePrescription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer medicinePrescriptionId;
	private Integer days;
	private LocalDate medPresCreatedOn;
	private String medPresIsActive;

	@PrePersist
	@PreUpdate
	public void prepersist() {
		if (medPresIsActive == null)
			medPresIsActive = "true";
		if(medPresCreatedOn==null) { //we set default value in case if the value is not set yet
			medPresCreatedOn=LocalDate.now();
		}
	}
    private Integer appointmentId;
	@ManyToOne
	@JoinColumn(name = "appointmentId",insertable=false,updatable=false)
	private Appointment appointment;

	private Integer dosageId;
	@ManyToOne
	@JoinColumn(name = "dosageId",insertable=false,updatable=false)
	private Dosage dosage;
    
	private Integer medicineId;
	@ManyToOne
	@JoinColumn(name = "medicineId",insertable=false,updatable=false)
	private Medicine medicine;

	public MedicinePrescription(int medicinePrescriptionId, int days, LocalDate medPresCreatedOn,
			String medPresIsActive, Integer appointmentId, Appointment appointment, Integer dosageId, Dosage dosage,
			Integer medicineId, Medicine medicine) {
		super();
		this.medicinePrescriptionId = medicinePrescriptionId;
		this.days = days;
		this.medPresCreatedOn = medPresCreatedOn;
		this.medPresIsActive = medPresIsActive;
		this.appointmentId = appointmentId;
		this.appointment = appointment;
		this.dosageId = dosageId;
		this.dosage = dosage;
		this.medicineId = medicineId;
		this.medicine = medicine;
	}

	public Integer getMedicinePrescriptionId() {
		return medicinePrescriptionId;
	}

	public void setMedicinePrescriptionId(Integer medicinePrescriptionId) {
		this.medicinePrescriptionId = medicinePrescriptionId;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public LocalDate getMedPresCreatedOn() {
		return medPresCreatedOn;
	}

	public void setMedPresCreatedOn(LocalDate medPresCreatedOn) {
		this.medPresCreatedOn = medPresCreatedOn;
	}

	public String getMedPresIsActive() {
		return medPresIsActive;
	}

	public void setMedPresIsActive(String medPresIsActive) {
		this.medPresIsActive = medPresIsActive;
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

	public Integer getDosageId() {
		return dosageId;
	}

	public void setDosageId(Integer dosageId) {
		this.dosageId = dosageId;
	}

	public Dosage getDosage() {
		return dosage;
	}

	public void setDosage(Dosage dosage) {
		this.dosage = dosage;
	}

	public Integer getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	@Override
	public String toString() {
		return "MedicinePrescription [medicinePrescriptionId=" + medicinePrescriptionId + ", days=" + days
				+ ", medPresCreatedOn=" + medPresCreatedOn + ", medPresIsActive=" + medPresIsActive + ", appointmentId="
				+ appointmentId + ", appointment=" + appointment + ", dosageId=" + dosageId + ", dosage=" + dosage
				+ ", medicineId=" + medicineId + ", medicine=" + medicine + "]";
	}

	
}