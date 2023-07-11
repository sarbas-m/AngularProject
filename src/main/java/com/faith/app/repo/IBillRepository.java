package com.faith.app.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faith.app.entity.TestBill;

@Repository
public interface IBillRepository extends CrudRepository<TestBill,Integer>{

	
}
