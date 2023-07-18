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

import com.faith.app.entity.Diagnos;
import com.faith.app.service.IDoctorDiagnosService;

@CrossOrigin    
@RestController  
@RequestMapping("/api")
public class DoctorDiagnosController {
	
	@Autowired
	private IDoctorDiagnosService diagnosService;
	
	@GetMapping("doctorDiagnos/{patientId}")
	public List<Diagnos> getDiagnosHistory(@PathVariable int patientId) {
		
		return diagnosService.getDiagnosHistory(patientId);
		
	}
	@PostMapping("doctorDiagnos")
	public void addDiagnos(@RequestBody Diagnos diagnos) {
		
		diagnosService.addDiagnos(diagnos);
		
	}
	@GetMapping("doctorDiagnosToday/{appointmentId}/{userId}")
	public List<Diagnos> getTodayDiagnos(@PathVariable int appointmentId,@PathVariable int userId) {
		System.out.println("sfs");
		return diagnosService.getTodaysDiagnos(appointmentId,userId);
		
	}
	
	@DeleteMapping("doctorDiagnos/{diagnosId}")
	public void deleteDiagnos(@PathVariable int diagnosId) {
		diagnosService.deleteDiagnos(diagnosId);
	}

}
