package com.faith.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.entity.Appointment;
import com.faith.app.entity.Test;
import com.faith.app.repo.IDoctorAppointRepository;
import com.faith.app.repo.IDoctorTestListRepository;

@Service
public class DoctorTestListServiceImple implements IDoctorTestListService {
   
	@Autowired
	private IDoctorTestListRepository testListRepo;
	
	@Autowired
	private IDoctorAppointRepository doctorRepo;
	
	@Override
	public List<Test> getTestList() {
		// TODO Auto-generated method stub
		return testListRepo.getTestList();
	}



}
