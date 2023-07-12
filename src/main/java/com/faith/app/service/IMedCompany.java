package com.faith.app.service;

import java.util.List;

import com.faith.app.entity.MedicineCompany;



public interface IMedCompany {
	
	//list
			public List<MedicineCompany> getCompany();
			
			//Insert
			public MedicineCompany saveCompany(MedicineCompany company);
			
			//update by id
			public MedicineCompany getCompany(int companyId);
			
			//Delete
			public void deleteCompany(int companyId);
			
			//find by employee name
			public List<MedicineCompany> getCompanyByName(String companyName);
			

}
