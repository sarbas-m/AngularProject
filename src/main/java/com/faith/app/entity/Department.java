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





	
	

}
