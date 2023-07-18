package com.faith.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.entity.Diagnos;
import com.faith.app.repo.IDoctorDiagnosRepository;

@Service
public class DoctorDiagnosServiceImple implements IDoctorDiagnosService {

	@Autowired
	private IDoctorDiagnosRepository diagnosRepo;
	
	@Override
	public List<Diagnos> getDiagnosHistory(int patientId) {
		// TODO Auto-generated method stub
		return diagnosRepo.getDiagnosHistory(patientId);
	}

	@Override
	public void addDiagnos(Diagnos diagnos) {
		
		diagnosRepo.save(diagnos);
		
	}

	@Override
	public List<Diagnos> getTodaysDiagnos(int appointmentId,int userId) {
		// TODO Auto-generated method stub
		return diagnosRepo.getTodaysDiagnos(appointmentId,userId);
	}

	@Override
	public void deleteDiagnos(int diagnosId) {
		diagnosRepo.deleteById(diagnosId);
		
	}

}
