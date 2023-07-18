package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.faith.app.entity.MedicinePrescription;

public interface IDoctorMedicineRepository extends CrudRepository<MedicinePrescription,Integer> {
   
	@Query("from MedicinePrescription where appointment.patientId=?1")
	public List<MedicinePrescription> getMedicineHistory(int patientId);
	
	@Query("from MedicinePrescription where appointmentId=?1 and appointment.doctor.userId=?2")
	public List<MedicinePrescription> getTodaysMedicine(int appointmentId,int userId);
}
