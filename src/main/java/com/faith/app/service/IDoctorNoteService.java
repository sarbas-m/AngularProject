package com.faith.app.service;

import java.util.List;

import com.faith.app.entity.DoctorNote;

public interface IDoctorNoteService {
	
	public List<DoctorNote> getDoctorNoteHis(int patientId);
	
	
	public void addDoctorNote(DoctorNote doctorNote);
	
	public List<DoctorNote> getTodaysNote(int appointmentId,int userId);
	
	public void deleteDoctorNote(int doctorNoteId);


}
