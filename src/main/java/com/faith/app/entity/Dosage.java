package com.faith.app.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Dosage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer dosageId;
	private String dosagePattern;
	private Integer dosageQty;
	
	

	public Dosage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getDosageId() {
		return dosageId;
	}

	public void setDosageId(Integer dosageId) {
		this.dosageId = dosageId;
	}

	public String getDosagePattern() {
		return dosagePattern;
	}

	public void setDosagePattern(String dosagePattern) {
		this.dosagePattern = dosagePattern;
	}

	public Integer getDosageQty() {
		return dosageQty;
	}

	public void setDosageQty(Integer dosageQty) {
		this.dosageQty = dosageQty;
	}



	@Override
	public String toString() {
		return "Dosage [dosageId=" + dosageId + ", dosagePattern=" + dosagePattern + ", dosageQty=" + dosageQty + "]";
	}




	
	
	
	
	

}
