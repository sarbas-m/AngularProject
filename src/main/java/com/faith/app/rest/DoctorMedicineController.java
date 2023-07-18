package com.faith.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.entity.MedicinePrescription;
import com.faith.app.service.IDoctorMedicineService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class DoctorMedicineController {
	
	
	@Autowired
	private IDoctorMedicineService medicineService;
	
	@GetMapping("doctorMedicine/{patientId}")
	public List<MedicinePrescription> getMedicinePresHistory(@PathVariable int patientId){
		
		return medicineService.getMedicineHistory(patientId);
		
	}
	@GetMapping("doctorMedicineToday/{appointmentId}/{userId}")
	public List<MedicinePrescription> getMedicineTodayHistory(@PathVariable int appointmentId,@PathVariable int userId){
		
		return medicineService.getTodaysMedicine(appointmentId,userId);
		
	}
	
	@PostMapping("doctorMedicine")
	public void addMedicine(@RequestBody MedicinePrescription medicinePrescription) {
		
		medicineService.addMedicine(medicinePrescription);
	}
	@DeleteMapping("doctorMedicine/{medicinePrescriptionId}")
	public void deleteMedicine(@PathVariable int medicinePrescriptionId) {
		medicineService.deleteMedicine(medicinePrescriptionId);
	}
	
	

}
