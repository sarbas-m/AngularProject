package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.faith.app.entity.Appointment;

public interface IRecAppointmentRepo extends CrudRepository<Appointment, Integer>{
	
	@Query("from Appointment where appointmentIsActive='true'")
	public List<Appointment> listOfAppointments();
	
	@Query("from Appointment where patient.patientId=?1")
	public List<Appointment> listAppointByPatient(int patientId);
	
	@Query("SELECT MAX(a.appointmentId) FROM Appointment a")
	public int getMaxAppointId();
	
	@Query("from Appointment where appointmentId=?1")
	public Appointment gettingApDetails(int appId);
	
	@Query("SELECT a.tokenNo from Appointment a where a.appointmentId=?1")
	public int gettingTokenNum(int apoId);


}
