package com.faith.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.entity.Medicine;
import com.faith.app.service.IDoctorMedListService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class DoctorMedListController {
	
	@Autowired 
	private IDoctorMedListService medListService;
	
	@GetMapping("doctorMedList")
	public List<Medicine> getMedList(){
		
		return medListService.getMedList();
		
	}

}
