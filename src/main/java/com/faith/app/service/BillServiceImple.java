package com.faith.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.entity.TestBill;
import com.faith.app.repo.IBillRepository;

@Service
public class BillServiceImple implements IBillService{
	
	@Autowired
	private IBillRepository billrepo;

	public List<TestBill> getTestBill() {
		return (List<TestBill>) billrepo.findAll();
	}

	public void addTestBill(TestBill tbill) {
		billrepo.save(tbill);
	}

}
