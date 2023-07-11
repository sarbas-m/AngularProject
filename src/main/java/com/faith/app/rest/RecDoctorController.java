package com.faith.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.entity.Doctor;
import com.faith.app.service.IRecDoctorsService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RecDoctorController {
	
	@Autowired
	private IRecDoctorsService recDoctorService;
	
	@GetMapping("/doctors")
	public List<Doctor> getAllDoctorsList(){
		
		return recDoctorService.getDoctorsList();
		
		}
	@GetMapping("/doctors/{docId}")
	public Doctor getDoctorById(@PathVariable int docId) {
		
		return recDoctorService.getDoctorById(docId);
		
	}

}
