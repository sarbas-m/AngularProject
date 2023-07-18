package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.faith.app.entity.Appointment;

public interface IDoctorAppointRepository extends CrudRepository<Appointment, Integer> {
	
	@Query("FROM Appointment\r\n" + 
			"WHERE doctor.user.userId = ?1\r\n" + 
			"    AND appointmentIsActive = 'true'\r\n" + 
			"    AND DATE_FORMAT(appCreatedOn, '%Y-%m-%d') = CURDATE()")
	public List<Appointment> getTodaysAppointmentList(int userId);
	
	@Query("from Appointment where tokenNo=?1 ")
	public List<Appointment> getPatientDat(int tokenNo);
	
	@Modifying
	@Query("update Appointment set appointmentIsActive='false' where appointmentId=?1 ")
	public void disableApp(int appointmentId);
	
	@Query("from Appointment where doctor.user.userId=?1 and appointmentIsActive='false'")
	public List<Appointment> getDisabledAppointmentList(int userId);
	
	
	
	

}
