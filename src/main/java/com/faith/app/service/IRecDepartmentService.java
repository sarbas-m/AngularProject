package com.faith.app.service;

import java.util.List;

import com.faith.app.entity.Department;

public interface IRecDepartmentService {
	
	public List<Department> getAllDepartmentList();
	
	public Department getDepartmentById(int dId);

}
