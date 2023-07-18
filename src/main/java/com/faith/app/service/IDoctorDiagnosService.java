package com.faith.app.service;

import java.util.List;

import com.faith.app.entity.Diagnos;

public interface IDoctorDiagnosService {
	
	public List<Diagnos> getDiagnosHistory(int patientId);
	
	
	public void addDiagnos(Diagnos diagnos);
	
	public List<Diagnos> getTodaysDiagnos(int appointmentId,int userId);
	
	
	public void deleteDiagnos(int diagnosId);

}
