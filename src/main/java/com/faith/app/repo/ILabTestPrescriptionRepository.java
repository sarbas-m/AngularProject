package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faith.app.entity.TestPrescription;

@Repository
public interface ILabTestPrescriptionRepository extends CrudRepository<TestPrescription,Integer>{
	
	@Query("from TestPrescription where appointmentId=?1")
	public List<TestPrescription>getTestPrescriptionHistory(Integer appointmentId);
	
	@Query("from TestPrescription where testPresIsActive='true'")
	public List<TestPrescription> getTestPrescription();
	
	@Modifying
	@Query("Update TestPrescription set testPresIsActive='false' where appointmentId=?1")
	public void disableTestPrescription(int appointmentId);

}
