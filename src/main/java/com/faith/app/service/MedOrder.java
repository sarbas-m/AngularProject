package com.faith.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.faith.app.entity.MedicineOrder;
import com.faith.app.repo.IMedOrderRepository;


@Service
public class MedOrder implements IMedOrderRep {

	
	@Autowired
	private IMedOrderRepository mediorderrepo;
	
	public List<MedicineOrder> getMedOrder() {
		// TODO Auto-generated method stub
		return (List<MedicineOrder>) mediorderrepo.findAll();
	}

	

	public MedicineOrder saveOrder(MedicineOrder order) {
		
		return mediorderrepo.save(order) ;
	}

}
