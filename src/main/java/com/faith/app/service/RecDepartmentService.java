package com.faith.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.entity.Department;
import com.faith.app.repo.IRecDepartmentRepo;

@Service
public class RecDepartmentService implements IRecDepartmentService{
	
	@Autowired
	private IRecDepartmentRepo recdepartmentrepo;

	@Override
	public List<Department> getAllDepartmentList() {
		// TODO Auto-generated method stub
		return (List<Department>) recdepartmentrepo.findAll();
	}

	@Override
	public Department getDepartmentById(int dId) {
		// TODO Auto-generated method stub
		return recdepartmentrepo.findById(dId).orElseThrow(() -> new RuntimeException("department not found"+dId));
	}
	
	

}
