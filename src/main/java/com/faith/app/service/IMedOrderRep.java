package com.faith.app.service;

import java.util.List;


import com.faith.app.entity.MedicineOrder;

public interface IMedOrderRep {
	
	//list
	public List<MedicineOrder> getMedOrder();
	
	//Insert
	public MedicineOrder saveOrder(MedicineOrder order);
	
	
	

}
