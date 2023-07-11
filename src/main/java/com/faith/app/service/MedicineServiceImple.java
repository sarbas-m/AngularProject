package com.faith.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.entity.Medicine;
import com.faith.app.repo.IMedicineRepository;



@Service
public class MedicineServiceImple implements IMedicineService {
	
	
	@Autowired
	private IMedicineRepository medrepo;

	@Override
	public List<Medicine> getMedicineList() {
		// TODO Auto-generated method stub
		return medrepo.getMedicineList();
	}

	@Override
	public Medicine saveMedicine(Medicine medicine) {
		
		if(medicine.getMedicineId()==0) {
			return medrepo.save(medicine);
			
		}else {
			String medicineNumber=medrepo.getMedicineNumber(medicine.getMedicineId());
			medicine.setMedicineNumber(medicineNumber);
			return medrepo.save(medicine);
				
			}
			
		
	
	}
	@Override
	public Medicine getMedicine(int medicineId) {
		// TODO Auto-generated method stub
		return medrepo.findById(medicineId).orElseThrow(() -> new RuntimeException("Medicine not found for id" + medicineId));
	}

	

	@Override
	public List<Medicine> getMedicineByName(String medicineName) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void deleteMedicine(Medicine medicine) {
		medicine.setMedicineIsActive("false");
		medrepo.save(medicine);
		
	}

	@Override
	public String getMedicineNumber(int medicineId) {
		// TODO Auto-generated method stub
		return medrepo.getMedicineNumber(medicineId);
	}

	

}
