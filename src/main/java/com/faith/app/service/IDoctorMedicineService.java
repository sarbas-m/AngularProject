package com.faith.app.service;

import java.util.List;

import com.faith.app.entity.MedicinePrescription;

public interface IDoctorMedicineService {
	
	public List<MedicinePrescription> getMedicineHistory(int patientId);
	
	public void addMedicine(MedicinePrescription medicinePrescription);
	
	public List<MedicinePrescription> getTodaysMedicine(int appointmentId,int userId);
	
	public void deleteMedicine(int medicinePrescriptionId);

}
