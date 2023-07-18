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

import com.faith.app.demo.EmailSenderService;
import com.faith.app.entity.Medicine;
import com.faith.app.entity.MedicineBill;
import com.faith.app.entity.MedicineBillNew;
import com.faith.app.entity.MedicineOrder;
import com.faith.app.entity.MedicinePrescription;
import com.faith.app.service.IMedOrderRep;
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
	
	@Autowired
	private EmailSenderService service;
	
	@Autowired
	private IMedOrderRep reOrderService;
	
	@GetMapping("medidcineBill/{appointmentId}")
	public List<MedicineBillNew> getMedicineBill(@PathVariable int appointmentId){
		System.out.println("bill"+appointmentId);
		int qty=0;
		Double totalPrice=0.0;
		Double perMedPrice=0.0;
		List<MedicinePrescription> billList=medPresService.getPresHistory(appointmentId);
		List<MedicineBillNew> list=new ArrayList<MedicineBillNew>();
		String patientName="";
		String email="";
		String billNo="";
		String patientRegNo="";
		String medicineName="";
		Double medPrice=0.0;
		
		StringBuilder stringBuilder = new StringBuilder();

		// Table header
		stringBuilder.append(String.format("%-35s%-25s%-25s%-25s%n", "MedicineName","price","Qty","Total"));
		stringBuilder.append("-----------------------------------------------------------------------------------------\n");
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
				int reQty=0;
				for(MedicineOrder b:reOrderService.getMedOrder()) {					
				   if(b.getMedicineId()==1) {
					   reQty=b.getOrderQty()+reQty;
				   }				
				}
				
				if(a.getMedicine().getMedicineId()==1) {
					if(a.getMedicine().getQuantity()+reQty<500) {
						MedicineOrder reOrder=new MedicineOrder();
						reOrder.setCompanyId(a.getMedicine().getCompanyId());
						reOrder.setMedicineId(a.getMedicineId());
						reOrder.setOrderQty(150);
						reOrderService.saveOrder(reOrder);						
					}
				}
				
			}
			
		MedicineBillNew bill=new MedicineBillNew();	
		int patientId=billList.get(0).getAppointment().getPatient().getPatientId();	
		bill.setBillNo("MS000"+patientId);
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
		patientName=a.getAppointment().getPatient().getPatientName();
		billNo="MS000"+patientId;
		patientRegNo=a.getAppointment().getPatient().getRegistrationNumber();
		medPrice=a.getMedicine().getPrice();
		medicineName=a.getMedicine().getMedicineName();
		email=a.getAppointment().getPatient().getPatientEmail();
		stringBuilder.append(String.format("%-35s%-25s%-25s%-25s%n",medicineName,medPrice,qty,perMedPrice));
		}
		String result = stringBuilder.toString();
		
		String body="Dear "+patientName+","+
		"\n\nPlease find the MedicineBill Details"+
				"\n\nBill No : "+billNo+
				"\n\nPatient Reg.No: "+patientRegNo+
				"\n\nDate :"+LocalDate.now()+
		         "\n\n"+result+
		         "\n\nTotal Price ="+totalPrice+
		         "\n\nSincerely,\nRagul\nPharmacist,Med Star Hospital";
		String sub="Medicine Bill("+LocalDate.now()+")";
		try {
		service.sendSimpleEmail(email, body, sub);
		}catch(Exception e) {
			System.out.println(e);
		}
		return list ;
		

	}
}
