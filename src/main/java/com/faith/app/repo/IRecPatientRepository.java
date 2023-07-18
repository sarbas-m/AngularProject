package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.faith.app.entity.Patient;

public interface IRecPatientRepository extends CrudRepository<Patient, Integer>{

	@Query("from Patient where patientIsActive='true'")
	public List<Patient> getListPatient();
	
	@Query("SELECT MAX(p.patientId) FROM Patient p")
	public int getPrimaryKey();
	
	@Query("SELECT p.registrationNumber FROM Patient p where p.patientId=?1")
	public String getRegistrationNumber(int patientId);
	
	
}
