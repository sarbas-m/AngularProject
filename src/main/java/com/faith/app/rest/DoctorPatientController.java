package com.faith.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.entity.Appointment;
import com.faith.app.service.IDoctorAppointService;

@CrossOrigin    
@RestController  
@RequestMapping("/api")
public class DoctorPatientController {
	
	@Autowired
	private IDoctorAppointService doctorService;
	
	
	@GetMapping("/doctorPatient/{tokenNo}")
	public List<Appointment> getPatientData(@PathVariable int tokenNo){
		return doctorService.getPatientDat(tokenNo);
		
	}

}
