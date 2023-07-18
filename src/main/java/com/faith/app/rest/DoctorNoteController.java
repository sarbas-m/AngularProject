package com.faith.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.entity.DoctorNote;
import com.faith.app.service.IDoctorNoteService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class DoctorNoteController {
	
	@Autowired
	private IDoctorNoteService noteService;
	
	@GetMapping("doctorNote/{patientId}")
	public List<DoctorNote> getNoteHistory(@PathVariable int patientId){
		
		return noteService.getDoctorNoteHis(patientId);
		
	}
	@GetMapping("doctorNoteToday/{appointmentId}/{userId}")
	public List<DoctorNote> getNoteTodayHistory(@PathVariable int appointmentId,@PathVariable int userId){
		
		return noteService.getTodaysNote(appointmentId,userId);
		
	}
	@PostMapping("doctorNote")
	public void addDoctorNote(@RequestBody DoctorNote doctorNote) {
		
		System.out.println(doctorNote);
		
		noteService.addDoctorNote(doctorNote);
		
	}
	@DeleteMapping("doctorNote/{doctorNoteId}")
	public void deleteDoctorNote(@PathVariable int doctorNoteId) {
		noteService.deleteDoctorNote(doctorNoteId);
	}
	

}
