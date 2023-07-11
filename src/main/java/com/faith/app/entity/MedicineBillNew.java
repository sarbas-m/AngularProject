package com.faith.app.entity;

import java.time.LocalDate;

public class MedicineBillNew {
	
	private String billNo;
	private  LocalDate date;
	private String patientName;
	private String patientRegNo;
	private String medicineName;
	private int qty;
	private Double medicinePrice;
	private Double perPrice;
	private Double totalPrice;
	
	
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientRegNo() {
		return patientRegNo;
	}
	public void setPatientRegNo(String patientRegNo) {
		this.patientRegNo = patientRegNo;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

	public Double getPerPrice() {
		return perPrice;
	}
	public void setPerPrice(Double perPrice) {
		this.perPrice = perPrice;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public MedicineBillNew() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MedicineBillNew [billNo=" + billNo + ", date=" + date + ", patientName=" + patientName
				+ ", patientRegNo=" + patientRegNo + ", medicineName=" + medicineName + ", qty=" + qty
				+ ", medicinePrice=" + medicinePrice + ", perPrice=" + perPrice + ", totalPrice=" + totalPrice + "]";
	}
	public Double getMedicinePrice() {
		return medicinePrice;
	}
	public void setMedicinePrice(Double medicinePrice) {
		this.medicinePrice = medicinePrice;
	}
	
	
	

}
