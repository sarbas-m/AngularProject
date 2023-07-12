package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faith.app.entity.MedicinePrescription;


@Repository
public interface IMedPrescriptionRepository extends CrudRepository<MedicinePrescription, Integer>  {
	
	@Query("from MedicinePrescription where medPresIsActive='true' and appointmentId=?1")
	public List<MedicinePrescription> getPresHistory(int patientId);
	
	
	@Modifying
	@Query("update MedicinePrescription set medPresIsActive='false' where appointmentId=?1")
	public void disableMedPrescription(int appointmentId);
	
	@Query("from MedicinePrescription where medPresIsActive='true'")
	public List<MedicinePrescription> getMedPrescription();

	
}
