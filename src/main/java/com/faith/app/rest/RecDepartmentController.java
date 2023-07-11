package com.faith.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.entity.Department;
import com.faith.app.service.IRecDepartmentService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RecDepartmentController {
	
	@Autowired
	private IRecDepartmentService recdepartmentservice;
	
	@GetMapping("/departments")
	public List<Department> getDepartmentList(){
		return recdepartmentservice.getAllDepartmentList();
		
	}
	
	@GetMapping("/departments/{id}")
	public Department getDepartmentById(@PathVariable int id) {
		
		return recdepartmentservice.getDepartmentById(id);
		
	}

}
