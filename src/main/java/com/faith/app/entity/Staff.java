package com.faith.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer staffId;
    
    private String staffRegNo;

    private String staffName;

    private String staffDepartment;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate staffDateOfBirth;

    private String staffGender;

    private String staffBloodGroup;

    private String staffPhoneNo;

    private String staffAddress;

    private String staffQualification;

    private String staffEmail;

    private String isActive;

    @PrePersist
    @PreUpdate
    public void prePersist() {
        if (isActive == null)
            isActive = "true";
    }
    
    private Integer userId;
    @OneToOne
    @JoinColumn(name = "userId",insertable=false,updatable=false)
    private User user;

	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	public String getStaffRegNo() {
		return staffRegNo;
	}
	public void setStaffRegNo(String staffRegNo) {
		this.staffRegNo = staffRegNo;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffDepartment() {
		return staffDepartment;
	}
	public void setStaffDepartment(String staffDepartment) {
		this.staffDepartment = staffDepartment;
	}
	public LocalDate getStaffDateOfBirth() {
		return staffDateOfBirth;
	}
	public void setStaffDateOfBirth(LocalDate staffDateOfBirth) {
		this.staffDateOfBirth = staffDateOfBirth;
	}
	public String getStaffGender() {
		return staffGender;
	}
	public void setStaffGender(String staffGender) {
		this.staffGender = staffGender;
	}
	public String getStaffBloodGroup() {
		return staffBloodGroup;
	}
	public void setStaffBloodGroup(String staffBloodGroup) {
		this.staffBloodGroup = staffBloodGroup;
	}
	public String getStaffPhoneNo() {
		return staffPhoneNo;
	}
	public void setStaffPhoneNo(String staffPhoneNo) {
		this.staffPhoneNo = staffPhoneNo;
	}
	public String getStaffAddress() {
		return staffAddress;
	}
	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}
	public String getStaffQualification() {
		return staffQualification;
	}
	public void setStaffQualification(String staffQualification) {
		this.staffQualification = staffQualification;
	}
	public String getStaffEmail() {
		return staffEmail;
	}
	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", staffRegNo=" + staffRegNo + ", staffName=" + staffName
				+ ", staffDepartment=" + staffDepartment + ", staffDateOfBirth=" + staffDateOfBirth + ", staffGender="
				+ staffGender + ", staffBloodGroup=" + staffBloodGroup + ", staffPhoneNo=" + staffPhoneNo
				+ ", staffAddress=" + staffAddress + ", staffQualification=" + staffQualification + ", staffEmail="
				+ staffEmail + ", isActive=" + isActive + ", userId=" + userId + "]";
	}
	public Staff(Integer staffId, String staffRegNo, String staffName, String staffDepartment,
			LocalDate staffDateOfBirth, String staffGender, String staffBloodGroup, String staffPhoneNo,
			String staffAddress, String staffQualification, String staffEmail, String isActive, Integer userId,
			User user) {
		super();
		this.staffId = staffId;
		this.staffRegNo = staffRegNo;
		this.staffName = staffName;
		this.staffDepartment = staffDepartment;
		this.staffDateOfBirth = staffDateOfBirth;
		this.staffGender = staffGender;
		this.staffBloodGroup = staffBloodGroup;
		this.staffPhoneNo = staffPhoneNo;
		this.staffAddress = staffAddress;
		this.staffQualification = staffQualification;
		this.staffEmail = staffEmail;
		this.isActive = isActive;
		this.userId = userId;
		this.user = user;
	}


}