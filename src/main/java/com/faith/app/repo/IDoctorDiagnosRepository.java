package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.faith.app.entity.Diagnos;

public interface IDoctorDiagnosRepository extends CrudRepository<Diagnos, Integer> {

	@Query("from Diagnos where appointment.patientId=?1")
	public List<Diagnos> getDiagnosHistory(int patientId);
	
	@Query("from Diagnos where appointmentId=?1 and appointment.doctor.userId=?2")
	public List<Diagnos> getTodaysDiagnos(int appointmentId,int userId);
	
}
