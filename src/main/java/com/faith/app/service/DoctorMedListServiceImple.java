package com.faith.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.entity.Medicine;
import com.faith.app.repo.IDoctorMedListRepository;

@Service
public class DoctorMedListServiceImple implements IDoctorMedListService {

	@Autowired
	private IDoctorMedListRepository medListRepo;
	
	@Override
	public List<Medicine> getMedList() {
		// TODO Auto-generated method stub
		return  medListRepo.getMedList();
	}

}
