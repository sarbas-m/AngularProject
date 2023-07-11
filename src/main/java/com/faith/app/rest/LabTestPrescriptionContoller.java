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
import com.faith.app.service.ITestPrescriptionService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LabTestPrescriptionContoller {
	
	@Autowired
	private ITestPrescriptionService testpresService;
	
	@GetMapping("testpres")
	public List<TestPrescription>getAllTestPrescription(){
		return testpresService.getTestPrescription();
		
	}
	
	@PostMapping("testpres")
	public void addTestPrescription(@RequestBody TestPrescription pres) {
		testpresService.addTestPrescription(pres);
	}
	@GetMapping("testpres/{appointmentId}")
	public List<TestPrescription>getTestPrescriptionHistory(@PathVariable int appointmentId){
		return testpresService.getTestPrescriptionHistory(appointmentId);
	}
	
	@DeleteMapping("testpres/{appointmentId}")
	public void disableTestPrescription(@PathVariable int appointmentId) {
		System.out.println("dis");
		testpresService.disableTestPrescription(appointmentId);
		
	}

	

}
