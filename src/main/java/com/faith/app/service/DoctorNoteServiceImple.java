package com.faith.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.entity.DoctorNote;
import com.faith.app.repo.IDoctorNoteRepository;

@Service
public class DoctorNoteServiceImple implements IDoctorNoteService {
	
	@Autowired
	private IDoctorNoteRepository noteRepo;

	@Override
	public List<DoctorNote> getDoctorNoteHis(int patientId) {
		// TODO Auto-generated method stub
		return noteRepo.getDoctorNoteHis(patientId);
	}

	@Override
	public void addDoctorNote(DoctorNote doctorNote) {
		
		noteRepo.save(doctorNote);
		
	}

	@Override
	public List<DoctorNote> getTodaysNote(int appointmentId,int userId) {
		// TODO Auto-generated method stub
		return noteRepo.getTodaysNote(appointmentId,userId);
	}

	@Override
	public void deleteDoctorNote(int doctorNoteId) {
       
		noteRepo.deleteById(doctorNoteId);
	}

}
