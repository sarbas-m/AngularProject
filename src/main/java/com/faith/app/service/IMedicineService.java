package com.faith.app.service;

import java.util.List;

import com.faith.app.entity.Medicine;



public interface IMedicineService {
	
	
	//list
		public List<Medicine> getMedicineList();
		
		//Insert
		public Medicine saveMedicine(Medicine medicine);
		
		//update by id
		public Medicine getMedicine(int medicineId);
		
		//Delete
		public void deleteMedicine(Medicine medicine);
		
		//find by employee name
		public List<Medicine> getMedicineByName(String medicineName);
		
		public String getMedicineNumber(int medicineId);
		
		
}
