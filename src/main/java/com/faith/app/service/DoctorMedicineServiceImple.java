package com.faith.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.entity.MedicinePrescription;
import com.faith.app.repo.IDoctorMedicineRepository;

@Service
public class DoctorMedicineServiceImple implements IDoctorMedicineService {

	@Autowired
	private IDoctorMedicineRepository medicineRepo;
	
	@Override
	public List<MedicinePrescription> getMedicineHistory(int patientId) {
		// TODO Auto-generated method stub
		return medicineRepo.getMedicineHistory(patientId);
	}

	@Override
	public void addMedicine(MedicinePrescription medicinePrescription) {
		medicineRepo.save(medicinePrescription);
		
	}

	@Override
	public List<MedicinePrescription> getTodaysMedicine(int appointmentId,int userId) {
		// TODO Auto-generated method stub
		return medicineRepo.getTodaysMedicine(appointmentId,userId);
	}

	@Override
	public void deleteMedicine(int medicinePrescriptionId) {
		
		medicineRepo.deleteById(medicinePrescriptionId);
		
	}

}
