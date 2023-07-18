package com.faith.app.rest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.demo.EmailSenderService;
import com.faith.app.entity.Appointment;
import com.faith.app.entity.Department;
import com.faith.app.entity.Doctor;
import com.faith.app.entity.Patient;
import com.faith.app.service.IRecAppointmentService;
import com.faith.app.service.IRecDepartmentService;
import com.faith.app.service.IRecDoctorsService;
import com.faith.app.service.IRecPatientService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RecAppointmentController {

	@Autowired
	IRecAppointmentService appointmentService;

	@Autowired
	private EmailSenderService service;
	
	@Autowired
	private IRecPatientService patientservice;
	
	@Autowired
	private IRecDoctorsService recDoctorService;
	
	@Autowired
	private IRecDepartmentService recdepartmentservice;

	@GetMapping("/appointments")
	public List<Appointment> listAllAppointments() {

		return appointmentService.listOfAppointments();

	}

	@PostMapping("/appointments")
	public void addAppointment(@RequestBody Appointment appointment) {
		appointmentService.addTheAppointment(appointment);
		int aid = appointmentService.getMaxAppointId();
		System.out.println(aid);
		Appointment appointments = appointmentService.gettingApDetails(aid);
		System.out.println(appointments);

		// System.out.println(appointments.getTokenNo());
		try {
			int tokennumber = appointmentService.gettingTokenNum(aid);
			int patientId=appointments.getPatientId();
			Patient patient=patientservice.getPatientByTheId(patientId);
			
			
			String patientName = patient.getPatientName();
			Doctor doctor=recDoctorService.getDoctorById(appointments.getDoctorId());
			String doctorName = doctor.getDoctorName();
			Department department=recdepartmentservice.getDepartmentById(appointments.getDepartmentId());
			
			String departmentName = department.getDepartmentName();
			LocalDateTime date = appointments.getAppCreatedOn();

			String email = patient.getPatientEmail();
			String sub = "APPOINTMENT DETAILS(" + LocalDate.now() + ")";
			String body = "Dear " + patientName + ",\n" + "\nPlease find the appointment details:"
					+ "\n\nDoctor Name : " + doctorName + "\n\nDepartment :" + departmentName + "\n\nTime :" + date
					+ "\n\nToken No :" + tokennumber + "\n\n\nSincerely," + "\nAkash\nReceptionist,Med Star Hospital";

			service.sendSimpleEmail(email, body, sub);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@PutMapping("/appointments")
	public void editAppointment(@RequestBody Appointment appointment) {

		appointmentService.addTheAppointment(appointment);

	}

	@GetMapping("/appointments/{appId}")
	public Appointment getAppointById(@PathVariable int appId) {

		return appointmentService.getAppoinmentById(appId);

	}

	@DeleteMapping("/appointments/{apId}")
	public void disAbleAppointment(@PathVariable int apId) {

		appointmentService.disAbleAppoint(appointmentService.getAppoinmentById(apId));

	}

}
