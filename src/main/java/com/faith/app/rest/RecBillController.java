package com.faith.app.rest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.entity.Appointment;
import com.faith.app.entity.PatientBill;
import com.faith.app.entity.ReceptionistBill;
import com.faith.app.service.IRecAppointmentService;
import com.faith.app.service.IRecBillService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RecBillController {

	@Autowired
	private IRecBillService recbillservice;

	@Autowired

	IRecAppointmentService appointmentService;

	@GetMapping("/bills/{patientId}")
	public List<ReceptionistBill> getBillByapId(@PathVariable int patientId) {

		
		List<ReceptionistBill>forBillReception=new ArrayList<ReceptionistBill>();
		ReceptionistBill recBill= new ReceptionistBill();
		List<Appointment>appointList= recbillservice.listAppointmentsByPid(patientId);
		System.out.println(appointList.toString());
		String pName=appointList.get(0).getPatient().getPatientName();
		//String doctorName=appointList.get(0).getDoctor().getDoctorName();
		int regFee=150;
		int doctorFee=0;

		
		for(int i=0;i<appointList.size();i++) {
			
			//String doctorName=appointList.get(i).getDoctor().getDoctorName();
			 doctorFee=appointList.get(i).getDoctor().getDoctorConsultationFee()+doctorFee;
			LocalDate patientRegDate=appointList.get(i).getPatient().getPatientCreatedOn();
			if(patientRegDate.isBefore(LocalDate.now())) {
				regFee=0;
			}
			
		}
		int totalFee=doctorFee+regFee;
		String bullnum="MSP000"+patientId;
		recBill.setPatientName(pName);
		recBill.setRegFee(regFee);
		recBill.setDoctorFee(doctorFee);
		recBill.setBillAmount(totalFee);
		recBill.setBillNo(bullnum);
		recBill.setDate(LocalDate.now());
		
		forBillReception.add(recBill);
		
		

		return forBillReception;

	}

	@PostMapping("/bills")
	public void addBillController(@RequestBody PatientBill patientBill) {

		/*
		 * int appointId=patientBill.getAppointmentId(); Appointment appoin=
		 * appointmentService.getAppoinmentById(appointId); int
		 * consultationfee=appoin.getDoctor().getDoctorConsultationFee(); int
		 * billfee=consultationfee+150; patientBill.setPatientBillAmount(billfee);
		 * recbillservice.addBill(patientBill);
		 */
		// int consultfee=appointment.getDoctor().getDoctorConsultationFee();
		// int billFee=consultfee+100;

		// patientBill.setPatientBillAmount(billFee);

		// recbillservice.addBill(patientBill);
		/*int totalFee = 0;

		int appointId = patientBill.getAppointmentId();
		Appointment appoin = appointmentService.getAppoinmentById(appointId);

		int patientId = appoin.getPatient().getPatientId();
		List<Appointment> appoinmentList = appointmentService.listAppointByPatient(patientId);
		for (int i = 0; i < appoinmentList.size(); i++) {
			int consulfee = appoinmentList.get(i).getDoctor().getDoctorConsultationFee();
			totalFee = consulfee + 150 + consulfee;

		}

		patientBill.setPatientBillAmount(totalFee);
		recbillservice.addBill(patientBill);*/
	}
}
