package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.faith.app.entity.TestPrescription;

public interface IDoctorTestRepository extends CrudRepository<TestPrescription,Integer>{
	
	@Query("from TestPrescription where appointment.patientId=?1")
	public List<TestPrescription> getTestHistory(int patientId);
	
	@Query("from TestPrescription where appointmentId=?1 and appointment.doctor.userId=?2")
	public List<TestPrescription> getTodaysTest(int appointmentId,int userId);

}

