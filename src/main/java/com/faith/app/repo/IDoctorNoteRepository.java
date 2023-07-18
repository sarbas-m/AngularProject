package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.faith.app.entity.DoctorNote;

public interface IDoctorNoteRepository extends CrudRepository<DoctorNote,Integer> {
	
	@Query("from DoctorNote where appointment.patientId=?1")
	public List<DoctorNote> getDoctorNoteHis(int patientId);
	
	@Query("from DoctorNote where appointmentId=?1 and appointment.doctor.userId=?2")
	public List<DoctorNote> getTodaysNote(int appointmentId,int userId);

}
