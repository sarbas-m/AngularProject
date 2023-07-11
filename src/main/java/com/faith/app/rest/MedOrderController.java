package com.faith.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.entity.MedicineCompany;
import com.faith.app.entity.MedicineOrder;
import com.faith.app.service.IMedOrderRep;

@CrossOrigin  //inorder to avoid port number conflict
@RestController  //@Controller +@Configuration
@RequestMapping("/api")
public class MedOrderController {
	
	@Autowired
	private IMedOrderRep medOrderService;
	
	@GetMapping("order")
	public List<MedicineOrder>getOrder(){
		return medOrderService.getMedOrder();
	}
	
	 
	 @PostMapping("/order") 
	 public void order(@RequestBody MedicineOrder Orderess) { 
		 medOrderService.saveOrder(Orderess); 
		 }

}
