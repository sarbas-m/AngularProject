package com.faith.app.entity;

import java.time.LocalDate;

public class TestBillNew {
 
	private String billNo;
	private String patientName;
	private String doctorName;
	private String patientRegNo;
	private String testName;
	private int testPrice;
	private int totalPrice;
	private LocalDate billDate;
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getPatientRegNo() {
		return patientRegNo;
	}
	public void setPatientRegNo(String patientRegNo) {
		this.patientRegNo = patientRegNo;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public int getTestPrice() {
		return testPrice;
	}
	public void setTestPrice(int testPrice) {
		this.testPrice = testPrice;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public TestBillNew() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TestBillNew [billNo=" + billNo + ", patientName=" + patientName + ", doctorName=" + doctorName
				+ ", patientRegNo=" + patientRegNo + ", testName=" + testName + ", testPrice=" + testPrice
				+ ", totalPrice=" + totalPrice + "]";
	}
	public LocalDate getBillDate() {
		return billDate;
	}
	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}
	

}
