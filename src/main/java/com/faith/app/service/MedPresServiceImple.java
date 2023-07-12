package com.faith.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.entity.MedicinePrescription;
import com.faith.app.repo.IMedPrescriptionRepository;

@Service
public class MedPresServiceImple implements IMedPresService {
	
	@Autowired
	private IMedPrescriptionRepository medpresrepo;


	
	public List<MedicinePrescription> getMedPres() {
		// TODO Auto-generated method stub
		return (List<MedicinePrescription>) medpresrepo.findAll();
	}



	@Override
	public List<MedicinePrescription> getPresHistory(int appointmentId) {
		// TODO Auto-generated method stub
		return (List<MedicinePrescription>) medpresrepo.getPresHistory(appointmentId);
	}


	@Override
	@Transactional
	public void disableMedPrescription(int appointmentId) {
		
		medpresrepo.disableMedPrescription(appointmentId);
		
		
	}



	@Override
	public List<MedicinePrescription> getMedPrescription() {
		// TODO Auto-generated method stub
		return medpresrepo.getMedPrescription();
	}





}
