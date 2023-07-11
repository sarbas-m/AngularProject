package com.faith.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.faith.app.entity.MedicineCompany;
import com.faith.app.repo.IMedCompanyRepository;

@Service
public class CompanuServiceImple implements IMedCompany {
	
	
	@Autowired
	private IMedCompanyRepository CompanyRepo;

	public List<MedicineCompany> getCompany() {
		// TODO Auto-generated method stub
		return (List<MedicineCompany>) CompanyRepo.findAll();
	}

	
	public MedicineCompany saveCompany(MedicineCompany company) {
		// TODO Auto-generated method stub
		return CompanyRepo.save(company);
	}


	public MedicineCompany getCompany(int companyId) {
		// TODO Auto-generated method stub
		return CompanyRepo.findById(companyId).orElseThrow(() -> new RuntimeException("Company not found for id" + companyId));
	}

	
	public void deleteCompany(int companyId) {
		CompanyRepo.deleteById(companyId);
		

	}

	
	public List<MedicineCompany> getCompanyByName(String companyName) {
		// TODO Auto-generated method stub
		return null;
	}

}
