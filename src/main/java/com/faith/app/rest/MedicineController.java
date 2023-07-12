package com.faith.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.entity.Medicine;
import com.faith.app.service.IMedicineService;



@CrossOrigin  //inorder to avoid port number conflict
@RestController  //@Controller +@Configuration
@RequestMapping("/api")
public class MedicineController {
	
	@Autowired
	private IMedicineService medicineService;
	
	
	@GetMapping("/medicines")
	public List<Medicine>getMedicine(){
		return medicineService.getMedicineList();
	}
	
	
	@GetMapping("/medicines/{medicineId}")
	public Medicine getMedicine(@PathVariable int medicineId) {
		return medicineService.getMedicine(medicineId);
	}
	
	
	  
	 
	 @PostMapping("/medicines") 
	 public void addMedicine(@RequestBody Medicine medicine) { 
		 medicineService.saveMedicine(medicine); 
		 }
	

	
	
	@PutMapping("/medicines")
	public void updateMedicine(@RequestBody Medicine medicine) {
		medicineService.saveMedicine(medicine);
}

	
	@DeleteMapping("/medicines/{medicineId}")
	public void deleteMedicine(@PathVariable int medicineId) {
		System.out.println(medicineId);
		medicineService.deleteMedicine(medicineService.getMedicine(medicineId));
		
	}
	 
	
	@GetMapping("/medicines/search/{name}")
	public List<Medicine>getAllMedicineByName(@PathVariable String name){
		return medicineService.getMedicineByName(name);
	}
	
	
	
	
}
