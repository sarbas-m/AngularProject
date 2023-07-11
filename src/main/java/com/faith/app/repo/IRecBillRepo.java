package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.faith.app.entity.Appointment;
import com.faith.app.entity.PatientBill;

public interface IRecBillRepo extends CrudRepository<PatientBill, Integer>{

	
	
	@Query("from PatientBill where appointmentId=?1")
	public List<PatientBill> gettingTheBillByApId(int appointmentId);
	

	//@Query("select max(p.testReportId) from TestReport p")
	//public int getMaxBillId(); 
	
	@Query("from Appointment a where a.patientId=?1")
	public List<Appointment> listAppointmentsByPid(int patientId);


}
