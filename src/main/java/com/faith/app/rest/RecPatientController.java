package com.faith.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.entity.Patient;
import com.faith.app.service.IRecPatientService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RecPatientController {
	
	@Autowired
	private IRecPatientService patientservice;
	
	@GetMapping("/patients")
	public List<Patient> getPatientList(){
		
		return patientservice.getListPatient();
		
	}
	
	@PostMapping("/patients")
	public void addPatient(@RequestBody Patient patient) {
		
		patientservice.addThePatient(patient);
		
	}
	
	@PutMapping("/patients")
	public void editPatient(@RequestBody Patient patientes) {
		
		patientservice.addThePatient(patientes);
	}

	@GetMapping("/patients/{id}")
	public Patient getPatientById(@PathVariable int id) {
		
		return patientservice.getPatientByTheId(id);
		
	}
	@DeleteMapping("/patients/{pid}")
	public void disAble(@PathVariable int pid) {
		
		patientservice.disAblePatient(patientservice.getPatientByTheId(pid));
		
	}
	

}
