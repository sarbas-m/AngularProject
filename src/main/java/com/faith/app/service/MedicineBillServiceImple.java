package com.faith.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.entity.MedicineBill;
import com.faith.app.repo.IMedicineBillRepository;

@Service
public class MedicineBillServiceImple implements IMedicineBill {
	
	@Autowired
	private IMedicineBillRepository medicineBillRepo;

	@Override
	public void saveMedicineBill(MedicineBill medicineBill) {
		medicineBillRepo.save(medicineBill);
		
	}

}
