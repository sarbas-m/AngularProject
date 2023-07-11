package com.faith.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.entity.MedicineCompany;
import com.faith.app.service.IMedCompany;


@CrossOrigin  //inorder to avoid port number conflict
@RestController  //@Controller +@Configuration
@RequestMapping("/api")
public class MedCompanyController {
	
	@Autowired
	private IMedCompany companyService;
	
	
	
	@GetMapping("/medcompanys")
	public List<MedicineCompany>getMedicine(){
		return companyService.getCompany();
	}
	
	
	@GetMapping("/medcompanys/{id}")
	public MedicineCompany getCompany(@PathVariable int companyId) {
		return companyService.getCompany(companyId);
	}
	
	
	  
	 
	 @PostMapping("/medcompanys") 
	 public void medcompanys(@RequestBody MedicineCompany company) { 
		 companyService.saveCompany(company); 
		 }
	

	
	
	@PutMapping("/medcompanys")
	public void updateCompany(@RequestBody MedicineCompany company) {
		companyService.saveCompany(company);
}

	
	@DeleteMapping("/medcompanys/{companyId}")
	public void deleteCompany(@PathVariable int companyId) {
		System.out.println("hi");
		companyService.deleteCompany(companyId);
	
	}
	 
	
	@GetMapping("/medcompanys/search/{name}")
	public List<MedicineCompany>getAllCompanyByName(@PathVariable String companyName){
		return companyService.getCompanyByName(companyName);
	}

}
