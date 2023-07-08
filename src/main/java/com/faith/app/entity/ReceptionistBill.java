package com.faith.app.entity;

import java.time.LocalDate;

public class ReceptionistBill {
	
	private String billNo;
	private String patientName;
	private String doctorName;
	private String departmentName;
	private int billAmount;
	private int doctorFee;
	private int regFee;
	private LocalDate date;
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
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}
	public int getDoctorFee() {
		return doctorFee;
	}
	public void setDoctorFee(int doctorFee) {
		this.doctorFee = doctorFee;
	}
	public int getRegFee() {
		return regFee;
	}
	public void setRegFee(int regFee) {
		this.regFee = regFee;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public ReceptionistBill() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ReceptionistBill [billNo=" + billNo + ", patientName=" + patientName + ", doctorName=" + doctorName
				+ ", departmentName=" + departmentName + ", billAmount=" + billAmount + ", doctorFee=" + doctorFee
				+ ", regFee=" + regFee + ", date=" + date + "]";
	}
	

}
