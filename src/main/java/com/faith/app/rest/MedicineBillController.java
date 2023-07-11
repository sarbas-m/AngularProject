package com.faith.app.rest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.entity.Medicine;
import com.faith.app.entity.MedicineBill;
import com.faith.app.entity.MedicineBillNew;
import com.faith.app.entity.MedicinePrescription;
import com.faith.app.service.IMedPresService;
import com.faith.app.service.IMedicineBill;
import com.faith.app.service.IMedicineService;

@CrossOrigin  //inorder to avoid port number conflict
@RestController  //@Controller +@Configuration
@RequestMapping("/api")
public class MedicineBillController {
	
	
	@Autowired
	private IMedPresService medPresService;
	
	@Autowired
	private IMedicineService medicineService;
	
	@Autowired
	private IMedicineBill billService;
	
	@GetMapping("medidcineBill/{appointmentId}")
	public List<MedicineBillNew> getMedicineBill(@PathVariable int appointmentId){
		
		/*MedicineBill saveBill=new MedicineBill();
		
		List<MedicinePrescription> billList=medPresService.getPresHistory(appointmentId);
		System.out.println(billList);
		int qty=0;
		Double price=0.0;
		
		for(MedicinePrescription a:billList){
		qty=a.getDays()*a.getDosage().getDosageQty();
			price=qty*a.getMedicine().getPrice()+price;
			
		}
		saveBill.setMedicineBillAmount(price);
		billService.saveMedicineBill(saveBill);*/
		int qty=0;
		Double totalPrice=0.0;
		Double perMedPrice=0.0;
		List<MedicinePrescription> billList=medPresService.getPresHistory(appointmentId);
		List<MedicineBillNew> list=new ArrayList<MedicineBillNew>();
		for(MedicinePrescription a:billList) {
			qty=a.getDays()*a.getDosage().getDosageQty();
			perMedPrice=qty*a.getMedicine().getPrice();
			totalPrice=qty*a.getMedicine().getPrice()+totalPrice;
			Medicine med=new Medicine();
			if(a.getMedicine().getQuantity()>qty) {
				med.setCompanyId(a.getMedicine().getCompanyId());
				med.setMedicineId(a.getMedicineId());
				med.setMedicineIsActive(a.getMedicine().getMedicineIsActive());
				med.setMedicineName(a.getMedicine().getMedicineName());
				med.setMedicineNumber(a.getMedicine().getMedicineNumber());
				med.setPrice(a.getMedicine().getPrice());
				med.setQuantity(a.getMedicine().getQuantity()-qty);
				medicineService.saveMedicine(med);
				
			}
			
		MedicineBillNew bill=new MedicineBillNew();	
		int patientId=billList.get(0).getAppointment().getPatient().getPatientId();	
		bill.setBillNo("CMS000"+patientId);
		bill.setPatientName(a.getAppointment().getPatient().getPatientName());
		bill.setDate(LocalDate.now());
		bill.setMedicineName(a.getMedicine().getMedicineName());
		bill.setMedicinePrice(a.getMedicine().getPrice());
		bill.setPatientRegNo(a.getAppointment().getPatient().getRegistrationNumber());
		bill.setPerPrice(perMedPrice);
		bill.setQty(qty);
		bill.setTotalPrice(totalPrice);
		bill.setMedicinePrice(a.getMedicine().getPrice());
		list.add(bill);		
		}
		System.out.println(list);
		return list ;
		
	}
	
	
	

}
