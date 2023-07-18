package com.faith.app.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faith.app.entity.MedicineOrder;

@Repository
public interface IMedOrderRepository extends CrudRepository<MedicineOrder, Integer>  {
	
	
	

}
