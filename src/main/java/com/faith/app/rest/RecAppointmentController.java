package com.faith.app.rest;

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

import com.faith.app.entity.Appointment;
import com.faith.app.service.IRecAppointmentService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RecAppointmentController {
	
	@Autowired
	IRecAppointmentService appointmentService;
	
	@GetMapping("/appointments")
	public List<Appointment> listAllAppointments(){
		
		return appointmentService.listOfAppointments();
		
	}
	@PostMapping("/appointments")
	public void addAppointment(@RequestBody Appointment appointment) {
		appointmentService.addTheAppointment(appointment);
		int aid=appointmentService.getMaxAppointId();
		System.out.println(aid);
		Appointment appointments=appointmentService.gettingApDetails(aid);
		System.out.println(appointments);
		
		//System.out.println(appointments.getTokenNo());
		
		int tokennumber=appointmentService.gettingTokenNum(aid);
		System.out.println("token is"+tokennumber);
		
	}
	
    @PutMapping("/appointments")
    public void editAppointment(@RequestBody Appointment appointment) {
    	
    	appointmentService.addTheAppointment(appointment);
    	
    }
    @GetMapping("/appointments/{appId}")
    public Appointment getAppointById(@PathVariable int appId ) {
    	
		return appointmentService.getAppoinmentById(appId);
    	
    }
    @DeleteMapping("/appointments/{apId}")
    public void disAbleAppointment(@PathVariable int apId) {
    	
    	appointmentService.disAbleAppoint(appointmentService.getAppoinmentById(apId));
   
    }
    

}
