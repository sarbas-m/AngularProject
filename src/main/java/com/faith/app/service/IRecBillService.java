package com.faith.app.service;

import java.util.List;
import java.util.Optional;

import com.faith.app.entity.Appointment;
import com.faith.app.entity.PatientBill;

public interface IRecBillService {
	
	public PatientBill getTheBillById(int apppid);
	
	public PatientBill addBill(PatientBill bills);

	
	public List<PatientBill> gettingTheBillByApId(int appoinId);
	
	//public int getMaxBillId();
	
	public Optional<PatientBill> getPatientBillbyBillId(int patientBill);
	
	public List<Appointment> listAppointmentsByPid(int patientId);
}
