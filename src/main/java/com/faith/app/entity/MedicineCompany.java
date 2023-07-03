package com.faith.app.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class MedicineCompany {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Integer companyId;
 private String companyNumber;
 private String companyName;
 private LocalDate companyCreatedOn;
 
 

@PrePersist
 @PreUpdate
 public void prePersist() {
	 if(companyCreatedOn==null) {
		 companyCreatedOn=LocalDate.now();
	 }
	
 }




public Integer getCompanyId() {
	return companyId;
}

public void setCompanyId(Integer companyId) {
	this.companyId = companyId;
}

public String getCompanyNumber() {
	return companyNumber;
}

public void setCompanyNumber(String companyNumber) {
	this.companyNumber = companyNumber;
}

public String getCompanyName() {
	return companyName;
}

public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

public LocalDate getCompanyCreatedOn() {
	return companyCreatedOn;
}

public void setCompanyCreatedOn(LocalDate companyCreatedOn) {
	this.companyCreatedOn = companyCreatedOn;
}




public MedicineCompany() {
	super();
	// TODO Auto-generated constructor stub
}




@Override
public String toString() {
	return "MedicineCompany [companyId=" + companyId + ", companyNumber=" + companyNumber + ", companyName="
			+ companyName + ", companyCreatedOn=" + companyCreatedOn + "]";
}


	
	
 
}