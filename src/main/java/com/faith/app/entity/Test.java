package com.faith.app.entity;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Test {
	
	//primary key
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer testId;
	private String testNumber;
	private String testName;
	private Integer lowRange;
	private Integer highRange;
	private String Unit;
	private Integer testPrice;
	private String isActive;
	private LocalDate testCreatedOn;
	
	@PrePersist
	@PreUpdate
	public void prePersist() {
		if(isActive==null) { //we set default value in case if the value is not set yet
			isActive="true";
		}
		if(testCreatedOn==null) {
			testCreatedOn=LocalDate.now();
		}
		}
	@JsonBackReference
	@OneToMany(mappedBy="test")
	List<TestPrescription>testPrescription;

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public String getTestNumber() {
		return testNumber;
	}

	public void setTestNumber(String testNumber) {
		this.testNumber = testNumber;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Integer getLowRange() {
		return lowRange;
	}

	public void setLowRange(Integer lowRange) {
		this.lowRange = lowRange;
	}

	public Integer getHighRange() {
		return highRange;
	}

	public void setHighRange(Integer highRange) {
		this.highRange = highRange;
	}

	public String getUnit() {
		return Unit;
	}

	public void setUnit(String unit) {
		Unit = unit;
	}

	public Integer getTestPrice() {
		return testPrice;
	}

	public void setTestPrice(Integer testPrice) {
		this.testPrice = testPrice;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public LocalDate getTestCreatedOn() {
		return testCreatedOn;
	}

	public void setTestCreatedOn(LocalDate testCreatedOn) {
		this.testCreatedOn = testCreatedOn;
	}

	public List<TestPrescription> getTestPrescription() {
		return testPrescription;
	}

	public void setTestPrescription(List<TestPrescription> testPrescription) {
		this.testPrescription = testPrescription;
	}

	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testNumber=" + testNumber + ", testName=" + testName + ", lowRange="
				+ lowRange + ", highRange=" + highRange + ", Unit=" + Unit + ", testPrice=" + testPrice + ", isActive="
				+ isActive + ", testCreatedOn=" + testCreatedOn + "]";
	}

	public Test(Integer testId, String testNumber, String testName, Integer lowRange, Integer highRange, String unit,
			Integer testPrice, String isActive, LocalDate testCreatedOn, List<TestPrescription> testPrescription) {
		super();
		this.testId = testId;
		this.testNumber = testNumber;
		this.testName = testName;
		this.lowRange = lowRange;
		this.highRange = highRange;
		Unit = unit;
		this.testPrice = testPrice;
		this.isActive = isActive;
		this.testCreatedOn = testCreatedOn;
		this.testPrescription = testPrescription;
	}
	


}
