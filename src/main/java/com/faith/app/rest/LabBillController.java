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
import com.faith.app.entity.TestBill;
import com.faith.app.entity.TestBillNew;
import com.faith.app.entity.TestPrescription;
import com.faith.app.service.IBillService;
import com.faith.app.service.ITestPrescriptionService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LabBillController {
	
	@Autowired
	public IBillService billservice;
	
	@Autowired
	private ITestPrescriptionService testpresService;
	
	@GetMapping("bill/{appointmentId}")
	public List<TestBillNew>getAllTestBill(@PathVariable int appointmentId){
		System.out.println("hi");
		List<TestPrescription> listBill=testpresService.getTestPrescriptionHistory(appointmentId);
		/*TestBill testBill=new TestBill();		
		int price=0;
		for(TestPrescription a:listBill){			
			 price=a.getTest().getTestPrice()+price;			
		}
		System.out.println(price);
		
		testBill.setTestBillAmount(price);
		testBill.setAppointmentId(appointmentId);
		TestBillNew
		billservice.addTestBill(testBill);*/
		int totalPrice=0;
		List<TestBillNew> newBill=new ArrayList<TestBillNew>();
		for(TestPrescription b:listBill) {
			TestBillNew bill=new TestBillNew();
			totalPrice=b.getTest().getTestPrice()+totalPrice;
			bill.setBillNo("Test000"+b.getAppointment().getPatientId());
			bill.setDoctorName(b.getAppointment().getDoctor().getDoctorName());
			bill.setPatientName(b.getAppointment().getPatient().getPatientName());
			bill.setPatientRegNo(b.getAppointment().getPatient().getRegistrationNumber());
			bill.setTestName(b.getTest().getTestName());
			bill.setTestPrice(b.getTest().getTestPrice());
			bill.setTotalPrice(totalPrice);
			bill.setBillDate(LocalDate.now());
			newBill.add(bill);
			
		}
		
		System.out.println(newBill);
		return newBill;
		
	}
	
	@PostMapping("bill")
	public void addTestBill(@RequestBody TestBill tbill) {
		billservice.addTestBill(tbill);
	}
	
	

}
