package com.faith.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.entity.TestReport;
import com.faith.app.service.IDoctorReportService;

@CrossOrigin    
@RestController  
@RequestMapping("/api")
public class DoctorReportController {
	
	@Autowired
	private IDoctorReportService reportService;
	
	@GetMapping("doctorReport/{patientId}")
	public List<TestReport> getReportHist(@PathVariable int patientId){
		
		return reportService.getTestReport(patientId);
		
	}


}
