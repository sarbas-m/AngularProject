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

import com.faith.app.entity.TestPrescription;
import com.faith.app.service.IDoctorTestService;

@CrossOrigin    
@RestController  
@RequestMapping("/api")
public class DoctorTestController {
	
	@Autowired
	private IDoctorTestService testService;
	
	@GetMapping("doctorTest"
			+ "/{patientId}")
	public List<TestPrescription> getTestHistory(@PathVariable int patientId){
		
		return testService.getTestHistory(patientId);
		
	}
	@GetMapping("doctorTestToday"
			+ "/{appointmentId}/{userId}")
	public List<TestPrescription> getTodaysTestHistory(@PathVariable int appointmentId,@PathVariable int userId){
		
		return testService.getTodaysTest(appointmentId,userId);
		
	}
	@PostMapping("doctorTest")
	public void addTest(@RequestBody TestPrescription testPrescription) {
		
		testService.addTest(testPrescription);
	}
	@DeleteMapping("doctorTest/{testPrescriptionId}")
	public void deleteTest(@PathVariable int testPrescriptionId) {
		
		testService.deleteTest(testPrescriptionId);
	}

}
