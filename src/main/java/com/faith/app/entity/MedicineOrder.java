package com.faith.app.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class MedicineOrder {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Integer orderId;
 private Integer orderQty;
 private LocalDate orderOn;
 
 
 
 @PrePersist
 @PreUpdate
 public void prePersist() {
	 if(orderOn==null) {
		 orderOn=LocalDate.now();
	 }
	
 }
 private Integer medicineId;
 @ManyToOne
 @JoinColumn(name="medicineId",insertable=false,updatable=false)
 private Medicine medicine;
 
 private Integer companyId;
 @ManyToOne
 @JoinColumn(name="companyId",insertable=false,updatable=false)
 private MedicineCompany medicineCompany;



public MedicineOrder(Integer orderId, Integer orderQty, LocalDate orderOn, Integer medicineId, Medicine medicine,
		Integer companyId, MedicineCompany medicineCompany) {
	super();
	this.orderId = orderId;
	this.orderQty = orderQty;
	this.orderOn = orderOn;
	this.medicineId = medicineId;
	this.medicine = medicine;
	this.companyId = companyId;
	this.medicineCompany = medicineCompany;
}



public MedicineOrder() {
	super();
	// TODO Auto-generated constructor stub
}



public Integer getOrderId() {
	return orderId;
}



public void setOrderId(Integer orderId) {
	this.orderId = orderId;
}



public Integer getOrderQty() {
	return orderQty;
}



public void setOrderQty(Integer orderQty) {
	this.orderQty = orderQty;
}



public LocalDate getOrderOn() {
	return orderOn;
}



public void setOrderOn(LocalDate orderOn) {
	this.orderOn = orderOn;
}



public Integer getMedicineId() {
	return medicineId;
}



public void setMedicineId(Integer medicineId) {
	this.medicineId = medicineId;
}



public Medicine getMedicine() {
	return medicine;
}



public void setMedicine(Medicine medicine) {
	this.medicine = medicine;
}



public Integer getCompanyId() {
	return companyId;
}



public void setCompanyId(Integer companyId) {
	this.companyId = companyId;
}



public MedicineCompany getMedicineCompany() {
	return medicineCompany;
}



public void setMedicineCompany(MedicineCompany medicineCompany) {
	this.medicineCompany = medicineCompany;
}
 
 
 
}
