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
public class DoctorNote {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer doctorNoteId;
	private String note;
	private LocalDate doctorNoteCreatedOn;
	
	@PrePersist
	@PreUpdate
	public void prePersist() {
		if(doctorNoteCreatedOn==null) { //we set default value in case if the value is not set yet
			doctorNoteCreatedOn=LocalDate.now();
		}
		
		}
	
	private Integer appointmentId;
	@ManyToOne
	@JoinColumn(name="appointmentId",insertable=false,updatable=false)
	private Appointment appointment;



	public Integer getDoctorNoteId() {
		return doctorNoteId;
	}

	public void setDoctorNoteId(Integer doctorNoteId) {
		this.doctorNoteId = doctorNoteId;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public LocalDate getDoctorNoteCreatedOn() {
		return doctorNoteCreatedOn;
	}

	public void setDoctorNoteCreatedOn(LocalDate doctorNoteCreatedOn) {
		this.doctorNoteCreatedOn = doctorNoteCreatedOn;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}



	public DoctorNote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DoctorNote(Appointment appointment) {
		super();
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "DoctorNote [doctorNoteId=" + doctorNoteId + ", note=" + note + ", doctorNoteCreatedOn="
				+ doctorNoteCreatedOn + ", appointmentId=" + appointmentId + ", appointment=" + appointment + "]";
	}

}
