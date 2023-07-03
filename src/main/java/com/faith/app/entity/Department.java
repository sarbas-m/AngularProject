package com.faith.app.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer departmentId;
	private Integer departmentName;
	
	
	@OneToMany(mappedBy="department")
	private List<Doctor> doctor;
	
	@OneToMany(mappedBy="department")
	private List<Appointment> appointment;

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(Integer departmentName) {
		this.departmentName = departmentName;
	}

	public List<Doctor> getDoctor() {
		return doctor;
	}

	public void setDoctor(List<Doctor> doctor) {
		this.doctor = doctor;
	}

	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

	public Department(Integer departmentId, Integer departmentName, List<Doctor> doctor,
			List<Appointment> appointment) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.doctor = doctor;
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", doctor=" + doctor
				+ ", appointment=" + appointment + "]";
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}





	
	

}
