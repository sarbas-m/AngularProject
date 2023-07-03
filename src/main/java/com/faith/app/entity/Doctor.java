package com.faith.app.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;

    private String doctorRegNo;
    
    @Column(nullable = false)
    private String doctorName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate doctorDateOfBirth;

    @Column(nullable = false)
    private String doctorGender;

    private String doctorBloodGroup;
    
    @Column(nullable = false)
    private String doctorPhoneNo;

    private String doctorAddress;

    @Column(nullable = false)
    private String doctorQualification;

    @Column(nullable = false)
    private String doctorEmail;

    

    private int doctorConsultationFee;

    private String isActive;

    @PrePersist
    @PreUpdate
    public void prePersist() {
        if (isActive == null)
            isActive = "true";
    }
    
 
    private Integer userId;
	@OneToOne
    @JoinColumn(name="userId",insertable=false,updatable=false)
    private User user;
	
	private Integer departmentId;
	@ManyToOne
    @JoinColumn(name="departmentId",insertable=false,updatable=false)
    private Department department;
    
	@OneToMany(mappedBy="doctor")
	private List<Appointment> appointment;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorRegNo() {
		return doctorRegNo;
	}

	public void setDoctorRegNo(String doctorRegNo) {
		this.doctorRegNo = doctorRegNo;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public LocalDate getDoctorDateOfBirth() {
		return doctorDateOfBirth;
	}

	public void setDoctorDateOfBirth(LocalDate doctorDateOfBirth) {
		this.doctorDateOfBirth = doctorDateOfBirth;
	}

	public String getDoctorGender() {
		return doctorGender;
	}

	public void setDoctorGender(String doctorGender) {
		this.doctorGender = doctorGender;
	}

	public String getDoctorBloodGroup() {
		return doctorBloodGroup;
	}

	public void setDoctorBloodGroup(String doctorBloodGroup) {
		this.doctorBloodGroup = doctorBloodGroup;
	}

	public String getDoctorPhoneNo() {
		return doctorPhoneNo;
	}

	public void setDoctorPhoneNo(String doctorPhoneNo) {
		this.doctorPhoneNo = doctorPhoneNo;
	}

	public String getDoctorAddress() {
		return doctorAddress;
	}

	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}

	public String getDoctorQualification() {
		return doctorQualification;
	}

	public void setDoctorQualification(String doctorQualification) {
		this.doctorQualification = doctorQualification;
	}

	public String getDoctorEmail() {
		return doctorEmail;
	}

	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}

	public int getDoctorConsultationFee() {
		return doctorConsultationFee;
	}

	public void setDoctorConsultationFee(int doctorConsultationFee) {
		this.doctorConsultationFee = doctorConsultationFee;
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

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorRegNo=" + doctorRegNo + ", doctorName=" + doctorName
				+ ", doctorDateOfBirth=" + doctorDateOfBirth + ", doctorGender=" + doctorGender + ", doctorBloodGroup="
				+ doctorBloodGroup + ", doctorPhoneNo=" + doctorPhoneNo + ", doctorAddress=" + doctorAddress
				+ ", doctorQualification=" + doctorQualification + ", doctorEmail=" + doctorEmail
				+ ", doctorConsultationFee=" + doctorConsultationFee + ", isActive=" + isActive + ", userId=" + userId
				+ ", user=" + user + ", departmentId=" + departmentId + ", department=" + department + ", appointment="
				+ appointment + "]";
	}

	
}