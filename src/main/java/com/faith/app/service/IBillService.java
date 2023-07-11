package com.faith.app.service;

import java.util.List;

import com.faith.app.entity.TestBill;

public interface IBillService {

	//list
	List<TestBill> getTestBill();

	//add
	void addTestBill(TestBill tbill);

}
