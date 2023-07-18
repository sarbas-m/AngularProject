package com.faith.app.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.entity.Test;
import com.faith.app.service.IDoctorAppointService;
import com.faith.app.service.IDoctorTestListService;

@CrossOrigin    
@RestController  
@RequestMapping("/api")
public class DoctorTestListController {
	
	@Autowired
	private IDoctorTestListService testListService;
	
	@Autowired
	private IDoctorAppointService doctorService;
		
	@GetMapping("doctorTestList")
	public List<Test> getTest(){
		
		return testListService.getTestList();		
	}
	
	

}
