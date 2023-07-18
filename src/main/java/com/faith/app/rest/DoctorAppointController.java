package com.faith.app.rest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.demo.EmailSenderService;
import com.faith.app.entity.Appointment;
import com.faith.app.entity.Diagnos;
import com.faith.app.entity.DoctorNote;
import com.faith.app.entity.MedicinePrescription;
import com.faith.app.entity.TestPrescription;
import com.faith.app.service.IDoctorAppointService;
import com.faith.app.service.IDoctorDiagnosService;
import com.faith.app.service.IDoctorMedicineService;
import com.faith.app.service.IDoctorNoteService;
import com.faith.app.service.IDoctorTestService;

@CrossOrigin // to avoid the conflict btwn the tomcat and angular port numbers
@RestController // it is the compination of @Controller and @Configuration
@RequestMapping("/api")
public class DoctorAppointController {
	
	@Autowired
	private EmailSenderService service;

	@Autowired
	private IDoctorAppointService doctorService;

	@Autowired
	private IDoctorDiagnosService diagnosService;
	@Autowired
	private IDoctorNoteService noteService;

	@Autowired
	private IDoctorMedicineService medicineService;

	@Autowired
	private IDoctorTestService testService;

	@GetMapping("/doctorAppointments/{userId}")

	public List<Appointment> getAppointmentList(@PathVariable int userId) {
        
		return doctorService.getTodaysAppointmentList(userId);

	}
	@GetMapping("/doctorAppointmentsDisable/{userId}")

	public List<Appointment> getDisableAppointmentList(@PathVariable int userId) {
        
		return doctorService.getDisabledAppointmentList(userId);

	}

	@DeleteMapping("/doctorAppointments/{appointmentId}/{userId}")
	public void disable(@PathVariable int appointmentId,@PathVariable int userId) {
       System.out.println("hiiii");
        try {
		List<Diagnos> todayDiagnos = diagnosService.getTodaysDiagnos(appointmentId,userId);
		List<DoctorNote> todayNote = noteService.getTodaysNote(appointmentId,userId);
		List<MedicinePrescription> todayMed = medicineService.getTodaysMedicine(appointmentId,userId);
		List<TestPrescription> todayTest = testService.getTodaysTest(appointmentId,userId);
		
		String diagnos="";
		String note="";
		String med="";
		String medDose="";
		int medDays=0;
		String test="";
		String patientName ="";
		String email="";
		String doctorName="";
		String department="";
		
		for (Diagnos a : todayDiagnos) {
			String diagnosName = a.getDiagnos();
			diagnos+=diagnosName+",";
			patientName=a.getAppointment().getPatient().getPatientName();
			email=a.getAppointment().getPatient().getPatientEmail();
			doctorName=a.getAppointment().getDoctor().getDoctorName();
			department=a.getAppointment().getDoctor().getDepartment().getDepartmentName();
			
		}
		if (!diagnos.isEmpty()) {
			diagnos = diagnos.substring(0, diagnos.length() - 1);
		}
		for (DoctorNote a : todayNote) {
			String noteName = a.getNote();
			note+=noteName+",";
			patientName=a.getAppointment().getPatient().getPatientName();
			email=a.getAppointment().getPatient().getPatientEmail();
			doctorName=a.getAppointment().getDoctor().getDoctorName();
			department=a.getAppointment().getDoctor().getDepartment().getDepartmentName();
		}
		if (!note.isEmpty()) {
			note = note.substring(0, note.length() - 1);
		}
		
		for(TestPrescription a:todayTest) {
			String testName = a.getTest().getTestName();
		    test += testName + ", "; 
			patientName=a.getAppointment().getPatient().getPatientName();
			email=a.getAppointment().getPatient().getPatientEmail();
			doctorName=a.getAppointment().getDoctor().getDoctorName();
			department=a.getAppointment().getDoctor().getDepartment().getDepartmentName();
		}
		if (!test.isEmpty()) {
		    test = test.substring(0, test.length() - 2);
		}
		
		StringBuilder stringBuilder = new StringBuilder();

		// Table header
		stringBuilder.append(String.format("%-35s%-35s%-25s%n", "Medicine", "Dose", "Days"));
		stringBuilder.append("------------------------------------------------------------------------\n");

		// Table rows
		for(MedicinePrescription a:todayMed) {
			med=a.getMedicine().getMedicineName();
			medDose=a.getDosage().getDosagePattern();
			medDays=a.getDays();
			patientName=a.getAppointment().getPatient().getPatientName();
			email=a.getAppointment().getPatient().getPatientEmail();
			doctorName=a.getAppointment().getDoctor().getDoctorName();
			department=a.getAppointment().getDoctor().getDepartment().getDepartmentName();

		    stringBuilder.append(String.format("%-35s%-35s%-25s%n", med, medDose, medDays));
		}
          
		String result = stringBuilder.toString();

		
		String body="Dear "+patientName+",\n"+
		"\nPlease find the doctor consultation summary of "+LocalDate.now()+"\n"+
				"\nDoctor Name : "+doctorName+
				"\n\nDepartment :"+department+
				"\n\n\t\t\t\t\tReport"+
				"\n\t\t\t\t\t======"+
				"\nDiagnos :"+diagnos+
				"\n\nTest :"+test+
				"\n\nDoctor Note :"+note+"\n\n"+
				result+
				"\n\nSincerely,\nDr."+doctorName+",Med Star Hospital";
		System.out.println(email);
		String sub="Consultation Report("+LocalDate.now()+")";
		System.out.println(body);
		service.sendSimpleEmail(email, body, sub);
        }catch(Exception e) {
        	System.out.println(e);
        }

        doctorService.disableAppoint(appointmentId);
		
	}

}
