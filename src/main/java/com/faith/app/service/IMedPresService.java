package com.faith.app.service;

import java.util.List;

import com.faith.app.entity.MedicinePrescription;


public interface IMedPresService {

	//list
			public List<MedicinePrescription> getMedPres();
			
			public List<MedicinePrescription> getPresHistory(int patientId);
			
			public void disableMedPrescription(int appointmentId);
			
			public List<MedicinePrescription> getMedPrescription();
			
			
			
}
