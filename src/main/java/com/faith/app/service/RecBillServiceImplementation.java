package com.faith.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.entity.Appointment;
import com.faith.app.entity.PatientBill;
import com.faith.app.repo.IRecBillRepo;

@Service
public class RecBillServiceImplementation implements IRecBillService{
	
	@Autowired
	private IRecBillRepo recbillrepo;

	@Override
	public PatientBill getTheBillById(int apppid) {
		// TODO Auto-generated method stub
		return recbillrepo.findById(apppid).orElseThrow(() -> new RuntimeException("patient not found"+apppid));
	}

	@Override
	public PatientBill addBill(PatientBill bills) {
		// TODO Auto-generated method stub
		
		return recbillrepo.save(bills);
		
	}

	@Override
	public List<PatientBill> gettingTheBillByApId(int appoinId) {
		// TODO Auto-generated method stub
		System.out.println("khjgfxghj");
		System.out.println(recbillrepo.gettingTheBillByApId(appoinId).indexOf(0));
		return recbillrepo.gettingTheBillByApId(appoinId);
	}

	/*@Override
	public int  getMaxBillId() {
		// TODO Auto-generated method stub
		return recbillrepo.getMaxBillId();
	}*/

	@Override
	public Optional<PatientBill> getPatientBillbyBillId(int patientBillId) {
		// TODO Auto-generated method stub
		return recbillrepo.findById(patientBillId);
	}

	@Override
	public List<Appointment> listAppointmentsByPid(int patientId) {
		// TODO Auto-generated method stub
		return recbillrepo.listAppointmentsByPid(patientId);
	}

	

}
